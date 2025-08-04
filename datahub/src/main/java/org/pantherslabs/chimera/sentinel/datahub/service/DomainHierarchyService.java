package org.pantherslabs.chimera.sentinel.datahub.service;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.linkedin.common.AuditStamp;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringMap;
import com.linkedin.domain.DomainProperties;
import com.linkedin.mxe.MetadataChangeProposal;
import com.linkedin.events.metadata.ChangeType;

import org.pantherslabs.chimera.sentinel.datahub.mapper.generated.MetadataAspectV2DynamicSqlSupport;
import org.pantherslabs.chimera.sentinel.datahub.mapper.generated.MetadataAspectV2Mapper;
import org.pantherslabs.chimera.sentinel.datahub.dto.*;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.dto.FilterCondition;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.mapper.GenericMapper;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.serializeAspect;
import static org.pantherslabs.chimera.sentinel.datahub.mapper.generated.MetadataAspectV2DynamicSqlSupport.aspect;

@Service
public class DomainHierarchyService {
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    @Autowired
    private GenericMapper genericMapper;

    public EmitResult createDomainHierarchy(@Valid Domains domain, String actionType) throws Exception {
        List<MetadataChangeProposal> proposals = new ArrayList<>();
        buildProposalsRecursively(domain, actionType, null, proposals);
        return emitEvent(proposals);
    }

    private void buildProposalsRecursively(Domains domain, String actionType, String parentName, List<MetadataChangeProposal> proposals) throws Exception {
        Urn domainUrn = Urn.createFromString(DOMAINS_ASPECT_PREFIX + domain.getName().toLowerCase());

        DomainProperties props = new DomainProperties()
                .setName(domain.getName())
                .setDescription(domain.getDocumentation())
                .setCreated(new AuditStamp()
                        .setActor(new CorpuserUrn(SYSTEM_ACTOR))
                        .setTime(Instant.now().toEpochMilli())
                );

        if (domain.getCustomProperties() != null) {
            StringMap customProps = new StringMap();
            customProps.putAll(domain.getCustomProperties());
            props.setCustomProperties(customProps);
        }

        if (parentName != null) {
            props.setParentDomain(Urn.createFromString(DOMAINS_ASPECT_PREFIX + parentName.toLowerCase()));
        }

        // Create domain-level ownership if specified
        if (domain.getDomainOwners() != null && !domain.getDomainOwners().isEmpty()) {
            Urn domainUrns = Urn.createFromString(DOMAINS_ASPECT_PREFIX + domain.getName().toLowerCase());

            // Convert Map<String, String> to Map<String, List<String>> if needed
            Map<String, List<String>> ownersInfo = domain.getDomainOwners().entrySet().stream()
                    .collect(Collectors.toMap(
                            Map.Entry::getKey,
                            e -> Collections.singletonList(e.getValue())
                    ));

            OwnershipService.createOwners(domainUrns, DOMAIN_ENTITY_NAME, ownersInfo, actionType);
        }

        MetadataChangeProposal proposal = new MetadataChangeProposal();
        proposal.setEntityType(DOMAIN_ENTITY_NAME);
        proposal.setEntityUrn(domainUrn);
        proposal.setAspectName(DOMAIN_PROPERTIES_ASPECT_NAME);
        proposal.setChangeType(ChangeType.UPSERT);
        proposal.setAspect(serializeAspect(props));

        proposals.add(proposal);

        if (domain.getDomainHierarchy() != null) {
            for (Domains child : domain.getDomainHierarchy()) {
                buildProposalsRecursively(child, actionType, domain.getName(), proposals);
            }
        }
    }

    @Autowired
    private MetadataAspectV2Mapper metadataAspectV2Mapper;

    public EmitResult deleteDomain(String domainName) throws Exception {

        EmitResult emitResult = null;
        Urn domainUrn = Urn.createFromString(DOMAINS_ASPECT_PREFIX + domainName);
        List<FilterCondition> filters = List.of(
                new FilterCondition("urn", "=", List.of(domainUrn))
        );
        String customSQL = String.format("""
                WITH RECURSIVE domain_hierarchy AS (
                    SELECT urn, metadata, NULL::varchar AS parent_urn, 0 AS level
                FROM metadata_aspect_v2
                WHERE aspect = 'domainProperties' AND urn = '%s'
                UNION ALL
                    SELECT child.urn, child.metadata, dh.urn AS parent_urn,dh.level + 1 AS level
                    FROM metadata_aspect_v2 child  JOIN domain_hierarchy dh
                      ON child.aspect = 'domainProperties'
                     AND child.metadata LIKE CONCAT('%%"parentDomain":"', dh.urn, '"%%')
                    )
                SELECT dh.parent_urn, dh.urn AS child_urn, dh.level, ma.aspect FROM 
                 domain_hierarchy dh JOIN metadata_aspect_v2 ma ON dh.urn = ma.urn
                ORDER BY dh.level DESC""", domainUrn);

        List<Map<String, Object>> result = genericMapper.executeDynamicFilterQuery(customSQL, filters);

        if (result == null || result.isEmpty()) {
            return new EmitResult(false, new ErrorDetails(404, "Domain " + domainUrn + " doesn't exists.."));
        }

        // Step 1: Sort by "level" in descending order
        result.sort((a, b) -> {
            Integer levelA = (Integer) a.getOrDefault("level", 0);
            Integer levelB = (Integer) b.getOrDefault("level", 0);
            return Integer.compare(levelB, levelA); // Descending
        });
        int status = 0;
        // Step 2: Delete each child urn (assuming a deleteDomainByUrn method exists)
        for (Map<String, Object> row : result) {
            String urn = (String) row.get("child_urn");
            Urn deleteUrn = Urn.createFromString(urn);
            if (!urn.isEmpty()) {
                try {
                    status = metadataAspectV2Mapper.delete(c ->
                            c.where(MetadataAspectV2DynamicSqlSupport.urn, isEqualTo(deleteUrn.toString())));

                    if (status <= 0) {
                        emitResult = new EmitResult(false, new ErrorDetails(404, "URN: " + urn + ", Aspect: " + aspect.toString()));
                    }
                    System.out.println("Status for URN " + urn + " is " + status);
                    emitResult = new EmitResult(true, null);
                } catch (Exception e) {
                    System.err.println("❌ Failed to delete " + urn + ": " + e.getMessage());
                    emitResult = new EmitResult(false, new ErrorDetails(500, "Exception" + e.getMessage()));
                }
            }
        }
        return emitResult;
    }

}

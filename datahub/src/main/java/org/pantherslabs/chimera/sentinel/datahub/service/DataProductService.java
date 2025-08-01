
package org.pantherslabs.chimera.sentinel.datahub.service;

import javax.validation.constraints.Null;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.linkedin.common.*;
import com.linkedin.common.url.Url;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.GlossaryTermUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringMap;
import com.linkedin.dataproduct.DataProductAssociation;
import com.linkedin.dataproduct.DataProductAssociationArray;
import com.linkedin.dataproduct.DataProductKey;
import com.linkedin.dataproduct.DataProductProperties;
import com.linkedin.domain.Domains;
import com.linkedin.mxe.MetadataChangeProposal;
import datahub.shaded.org.apache.commons.lang3.ArrayUtils;
import datahub.shaded.org.apache.commons.lang3.StringUtils;
import datahub.shaded.org.apache.commons.lang3.tuple.Pair;
import static com.linkedin.data.template.SetMode.REMOVE_IF_NULL;


import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.replaceSpecialCharsAndLowercase;

public class DataProductService {
    List<MetadataChangeProposal> proposals = new ArrayList<>();

    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(DataProductService.class);
    String LoggerTag = "[DataHub- Create DataProduct] -";


    /**
     * @param dataProductName        Name of The Data Product which needs to be created
     * @param dataProductDescription Description of Data Product can be Long String or MD5 Document Content
     * @param externalURL            External URL which needs to be mapped
     * @param domainName             Valid domain with which this newly data product needs to be mapped
     * @param globalTags             Global tags array, which needs to be added with Data product
     * @param glossaryTerms          Glossary Terms array, which needs to be added with Data product
     * @param DataAssets             Data Assets <Name, Type and Platform> information in Map<String, Pair<String,String>>
     * @param Owners                 Owners Information in Map<ownerName, ownershipType>
     * @param customProperties       User Defined Properties in Map<PropertyName, PropertyValue>
     * @return URN of Data Product e.g. urn:li:dataProduct:DataProductName
     */

    public EmitResult createDataProduct(String dataProductName,
                                        String dataProductDescription,
                                        @Null String externalURL,
                                        @Null String domainName,
                                        @Null Map<String, String> globalTags,
                                        @Null String[] glossaryTerms,
                                        @Null Map<String, Pair<String, String>> DataAssets,
                                        @Null Map<String, String> Owners,
                                        @Null Map<String, String> customProperties)  {
        System.setProperty("CHIMERA_EXE_ENV", "datahub");
        try {
            DatahubLogger.logInfo(LoggerTag + "Creating Data Product " + dataProductName);

            Urn dataProductUrn = Urn.createFromString(DATA_PRODUCTS_URN_PREFIX + replaceSpecialCharsAndLowercase(dataProductName));

            DataProductKey dataProductKey = new DataProductKey().
                    setId(replaceSpecialCharsAndLowercase(dataProductName));
            DatahubLogger.logInfo(LoggerTag + "Adding Data Product With Key " + dataProductKey);

            DataProductProperties dataProductProperties = new DataProductProperties()
                    .setName(dataProductName)
                    .setDescription(dataProductDescription);
            DatahubLogger.logInfo(LoggerTag + "Setting Data Product Properties...");

            if (externalURL != null && !externalURL.isEmpty()) {
                DatahubLogger.logInfo(LoggerTag + "Setting External URL With Data Product...");
                dataProductProperties.setExternalUrl(new Url(externalURL), REMOVE_IF_NULL);
            }

            if (customProperties != null && !customProperties.isEmpty()) {
                DatahubLogger.logInfo(LoggerTag + "Setting User Defined Custom Properties With Data Product...");
                StringMap MapCustomProperties = new StringMap();
                MapCustomProperties.putAll(customProperties);
                dataProductProperties.setCustomProperties(MapCustomProperties);
            }

            DatahubLogger.logInfo(LoggerTag + "Setting Audit Information's With Data Product...");
            AuditStamp createdStamp = new AuditStamp()
                    .setActor(new CorpuserUrn("data_creator"))
                    .setTime(Instant.now().toEpochMilli());

            if (DataAssets != null && !DataAssets.isEmpty()) {
                DatahubLogger.logInfo(LoggerTag + "Mapping Assets With Data Product...");
                DataProductAssociationArray dataProductAssociationArray = new DataProductAssociationArray();
                for (Map.Entry<String, Pair<String, String>> entry : DataAssets.entrySet()) {
                    String name = entry.getKey();
                    Pair<String, String> typePlatformPair = entry.getValue();
                    String type = typePlatformPair.getLeft();     // Extract type
                    String platform = typePlatformPair.getRight(); // Extract platform

                    // Construct URN string
                    String urnString = String.format("urn:li:%s:(%s,%s)", type, platform, name);

                    // Create URN object
                    Urn urn = Urn.createFromString(urnString);

                    // Create DataProductAssociation
                    DataProductAssociation dataProductAssociation = new DataProductAssociation()
                            .setCreated(createdStamp)
                            .setLastModified(createdStamp)
                            .setDestinationUrn(urn);

                    // Add to the DataProductAssociationArray
                    dataProductAssociationArray.add(dataProductAssociation);
                    DatahubLogger.logInfo(LoggerTag + String.format("Assets Type %s, Platform Name %s and Assets Name %s mapped" +
                            " With Data Product.", type, platform, name));
                }
                dataProductProperties.setAssets(dataProductAssociationArray);
            }
            proposals.add(buildProposal(dataProductUrn, DATA_PRODUCT_PROPERTIES_ASPECT_NAME, dataProductProperties, ACTION_TYPE));

            if (Owners != null && !Owners.isEmpty()) {
                DatahubLogger.logInfo(LoggerTag + "Mapping Owners Information's with Data Product");

                Map<String, List<String>> ownersInfo = new HashMap<>();
                for (Map.Entry<String, String> entry : Owners.entrySet()) {
                    String ownerName = entry.getKey();
                    String ownerType = entry.getValue();
                    ownersInfo.computeIfAbsent(ownerType, k -> new ArrayList<>()).add(ownerName);
                }
                OwnershipService.createOwners(dataProductUrn, DATA_PRODUCT_ENTITY_NAME, ownersInfo, ACTION_TYPE);
            }


            if (domainName != null && !domainName.isEmpty()) {
                DatahubLogger.logInfo(LoggerTag + "Mapping Data Product With Domain " + domainName);
                String domainUrnString = DOMAINS_ASPECT_PREFIX + domainName;

                UrnArray DomainUrn = new UrnArray();
                DomainUrn.add(Urn.createFromString(domainUrnString));
                Domains domains = new Domains().setDomains(DomainUrn);
                proposals.add(buildProposal(dataProductUrn, DOMAINS_ASPECT_NAME, domains, ACTION_TYPE));
                DatahubLogger.logInfo(LoggerTag + "Mapping Data Product With Domain Completed");
            }

            if (!globalTags.isEmpty()) {
                DatahubLogger.logInfo(LoggerTag + "Mapping Global Tags With Data Product");
                GlobalTagService globalTagService = new GlobalTagService();
                globalTagService.createGlobalTags(String.valueOf(dataProductUrn), globalTags, ACTION_TYPE);
                DatahubLogger.logInfo(LoggerTag + "Mapping Global Tags With Data Product Completed With ");
            } else {
                DatahubLogger.logInfo("GlobalTags array is null or empty.");
            }

            if (glossaryTerms != null && ArrayUtils.isNotEmpty(glossaryTerms)) {
                GlossaryTermAssociationArray glossaryTermAssociationArray = new GlossaryTermAssociationArray();

                DatahubLogger.logInfo(LoggerTag + "Mapping Glossary Terms Tags Data Product");

                for (String glossaryTerm : glossaryTerms) {
                    if (StringUtils.isNotBlank(glossaryTerm)) {
                        DatahubLogger.logInfo(LoggerTag + String.format("Mapping Glossary Term %s With Data Product", glossaryTerm));
                        GlossaryTermUrn glossaryTermUrn = GlossaryTermUrn.createFromString(GLOSSARY_TERM_URN_PREFIX + glossaryTerm);
                        GlossaryTermAssociation termAssociation = new GlossaryTermAssociation()
                                .setUrn(glossaryTermUrn);
                        glossaryTermAssociationArray.add(termAssociation);
                    }
                }
                GlossaryTerms glossaryTerm = new GlossaryTerms()
                        .setTerms(glossaryTermAssociationArray).setAuditStamp(createdStamp);

                proposals.add(buildProposal(dataProductUrn, GLOSSARY_TERMS_ASPECT_NAME, glossaryTerm, ACTION_TYPE));

                DatahubLogger.logInfo(LoggerTag + "Mapping Glossary Terms Tags Data Product Completed ");
            } else {
                System.out.println("Glossary Terms array is null or empty.");
            }
        } catch (Exception e) {
            DatahubLogger.logError(" Data Product Creation Failed ");
            throw new RuntimeException("Failed to create data product", e);
        }
        return emitEvent(proposals);
    }

    public EmitResult addAssetToDataProduct(String dataProductName, String assetsName) throws Exception {
        proposals.clear();
        AuditStamp createdStamp = new AuditStamp()
                .setActor(new CorpuserUrn("data_creator"))
                .setTime(Instant.now().toEpochMilli());

        DataProductAssociationArray dataProductAssociationArray = new DataProductAssociationArray();
        DataProductAssociation dataProductAssociation = new DataProductAssociation()
                .setCreated(createdStamp)
                .setLastModified(createdStamp)
                .setDestinationUrn(Urn.createFromString(assetsName));
        Urn dataProductUrn = Urn.createFromString(DATA_PRODUCTS_URN_PREFIX + replaceSpecialCharsAndLowercase(dataProductName));
        // Add to the DataProductAssociationArray
        dataProductAssociationArray.add(dataProductAssociation);
        DataProductProperties dataProductProperties = new DataProductProperties()
                .setName(dataProductName)
                .setAssets(dataProductAssociationArray);
        proposals.add(buildProposal(dataProductUrn, DATA_PRODUCT_PROPERTIES_ASPECT_NAME, dataProductProperties, ACTION_TYPE));
        DatahubLogger.logInfo(LoggerTag + "Setting Data Product Properties ");
        return emitEvent(proposals);
    }
}

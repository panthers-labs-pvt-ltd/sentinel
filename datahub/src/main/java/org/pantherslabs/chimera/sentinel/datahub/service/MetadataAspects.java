package org.pantherslabs.chimera.sentinel.datahub.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import org.springframework.beans.factory.annotation.Autowired;

import org.pantherslabs.chimera.sentinel.datahub.mapper.generated.MetadataAspectV2DynamicSqlSupport;
import org.pantherslabs.chimera.sentinel.datahub.mapper.generated.MetadataAspectV2Mapper;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.dto.FilterCondition;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.mapper.GenericMapper;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.pantherslabs.chimera.unisca.utilities.ChimeraUtils;


@Service
public class MetadataAspects {
    static ChimeraLogger DCSLogger = ChimeraLoggerFactory.getLogger(MetadataAspects.class);

    @Autowired
    private GenericMapper genericMapper;

    public List<Map<String, Object>> getAspectsMetadata(String tableName, List<FilterCondition> filters) {
        List<Map<String, Object>> results = genericMapper.executeDynamicFilterQuery(tableName, filters);
        DCSLogger.logInfo(results.size() + " Aspects found with provided filters " + filters.toString());
        if (results.isEmpty()) {
            return null;  // ✅ return null if no records
        }
        return results.stream()
                .map(ChimeraUtils::convertKeysToCamelCase)
                .collect(Collectors.toList());

    }

    @Autowired
    private MetadataAspectV2Mapper metadataAspectV2Mapper;

    public int deleteByUrn(String inputUrn) {
        return metadataAspectV2Mapper.delete(c ->
                c.where(MetadataAspectV2DynamicSqlSupport.urn, isEqualTo(inputUrn))
        );
    }
}
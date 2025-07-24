package org.pantherslabs.chimera.sentinel.datahub.api.service;

import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.dto.FilterCondition;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.mapper.GenericMapper;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.pantherslabs.chimera.unisca.utilities.ChimeraUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
}
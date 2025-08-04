package org.pantherslabs.chimera.sentinel.datahub.service;

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
public class DataControlLogService {
    static ChimeraLogger DCSLogger = ChimeraLoggerFactory.getLogger(DataControlLogService.class);

    @Autowired
    private GenericMapper genericMapper;

    public List<Map<String, Object>>selectFromTable(String tableName, List<FilterCondition> filters) {
        List<Map<String, Object>> results = genericMapper.executeDynamicFilterQuery(tableName, filters);
        if (results.isEmpty()) {
            DCSLogger.logError("No Data found with provided filters " + filters.toString());
            throw new ChimeraException("APIException.404",
                    Map.of("exception", "No Data found with provided filters " + filters.toString()),
                    null,
                    HttpStatus.NOT_FOUND);
        }

        DCSLogger.logInfo(results.size() + " Data found with provided filters " + filters.toString());
        return results.stream()
                .map(ChimeraUtils::convertKeysToCamelCase)
                .collect(Collectors.toList());

    }
}
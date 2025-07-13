package org.pantherslabs.chimera.sentinel.data_quality.api.service;

import org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated.DataControlsLogMapper;
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataControlsLog;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public class DataControlsLogService {

    private final DataControlsLogMapper dataControlsLogMapper;

    @Autowired
    public DataControlsLogService(DataControlsLogMapper dataControlsLogMapper) {
        this.dataControlsLogMapper = dataControlsLogMapper;
    }

    /**
     * Inserts multiple data control log records into the database.
     *
     * @param records Collection of DataControlsLog records
     * @return number of rows inserted
     */
    public int insertMultipleLogs(Collection<DataControlsLog> records) {
        if (records == null || records.isEmpty()) {
            throw new ChimeraException(
                    "APIException.404",
                    Map.of("exception", "No records to insert"),
                    null,
                    HttpStatus.NO_CONTENT
            );
        }
        return dataControlsLogMapper.insertMultiple(records);
    }
}

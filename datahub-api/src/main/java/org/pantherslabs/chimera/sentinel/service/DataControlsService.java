package org.pantherslabs.chimera.sentinel.service;

import java.sql.Timestamp;
import java.time.Instant;

import org.pantherslabs.chimera.sentinel.datahub.datasets.ManageDatasets;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.pantherslabs.chimera.sentinel.mapper.generated.DataControlsMapper;
import org.pantherslabs.chimera.sentinel.model.generated.DataControls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.select;
import static org.pantherslabs.chimera.sentinel.mapper.generated.DataControlsDynamicSqlSupport.dataControls;

@Service
public class DataControlsService {
    static ChimeraLogger DCSLogger = ChimeraLoggerFactory.getLogger(DataControlsService.class);

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentUsername = (authentication != null) ? authentication.getName() : System.getProperty("user.name");

    @Autowired
    private DataControlsMapper dataControlsMapper;

/*
    public DataControls getControlById(Short id) {
        DCSLogger.logInfo("Getting Data Control for " + id);
        return dataControlsMapper.selectByPrimaryKey(id).orElse(null);
    }
*/

    public DataControls getControlById(Short id) {
        return dataControlsMapper.selectByPrimaryKey(id)
                .orElseThrow(() -> new ChimeraException("APIException.404",
                        Map.of("exception", "Control Id " + id.toString() + " Not Found"),
                        null,
                        HttpStatus.NOT_FOUND));
    }
        public List<DataControls> getAllControls() {
        SelectStatementProvider selectStatement = select(DataControlsMapper.selectList)
                .from(dataControls)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return dataControlsMapper.selectMany(selectStatement);
    }

    public DataControls createControl(DataControls control) {
        control.setCreatedTs(new Timestamp(System.currentTimeMillis()));
        control.setCreatedBy(currentUsername);
        dataControlsMapper.insert(control);
        return control;
    }

    public DataControls updateControl(Short id, DataControls updatedControl) {
        Optional<DataControls> existing = dataControlsMapper.selectByPrimaryKey(id);

        if (existing.isPresent()) {
            updatedControl.setControlId(id);
            updatedControl.setUpdatedBy(currentUsername);
            updatedControl.setUpdatedTs(new Timestamp(System.currentTimeMillis()));
            dataControlsMapper.updateByPrimaryKeySelective(updatedControl);
            return getControlById(id);
        }
        return null;
    }

    public boolean deleteControl(Short id) {
        // Delete the DataControls record if it exists
        Optional<DataControls> existing = dataControlsMapper.selectByPrimaryKey(id);
        if (existing.isPresent()) {
            dataControlsMapper.deleteByPrimaryKey(id);
            return true;
        }
        return false;
    }
}
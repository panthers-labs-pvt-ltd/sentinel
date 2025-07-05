package org.pantherslabs.chimera.sentinel.service;

import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.pantherslabs.chimera.sentinel.mapper.generated.DataControlsMapper;
import org.pantherslabs.chimera.sentinel.model.generated.DataControls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.select;
import static org.pantherslabs.chimera.sentinel.mapper.generated.DataControlsDynamicSqlSupport.dataControls;

@Service
public class DataControlsService {

    @Autowired
    private DataControlsMapper dataControlsMapper;

    public DataControls getControlById(Short id) {
        // Returns the DataControls object with the given id, or null if not found
        return dataControlsMapper.selectByPrimaryKey(id).orElse(null);
    }

    public List<DataControls> getAllControls() {
        SelectStatementProvider selectStatement = select(DataControlsMapper.selectList)
                .from(dataControls)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return dataControlsMapper.selectMany(selectStatement);
    }

    public DataControls createControl(DataControls control) {
        dataControlsMapper.insert(control);
        return control;
    }

    public DataControls updateControl(Short id, DataControls updatedControl) {
        // Update the DataControls record if it exists
        Optional<DataControls> existing = dataControlsMapper.selectByPrimaryKey(id);
        if (existing.isPresent()) {
            updatedControl.setControlId(id);
            dataControlsMapper.updateByPrimaryKey(updatedControl);
            return updatedControl;
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
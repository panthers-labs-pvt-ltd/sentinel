package org.pantherslabs.chimera.sentinel.dataquality.controls;

import org.pantherslabs.chimera.sentinel.dataquality.entities.DQRulesEntity;
import org.pantherslabs.chimera.sentinel.dataquality.entities.DQUserConfigEntity;
import org.pantherslabs.chimera.sentinel.dataquality.entities.DataControlsLogEntity;
import org.pantherslabs.chimera.sentinel.dataquality.repository.DQRepository;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;

public abstract class DataControls {
    private DQRepository<DataControlsLogEntity> dataControlsLogRepository;

    public abstract boolean validate();

    public int registerResult(DataControlsLogEntity controlResults) {
        DataControlsLogEntity dataControlsLogEntity = new DataControlsLogEntity();
        InsertStatementProvider<DataControlsLogEntity> insertStatement =
                SqlBuilder.insert(controlResults)
                        .into(dataControlsLogEntity)
                        .build()
                        .render(RenderingStrategies.MYBATIS3);
        return dataControlsLogRepository.insert(insertStatement);
    }
}

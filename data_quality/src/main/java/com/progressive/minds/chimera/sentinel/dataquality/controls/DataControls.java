package com.progressive.minds.chimera.sentinel.dataquality.controls;

import com.progressive.minds.chimera.dataquality.entities.DQRulesEntity;
import com.progressive.minds.chimera.dataquality.entities.DQUserConfigEntity;
import com.progressive.minds.chimera.dataquality.entities.DataControlsLogEntity;
import com.progressive.minds.chimera.dataquality.repository.DQRepository;
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

package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import lombok.Data;

@Data
public class DataQualityVw {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850230926Z", comments="Source field: sentinel.data_quality_vw.rownum")
    private Long rownum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850287029Z", comments="Source field: sentinel.data_quality_vw.process_name")
    private String processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850406836Z", comments="Source field: sentinel.data_quality_vw.control_name")
    private String controlName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850453638Z", comments="Source field: sentinel.data_quality_vw.dimension_name")
    private String dimensionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850563945Z", comments="Source field: sentinel.data_quality_vw.rule_name")
    private String ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850613847Z", comments="Source field: sentinel.data_quality_vw.rule_column")
    private String ruleColumn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850695352Z", comments="Source field: sentinel.data_quality_vw.rule_value")
    private String ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850743755Z", comments="Source field: sentinel.data_quality_vw.database_name")
    private String databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850810659Z", comments="Source field: sentinel.data_quality_vw.schema_name")
    private String schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.85101927Z", comments="Source field: sentinel.data_quality_vw.table_name")
    private String tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.851074573Z", comments="Source field: sentinel.data_quality_vw.partition_keys")
    private String partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.851121376Z", comments="Source field: sentinel.data_quality_vw.check_level")
    private String checkLevel;
}
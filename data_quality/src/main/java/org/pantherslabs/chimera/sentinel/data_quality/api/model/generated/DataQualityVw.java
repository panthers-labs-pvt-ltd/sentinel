package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import lombok.Data;

@Data
public class DataQualityVw {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.696900448Z", comments="Source field: sentinel.data_quality_vw.rownum")
    private Long rownum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.696964152Z", comments="Source field: sentinel.data_quality_vw.process_name")
    private String processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.697009982Z", comments="Source field: sentinel.data_quality_vw.control_name")
    private String controlName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69705517Z", comments="Source field: sentinel.data_quality_vw.dimension_name")
    private String dimensionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69710045Z", comments="Source field: sentinel.data_quality_vw.rule_name")
    private String ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.697144264Z", comments="Source field: sentinel.data_quality_vw.rule_column")
    private String ruleColumn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.697187894Z", comments="Source field: sentinel.data_quality_vw.rule_value")
    private String ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.697231157Z", comments="Source field: sentinel.data_quality_vw.database_name")
    private String databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.697273413Z", comments="Source field: sentinel.data_quality_vw.schema_name")
    private String schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.697316676Z", comments="Source field: sentinel.data_quality_vw.table_name")
    private String tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69735884Z", comments="Source field: sentinel.data_quality_vw.partition_keys")
    private String partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.697401461Z", comments="Source field: sentinel.data_quality_vw.check_level")
    private String checkLevel;
}
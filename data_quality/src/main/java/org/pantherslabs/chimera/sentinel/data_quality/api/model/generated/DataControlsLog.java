package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControlsLog {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853056185Z", comments="Source field: sentinel.data_controls_log.log_id")
    private Long logId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853106587Z", comments="Source field: sentinel.data_controls_log.batch_id")
    private String batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.85314699Z", comments="Source field: sentinel.data_controls_log.control_type")
    private String controlType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853186892Z", comments="Source field: sentinel.data_controls_log.control_dimension")
    private String controlDimension;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853236995Z", comments="Source field: sentinel.data_controls_log.process_type")
    private String processType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853274697Z", comments="Source field: sentinel.data_controls_log.database_name")
    private String databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853311899Z", comments="Source field: sentinel.data_controls_log.schema_name")
    private String schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853349701Z", comments="Source field: sentinel.data_controls_log.table_name")
    private String tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853388203Z", comments="Source field: sentinel.data_controls_log.partition_keys")
    private String partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853425705Z", comments="Source field: sentinel.data_controls_log.business_date")
    private Date businessDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853464408Z", comments="Source field: sentinel.data_controls_log.rule_column")
    private String ruleColumn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.85350131Z", comments="Source field: sentinel.data_controls_log.rule_name")
    private String ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853539212Z", comments="Source field: sentinel.data_controls_log.rule_value")
    private String ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853576214Z", comments="Source field: sentinel.data_controls_log.check_level")
    private String checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853613516Z", comments="Source field: sentinel.data_controls_log.constraint_desc")
    private String constraintDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853651418Z", comments="Source field: sentinel.data_controls_log.constraint_msg")
    private String constraintMsg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.85369032Z", comments="Source field: sentinel.data_controls_log.status")
    private String status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853734423Z", comments="Source field: sentinel.data_controls_log.execution_ts")
    private Date executionTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853770325Z", comments="Source field: sentinel.data_controls_log.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853804427Z", comments="Source field: sentinel.data_controls_log.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853845029Z", comments="Source field: sentinel.data_controls_log.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853880031Z", comments="Source field: sentinel.data_controls_log.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.853914433Z", comments="Source field: sentinel.data_controls_log.reserved_1")
    private String reserved1;
}
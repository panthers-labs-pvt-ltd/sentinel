package org.pantherslabs.chimera.sentinel.datahub.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControlsLog {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.609712412Z", comments="Source field: public.data_controls_log.log_id")
    private Long logId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.609815317Z", comments="Source field: public.data_controls_log.batch_id")
    private String batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.609928344Z", comments="Source field: public.data_controls_log.control_type")
    private String controlType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.610011381Z", comments="Source field: public.data_controls_log.control_dimension")
    private String controlDimension;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.610186076Z", comments="Source field: public.data_controls_log.process_type")
    private String processType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.610318315Z", comments="Source field: public.data_controls_log.database_name")
    private String databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.610513816Z", comments="Source field: public.data_controls_log.schema_name")
    private String schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.610642213Z", comments="Source field: public.data_controls_log.table_name")
    private String tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.610891229Z", comments="Source field: public.data_controls_log.partition_keys")
    private String partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.611099851Z", comments="Source field: public.data_controls_log.business_date")
    private Date businessDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.611302943Z", comments="Source field: public.data_controls_log.rule_column")
    private String ruleColumn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.611387854Z", comments="Source field: public.data_controls_log.rule_name")
    private String ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.611540431Z", comments="Source field: public.data_controls_log.rule_value")
    private String ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.611678856Z", comments="Source field: public.data_controls_log.check_level")
    private String checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.611777075Z", comments="Source field: public.data_controls_log.constraint_desc")
    private String constraintDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.611856269Z", comments="Source field: public.data_controls_log.constraint_msg")
    private String constraintMsg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.611950177Z", comments="Source field: public.data_controls_log.status")
    private String status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.612030964Z", comments="Source field: public.data_controls_log.execution_ts")
    private Date executionTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.612113251Z", comments="Source field: public.data_controls_log.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.612245303Z", comments="Source field: public.data_controls_log.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.612419436Z", comments="Source field: public.data_controls_log.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.612539492Z", comments="Source field: public.data_controls_log.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.612625809Z", comments="Source field: public.data_controls_log.reserved_1")
    private String reserved1;
}
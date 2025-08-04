package org.pantherslabs.chimera.sentinel.datahub.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataControlsLogDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.612787102Z", comments="Source Table: public.data_controls_log")
    public static final DataControlsLog dataControlsLog = new DataControlsLog();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613055611Z", comments="Source field: public.data_controls_log.log_id")
    public static final SqlColumn<Long> logId = dataControlsLog.logId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613099191Z", comments="Source field: public.data_controls_log.batch_id")
    public static final SqlColumn<String> batchId = dataControlsLog.batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613138928Z", comments="Source field: public.data_controls_log.control_type")
    public static final SqlColumn<String> controlType = dataControlsLog.controlType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613211843Z", comments="Source field: public.data_controls_log.control_dimension")
    public static final SqlColumn<String> controlDimension = dataControlsLog.controlDimension;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613268075Z", comments="Source field: public.data_controls_log.process_type")
    public static final SqlColumn<String> processType = dataControlsLog.processType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613318684Z", comments="Source field: public.data_controls_log.database_name")
    public static final SqlColumn<String> databaseName = dataControlsLog.databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613354392Z", comments="Source field: public.data_controls_log.schema_name")
    public static final SqlColumn<String> schemaName = dataControlsLog.schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613390006Z", comments="Source field: public.data_controls_log.table_name")
    public static final SqlColumn<String> tableName = dataControlsLog.tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613425151Z", comments="Source field: public.data_controls_log.partition_keys")
    public static final SqlColumn<String> partitionKeys = dataControlsLog.partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613462827Z", comments="Source field: public.data_controls_log.business_date")
    public static final SqlColumn<Date> businessDate = dataControlsLog.businessDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613499565Z", comments="Source field: public.data_controls_log.rule_column")
    public static final SqlColumn<String> ruleColumn = dataControlsLog.ruleColumn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613536866Z", comments="Source field: public.data_controls_log.rule_name")
    public static final SqlColumn<String> ruleName = dataControlsLog.ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613606032Z", comments="Source field: public.data_controls_log.rule_value")
    public static final SqlColumn<String> ruleValue = dataControlsLog.ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613643801Z", comments="Source field: public.data_controls_log.check_level")
    public static final SqlColumn<String> checkLevel = dataControlsLog.checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613703688Z", comments="Source field: public.data_controls_log.constraint_desc")
    public static final SqlColumn<String> constraintDesc = dataControlsLog.constraintDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613740614Z", comments="Source field: public.data_controls_log.constraint_msg")
    public static final SqlColumn<String> constraintMsg = dataControlsLog.constraintMsg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613782976Z", comments="Source field: public.data_controls_log.status")
    public static final SqlColumn<String> status = dataControlsLog.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613821027Z", comments="Source field: public.data_controls_log.execution_ts")
    public static final SqlColumn<Date> executionTs = dataControlsLog.executionTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613887287Z", comments="Source field: public.data_controls_log.reserved_5")
    public static final SqlColumn<String> reserved5 = dataControlsLog.reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613926087Z", comments="Source field: public.data_controls_log.reserved_4")
    public static final SqlColumn<String> reserved4 = dataControlsLog.reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.613963388Z", comments="Source field: public.data_controls_log.reserved_3")
    public static final SqlColumn<String> reserved3 = dataControlsLog.reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.614003407Z", comments="Source field: public.data_controls_log.reserved_2")
    public static final SqlColumn<String> reserved2 = dataControlsLog.reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.61404052Z", comments="Source field: public.data_controls_log.reserved_1")
    public static final SqlColumn<String> reserved1 = dataControlsLog.reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.612846239Z", comments="Source Table: public.data_controls_log")
    public static final class DataControlsLog extends AliasableSqlTable<DataControlsLog> {
        public final SqlColumn<Long> logId = column("log_id", JDBCType.BIGINT);

        public final SqlColumn<String> batchId = column("batch_id", JDBCType.VARCHAR);

        public final SqlColumn<String> controlType = column("control_type", JDBCType.VARCHAR);

        public final SqlColumn<String> controlDimension = column("control_dimension", JDBCType.VARCHAR);

        public final SqlColumn<String> processType = column("process_type", JDBCType.VARCHAR);

        public final SqlColumn<String> databaseName = column("database_name", JDBCType.VARCHAR);

        public final SqlColumn<String> schemaName = column("schema_name", JDBCType.VARCHAR);

        public final SqlColumn<String> tableName = column("table_name", JDBCType.VARCHAR);

        public final SqlColumn<String> partitionKeys = column("partition_keys", JDBCType.VARCHAR);

        public final SqlColumn<Date> businessDate = column("business_date", JDBCType.DATE);

        public final SqlColumn<String> ruleColumn = column("rule_column", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleName = column("rule_name", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleValue = column("rule_value", JDBCType.VARCHAR);

        public final SqlColumn<String> checkLevel = column("check_level", JDBCType.VARCHAR);

        public final SqlColumn<String> constraintDesc = column("constraint_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> constraintMsg = column("constraint_msg", JDBCType.VARCHAR);

        public final SqlColumn<String> status = column("status", JDBCType.VARCHAR);

        public final SqlColumn<Date> executionTs = column("execution_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> reserved5 = column("reserved_5", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved4 = column("reserved_4", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved3 = column("reserved_3", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved2 = column("reserved_2", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved1 = column("reserved_1", JDBCType.VARCHAR);

        public DataControlsLog() {
            super("\"public\".\"data_controls_log\"", DataControlsLog::new);
        }
    }
}
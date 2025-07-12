package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataControlsLogDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687234081Z", comments="Source Table: sentinel.data_controls_log")
    public static final DataControlsLog dataControlsLog = new DataControlsLog();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687324641Z", comments="Source field: sentinel.data_controls_log.log_id")
    public static final SqlColumn<Long> logId = dataControlsLog.logId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687382295Z", comments="Source field: sentinel.data_controls_log.batch_id")
    public static final SqlColumn<String> batchId = dataControlsLog.batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687415201Z", comments="Source field: sentinel.data_controls_log.process_name")
    public static final SqlColumn<String> processName = dataControlsLog.processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687442974Z", comments="Source field: sentinel.data_controls_log.control_id")
    public static final SqlColumn<String> controlId = dataControlsLog.controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687475055Z", comments="Source field: sentinel.data_controls_log.control_name")
    public static final SqlColumn<String> controlName = dataControlsLog.controlName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687502369Z", comments="Source field: sentinel.data_controls_log.control_dim_id")
    public static final SqlColumn<String> controlDimId = dataControlsLog.controlDimId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687663049Z", comments="Source field: sentinel.data_controls_log.control_dim_name")
    public static final SqlColumn<String> controlDimName = dataControlsLog.controlDimName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687706221Z", comments="Source field: sentinel.data_controls_log.start_ts")
    public static final SqlColumn<Date> startTs = dataControlsLog.startTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687758651Z", comments="Source field: sentinel.data_controls_log.end_ts")
    public static final SqlColumn<Date> endTs = dataControlsLog.endTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687793848Z", comments="Source field: sentinel.data_controls_log.status_desc")
    public static final SqlColumn<String> statusDesc = dataControlsLog.statusDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687857277Z", comments="Source field: sentinel.data_controls_log.status")
    public static final SqlColumn<String> status = dataControlsLog.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687276611Z", comments="Source Table: sentinel.data_controls_log")
    public static final class DataControlsLog extends AliasableSqlTable<DataControlsLog> {
        public final SqlColumn<Long> logId = column("log_id", JDBCType.BIGINT);

        public final SqlColumn<String> batchId = column("batch_id", JDBCType.VARCHAR);

        public final SqlColumn<String> processName = column("process_name", JDBCType.VARCHAR);

        public final SqlColumn<String> controlId = column("control_id", JDBCType.VARCHAR);

        public final SqlColumn<String> controlName = column("control_name", JDBCType.VARCHAR);

        public final SqlColumn<String> controlDimId = column("control_dim_id", JDBCType.VARCHAR);

        public final SqlColumn<String> controlDimName = column("control_dim_name", JDBCType.VARCHAR);

        public final SqlColumn<Date> startTs = column("start_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> endTs = column("end_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> statusDesc = column("status_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> status = column("status", JDBCType.VARCHAR);

        public DataControlsLog() {
            super("\"sentinel\".\"data_controls_log\"", DataControlsLog::new);
        }
    }
}
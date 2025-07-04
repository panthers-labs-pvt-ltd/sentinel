package org.pantherslabs.chimera.sentinel.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataControlsLogDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.957791693Z", comments="Source Table: public.data_controls_log")
    public static final DataControlsLog dataControlsLog = new DataControlsLog();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.958154394Z", comments="Source field: public.data_controls_log.data_controls_log_id")
    public static final SqlColumn<Long> dataControlsLogId = dataControlsLog.dataControlsLogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.958446095Z", comments="Source field: public.data_controls_log.batch_id")
    public static final SqlColumn<String> batchId = dataControlsLog.batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.958556295Z", comments="Source field: public.data_controls_log.process_typ_nm")
    public static final SqlColumn<String> processTypNm = dataControlsLog.processTypNm;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.958662895Z", comments="Source field: public.data_controls_log.control_id")
    public static final SqlColumn<Short> controlId = dataControlsLog.controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.959145396Z", comments="Source field: public.data_controls_log.start_ts")
    public static final SqlColumn<Date> startTs = dataControlsLog.startTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.959602597Z", comments="Source field: public.data_controls_log.end_ts")
    public static final SqlColumn<Date> endTs = dataControlsLog.endTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.960650199Z", comments="Source field: public.data_controls_log.status_desc")
    public static final SqlColumn<String> statusDesc = dataControlsLog.statusDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.9607864Z", comments="Source field: public.data_controls_log.status")
    public static final SqlColumn<String> status = dataControlsLog.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.957974994Z", comments="Source Table: public.data_controls_log")
    public static final class DataControlsLog extends AliasableSqlTable<DataControlsLog> {
        public final SqlColumn<Long> dataControlsLogId = column("data_controls_log_id", JDBCType.BIGINT);

        public final SqlColumn<String> batchId = column("batch_id", JDBCType.VARCHAR);

        public final SqlColumn<String> processTypNm = column("process_typ_nm", JDBCType.VARCHAR);

        public final SqlColumn<Short> controlId = column("control_id", JDBCType.SMALLINT);

        public final SqlColumn<Date> startTs = column("start_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> endTs = column("end_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> statusDesc = column("status_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> status = column("status", JDBCType.VARCHAR);

        public DataControlsLog() {
            super("\"public\".\"data_controls_log\"", DataControlsLog::new);
        }
    }
}
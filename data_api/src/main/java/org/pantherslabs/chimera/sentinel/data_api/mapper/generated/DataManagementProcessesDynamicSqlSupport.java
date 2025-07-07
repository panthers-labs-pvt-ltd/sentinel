package org.pantherslabs.chimera.sentinel.data_api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataManagementProcessesDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412291516Z", comments="Source Table: public.data_management_processes")
    public static final DataManagementProcesses dataManagementProcesses = new DataManagementProcesses();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412356871Z", comments="Source field: public.data_management_processes.process_id")
    public static final SqlColumn<Short> processId = dataManagementProcesses.processId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412384283Z", comments="Source field: public.data_management_processes.process_name")
    public static final SqlColumn<String> processName = dataManagementProcesses.processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412409881Z", comments="Source field: public.data_management_processes.process_short_desc")
    public static final SqlColumn<String> processShortDesc = dataManagementProcesses.processShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412477141Z", comments="Source field: public.data_management_processes.process_long_desc")
    public static final SqlColumn<String> processLongDesc = dataManagementProcesses.processLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412505553Z", comments="Source field: public.data_management_processes.created_by")
    public static final SqlColumn<String> createdBy = dataManagementProcesses.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412532693Z", comments="Source field: public.data_management_processes.created_ts")
    public static final SqlColumn<Date> createdTs = dataManagementProcesses.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412558018Z", comments="Source field: public.data_management_processes.updated_by")
    public static final SqlColumn<String> updatedBy = dataManagementProcesses.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412608214Z", comments="Source field: public.data_management_processes.updated_ts")
    public static final SqlColumn<Date> updatedTs = dataManagementProcesses.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412325827Z", comments="Source Table: public.data_management_processes")
    public static final class DataManagementProcesses extends AliasableSqlTable<DataManagementProcesses> {
        public final SqlColumn<Short> processId = column("process_id", JDBCType.SMALLINT);

        public final SqlColumn<String> processName = column("process_name", JDBCType.VARCHAR);

        public final SqlColumn<String> processShortDesc = column("process_short_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> processLongDesc = column("process_long_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTs = column("created_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updatedBy = column("updated_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> updatedTs = column("updated_ts", JDBCType.TIMESTAMP);

        public DataManagementProcesses() {
            super("\"public\".\"data_management_processes\"", DataManagementProcesses::new);
        }
    }
}
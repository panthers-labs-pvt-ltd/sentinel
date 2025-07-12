package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataManagementProcessesDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689716049Z", comments="Source Table: sentinel.data_management_processes")
    public static final DataManagementProcesses dataManagementProcesses = new DataManagementProcesses();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689811009Z", comments="Source field: sentinel.data_management_processes.process_id")
    public static final SqlColumn<String> processId = dataManagementProcesses.processId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.68984199Z", comments="Source field: sentinel.data_management_processes.process_name")
    public static final SqlColumn<String> processName = dataManagementProcesses.processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689898269Z", comments="Source field: sentinel.data_management_processes.process_short_desc")
    public static final SqlColumn<String> processShortDesc = dataManagementProcesses.processShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689929892Z", comments="Source field: sentinel.data_management_processes.process_long_desc")
    public static final SqlColumn<String> processLongDesc = dataManagementProcesses.processLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689958031Z", comments="Source field: sentinel.data_management_processes.effective_from")
    public static final SqlColumn<Date> effectiveFrom = dataManagementProcesses.effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.690028884Z", comments="Source field: sentinel.data_management_processes.expiry_date")
    public static final SqlColumn<Date> expiryDate = dataManagementProcesses.expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.690060324Z", comments="Source field: sentinel.data_management_processes.created_by")
    public static final SqlColumn<String> createdBy = dataManagementProcesses.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.690088922Z", comments="Source field: sentinel.data_management_processes.created_ts")
    public static final SqlColumn<Date> createdTs = dataManagementProcesses.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.690115411Z", comments="Source field: sentinel.data_management_processes.updated_by")
    public static final SqlColumn<String> updatedBy = dataManagementProcesses.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.690143643Z", comments="Source field: sentinel.data_management_processes.updated_ts")
    public static final SqlColumn<Date> updatedTs = dataManagementProcesses.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689760687Z", comments="Source Table: sentinel.data_management_processes")
    public static final class DataManagementProcesses extends AliasableSqlTable<DataManagementProcesses> {
        public final SqlColumn<String> processId = column("process_id", JDBCType.VARCHAR);

        public final SqlColumn<String> processName = column("process_name", JDBCType.VARCHAR);

        public final SqlColumn<String> processShortDesc = column("process_short_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> processLongDesc = column("process_long_desc", JDBCType.VARCHAR);

        public final SqlColumn<Date> effectiveFrom = column("effective_from", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> expiryDate = column("expiry_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTs = column("created_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updatedBy = column("updated_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> updatedTs = column("updated_ts", JDBCType.TIMESTAMP);

        public DataManagementProcesses() {
            super("\"sentinel\".\"data_management_processes\"", DataManagementProcesses::new);
        }
    }
}
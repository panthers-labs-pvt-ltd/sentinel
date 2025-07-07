package org.pantherslabs.chimera.sentinel.data_api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataAssetProfilesDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.393876111Z", comments="Source Table: public.data_asset_profiles")
    public static final DataAssetProfiles dataAssetProfiles = new DataAssetProfiles();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394059195Z", comments="Source field: public.data_asset_profiles.database_name")
    public static final SqlColumn<String> databaseName = dataAssetProfiles.databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394249994Z", comments="Source field: public.data_asset_profiles.schema_name")
    public static final SqlColumn<String> schemaName = dataAssetProfiles.schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394341037Z", comments="Source field: public.data_asset_profiles.table_name")
    public static final SqlColumn<String> tableName = dataAssetProfiles.tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394382519Z", comments="Source field: public.data_asset_profiles.partition_key")
    public static final SqlColumn<String> partitionKey = dataAssetProfiles.partitionKey;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394421278Z", comments="Source field: public.data_asset_profiles.profile_text")
    public static final SqlColumn<Object> profileText = dataAssetProfiles.profileText;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394460037Z", comments="Source field: public.data_asset_profiles.batch_id")
    public static final SqlColumn<Integer> batchId = dataAssetProfiles.batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394498342Z", comments="Source field: public.data_asset_profiles.reserved_5")
    public static final SqlColumn<String> reserved5 = dataAssetProfiles.reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394536102Z", comments="Source field: public.data_asset_profiles.reserved_4")
    public static final SqlColumn<String> reserved4 = dataAssetProfiles.reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394583303Z", comments="Source field: public.data_asset_profiles.reserved_3")
    public static final SqlColumn<String> reserved3 = dataAssetProfiles.reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394620882Z", comments="Source field: public.data_asset_profiles.reserved_2")
    public static final SqlColumn<String> reserved2 = dataAssetProfiles.reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394680972Z", comments="Source field: public.data_asset_profiles.reserved_1")
    public static final SqlColumn<String> reserved1 = dataAssetProfiles.reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394720638Z", comments="Source field: public.data_asset_profiles.created_by")
    public static final SqlColumn<String> createdBy = dataAssetProfiles.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.394759851Z", comments="Source field: public.data_asset_profiles.created_ts")
    public static final SqlColumn<Date> createdTs = dataAssetProfiles.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.393982584Z", comments="Source Table: public.data_asset_profiles")
    public static final class DataAssetProfiles extends AliasableSqlTable<DataAssetProfiles> {
        public final SqlColumn<String> databaseName = column("database_name", JDBCType.VARCHAR);

        public final SqlColumn<String> schemaName = column("schema_name", JDBCType.VARCHAR);

        public final SqlColumn<String> tableName = column("table_name", JDBCType.VARCHAR);

        public final SqlColumn<String> partitionKey = column("partition_key", JDBCType.VARCHAR);

        public final SqlColumn<Object> profileText = column("profile_text", JDBCType.OTHER);

        public final SqlColumn<Integer> batchId = column("batch_id", JDBCType.INTEGER);

        public final SqlColumn<String> reserved5 = column("reserved_5", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved4 = column("reserved_4", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved3 = column("reserved_3", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved2 = column("reserved_2", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved1 = column("reserved_1", JDBCType.VARCHAR);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTs = column("created_ts", JDBCType.TIMESTAMP);

        public DataAssetProfiles() {
            super("\"public\".\"data_asset_profiles\"", DataAssetProfiles::new);
        }
    }
}
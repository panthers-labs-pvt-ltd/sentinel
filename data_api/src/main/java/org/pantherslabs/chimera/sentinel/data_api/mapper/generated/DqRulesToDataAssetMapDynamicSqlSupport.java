package org.pantherslabs.chimera.sentinel.data_api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DqRulesToDataAssetMapDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422632986Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    public static final DqRulesToDataAssetMap dqRulesToDataAssetMap = new DqRulesToDataAssetMap();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422721396Z", comments="Source field: public.dq_rules_to_data_asset_map.dq_rules_to_data_asset_map_id")
    public static final SqlColumn<Integer> dqRulesToDataAssetMapId = dqRulesToDataAssetMap.dqRulesToDataAssetMapId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422749626Z", comments="Source field: public.dq_rules_to_data_asset_map.rule_id")
    public static final SqlColumn<Integer> ruleId = dqRulesToDataAssetMap.ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422775768Z", comments="Source field: public.dq_rules_to_data_asset_map.database_name")
    public static final SqlColumn<String> databaseName = dqRulesToDataAssetMap.databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422800004Z", comments="Source field: public.dq_rules_to_data_asset_map.schema_name")
    public static final SqlColumn<String> schemaName = dqRulesToDataAssetMap.schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422824875Z", comments="Source field: public.dq_rules_to_data_asset_map.table_name")
    public static final SqlColumn<String> tableName = dqRulesToDataAssetMap.tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422848475Z", comments="Source field: public.dq_rules_to_data_asset_map.partition_keys")
    public static final SqlColumn<String> partitionKeys = dqRulesToDataAssetMap.partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422871531Z", comments="Source field: public.dq_rules_to_data_asset_map.rule_col")
    public static final SqlColumn<String> ruleCol = dqRulesToDataAssetMap.ruleCol;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422894405Z", comments="Source field: public.dq_rules_to_data_asset_map.rule_value")
    public static final SqlColumn<String> ruleValue = dqRulesToDataAssetMap.ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422918459Z", comments="Source field: public.dq_rules_to_data_asset_map.active_flg")
    public static final SqlColumn<String> activeFlg = dqRulesToDataAssetMap.activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422941152Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_5")
    public static final SqlColumn<String> reserved5 = dqRulesToDataAssetMap.reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422963844Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_4")
    public static final SqlColumn<String> reserved4 = dqRulesToDataAssetMap.reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422986628Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_3")
    public static final SqlColumn<String> reserved3 = dqRulesToDataAssetMap.reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.423009411Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_2")
    public static final SqlColumn<String> reserved2 = dqRulesToDataAssetMap.reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.423043994Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_1")
    public static final SqlColumn<String> reserved1 = dqRulesToDataAssetMap.reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.42307295Z", comments="Source field: public.dq_rules_to_data_asset_map.created_by")
    public static final SqlColumn<String> createdBy = dqRulesToDataAssetMap.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.423098094Z", comments="Source field: public.dq_rules_to_data_asset_map.created_ts")
    public static final SqlColumn<Date> createdTs = dqRulesToDataAssetMap.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.42312242Z", comments="Source field: public.dq_rules_to_data_asset_map.updated_ts")
    public static final SqlColumn<Date> updatedTs = dqRulesToDataAssetMap.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.423159091Z", comments="Source field: public.dq_rules_to_data_asset_map.updated_by")
    public static final SqlColumn<String> updatedBy = dqRulesToDataAssetMap.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.42267356Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    public static final class DqRulesToDataAssetMap extends AliasableSqlTable<DqRulesToDataAssetMap> {
        public final SqlColumn<Integer> dqRulesToDataAssetMapId = column("dq_rules_to_data_asset_map_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> ruleId = column("rule_id", JDBCType.INTEGER);

        public final SqlColumn<String> databaseName = column("database_name", JDBCType.VARCHAR);

        public final SqlColumn<String> schemaName = column("schema_name", JDBCType.VARCHAR);

        public final SqlColumn<String> tableName = column("table_name", JDBCType.VARCHAR);

        public final SqlColumn<String> partitionKeys = column("partition_keys", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleCol = column("rule_col", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleValue = column("rule_value", JDBCType.VARCHAR);

        public final SqlColumn<String> activeFlg = column("active_flg", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved5 = column("reserved_5", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved4 = column("reserved_4", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved3 = column("reserved_3", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved2 = column("reserved_2", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved1 = column("reserved_1", JDBCType.VARCHAR);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTs = column("created_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updatedTs = column("updated_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updatedBy = column("updated_by", JDBCType.VARCHAR);

        public DqRulesToDataAssetMap() {
            super("\"public\".\"dq_rules_to_data_asset_map\"", DqRulesToDataAssetMap::new);
        }
    }
}
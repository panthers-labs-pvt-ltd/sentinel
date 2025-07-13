package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DqRulesAssetMapDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.819205483Z", comments="Source Table: sentinel.dq_rules_asset_map")
    public static final DqRulesAssetMap dqRulesAssetMap = new DqRulesAssetMap();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.819553203Z", comments="Source field: sentinel.dq_rules_asset_map.asset_map_id")
    public static final SqlColumn<String> assetMapId = dqRulesAssetMap.assetMapId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.81985222Z", comments="Source field: sentinel.dq_rules_asset_map.rule_id")
    public static final SqlColumn<String> ruleId = dqRulesAssetMap.ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.819910123Z", comments="Source field: sentinel.dq_rules_asset_map.database_name")
    public static final SqlColumn<String> databaseName = dqRulesAssetMap.databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.819957325Z", comments="Source field: sentinel.dq_rules_asset_map.schema_name")
    public static final SqlColumn<String> schemaName = dqRulesAssetMap.schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820002228Z", comments="Source field: sentinel.dq_rules_asset_map.table_name")
    public static final SqlColumn<String> tableName = dqRulesAssetMap.tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.82004593Z", comments="Source field: sentinel.dq_rules_asset_map.partition_keys")
    public static final SqlColumn<String> partitionKeys = dqRulesAssetMap.partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820093533Z", comments="Source field: sentinel.dq_rules_asset_map.rule_column")
    public static final SqlColumn<String> ruleColumn = dqRulesAssetMap.ruleColumn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820170037Z", comments="Source field: sentinel.dq_rules_asset_map.rule_value")
    public static final SqlColumn<String> ruleValue = dqRulesAssetMap.ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820371449Z", comments="Source field: sentinel.dq_rules_asset_map.effective_from")
    public static final SqlColumn<Date> effectiveFrom = dqRulesAssetMap.effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820425752Z", comments="Source field: sentinel.dq_rules_asset_map.expiry_date")
    public static final SqlColumn<Date> expiryDate = dqRulesAssetMap.expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820472754Z", comments="Source field: sentinel.dq_rules_asset_map.check_level")
    public static final SqlColumn<String> checkLevel = dqRulesAssetMap.checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820517857Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_5")
    public static final SqlColumn<String> reserved5 = dqRulesAssetMap.reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820594361Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_4")
    public static final SqlColumn<String> reserved4 = dqRulesAssetMap.reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820641764Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_3")
    public static final SqlColumn<String> reserved3 = dqRulesAssetMap.reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820730969Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_2")
    public static final SqlColumn<String> reserved2 = dqRulesAssetMap.reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820776972Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_1")
    public static final SqlColumn<String> reserved1 = dqRulesAssetMap.reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820820774Z", comments="Source field: sentinel.dq_rules_asset_map.active_flg")
    public static final SqlColumn<String> activeFlg = dqRulesAssetMap.activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820864576Z", comments="Source field: sentinel.dq_rules_asset_map.created_by")
    public static final SqlColumn<String> createdBy = dqRulesAssetMap.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820915279Z", comments="Source field: sentinel.dq_rules_asset_map.created_ts")
    public static final SqlColumn<Date> createdTs = dqRulesAssetMap.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.820964082Z", comments="Source field: sentinel.dq_rules_asset_map.updated_ts")
    public static final SqlColumn<Date> updatedTs = dqRulesAssetMap.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.821045387Z", comments="Source field: sentinel.dq_rules_asset_map.updated_by")
    public static final SqlColumn<String> updatedBy = dqRulesAssetMap.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.819454697Z", comments="Source Table: sentinel.dq_rules_asset_map")
    public static final class DqRulesAssetMap extends AliasableSqlTable<DqRulesAssetMap> {
        public final SqlColumn<String> assetMapId = column("asset_map_id", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleId = column("rule_id", JDBCType.VARCHAR);

        public final SqlColumn<String> databaseName = column("database_name", JDBCType.VARCHAR);

        public final SqlColumn<String> schemaName = column("schema_name", JDBCType.VARCHAR);

        public final SqlColumn<String> tableName = column("table_name", JDBCType.VARCHAR);

        public final SqlColumn<String> partitionKeys = column("partition_keys", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleColumn = column("rule_column", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleValue = column("rule_value", JDBCType.VARCHAR);

        public final SqlColumn<Date> effectiveFrom = column("effective_from", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> expiryDate = column("expiry_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> checkLevel = column("check_level", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved5 = column("reserved_5", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved4 = column("reserved_4", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved3 = column("reserved_3", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved2 = column("reserved_2", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved1 = column("reserved_1", JDBCType.VARCHAR);

        public final SqlColumn<String> activeFlg = column("active_flg", JDBCType.VARCHAR);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTs = column("created_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updatedTs = column("updated_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updatedBy = column("updated_by", JDBCType.VARCHAR);

        public DqRulesAssetMap() {
            super("\"sentinel\".\"dq_rules_asset_map\"", DqRulesAssetMap::new);
        }
    }
}
package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DqRulesAssetMap {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.809952564Z", comments="Source field: sentinel.dq_rules_asset_map.asset_map_id")
    private String assetMapId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.812759221Z", comments="Source field: sentinel.dq_rules_asset_map.rule_id")
    private String ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.813010035Z", comments="Source field: sentinel.dq_rules_asset_map.database_name")
    private String databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.813226247Z", comments="Source field: sentinel.dq_rules_asset_map.schema_name")
    private String schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.813433459Z", comments="Source field: sentinel.dq_rules_asset_map.table_name")
    private String tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.813598168Z", comments="Source field: sentinel.dq_rules_asset_map.partition_keys")
    private String partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.813783079Z", comments="Source field: sentinel.dq_rules_asset_map.rule_column")
    private String ruleColumn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.813929287Z", comments="Source field: sentinel.dq_rules_asset_map.rule_value")
    private String ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.814113497Z", comments="Source field: sentinel.dq_rules_asset_map.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.814276306Z", comments="Source field: sentinel.dq_rules_asset_map.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.814411714Z", comments="Source field: sentinel.dq_rules_asset_map.check_level")
    private String checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.814605025Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.814784935Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.814974046Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.815105253Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.815386669Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.815509176Z", comments="Source field: sentinel.dq_rules_asset_map.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.81577069Z", comments="Source field: sentinel.dq_rules_asset_map.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.815925199Z", comments="Source field: sentinel.dq_rules_asset_map.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.816043206Z", comments="Source field: sentinel.dq_rules_asset_map.updated_ts")
    private Date updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.816160312Z", comments="Source field: sentinel.dq_rules_asset_map.updated_by")
    private String updatedBy;
}
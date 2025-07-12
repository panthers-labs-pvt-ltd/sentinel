package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DqRulesAssetMap {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.660858745Z", comments="Source field: sentinel.dq_rules_asset_map.asset_map_id")
    private String assetMapId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.661918517Z", comments="Source field: sentinel.dq_rules_asset_map.rule_id")
    private String ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.662039783Z", comments="Source field: sentinel.dq_rules_asset_map.database_name")
    private String databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.662138226Z", comments="Source field: sentinel.dq_rules_asset_map.schema_name")
    private String schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.662234652Z", comments="Source field: sentinel.dq_rules_asset_map.table_name")
    private String tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.662399365Z", comments="Source field: sentinel.dq_rules_asset_map.partition_keys")
    private String partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.662781495Z", comments="Source field: sentinel.dq_rules_asset_map.rule_column")
    private String ruleColumn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.663029344Z", comments="Source field: sentinel.dq_rules_asset_map.rule_value")
    private String ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.663174533Z", comments="Source field: sentinel.dq_rules_asset_map.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.663363353Z", comments="Source field: sentinel.dq_rules_asset_map.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.663476645Z", comments="Source field: sentinel.dq_rules_asset_map.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.663707536Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.663889206Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.664068676Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.664163453Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.664381145Z", comments="Source field: sentinel.dq_rules_asset_map.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.66454265Z", comments="Source field: sentinel.dq_rules_asset_map.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.664905165Z", comments="Source field: sentinel.dq_rules_asset_map.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.665080419Z", comments="Source field: sentinel.dq_rules_asset_map.updated_ts")
    private Date updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.665259064Z", comments="Source field: sentinel.dq_rules_asset_map.updated_by")
    private String updatedBy;
}
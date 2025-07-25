package org.pantherslabs.chimera.sentinel.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DqRulesToDataAssetMap {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.008898006Z", comments="Source field: public.dq_rules_to_data_asset_map.dq_rules_to_data_asset_map_id")
    private Integer dqRulesToDataAssetMapId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.009074006Z", comments="Source field: public.dq_rules_to_data_asset_map.rule_id")
    private Integer ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.009201107Z", comments="Source field: public.dq_rules_to_data_asset_map.database_name")
    private String databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.009320507Z", comments="Source field: public.dq_rules_to_data_asset_map.schema_name")
    private String schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.009442707Z", comments="Source field: public.dq_rules_to_data_asset_map.table_name")
    private String tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.009557407Z", comments="Source field: public.dq_rules_to_data_asset_map.partition_keys")
    private String partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.009677808Z", comments="Source field: public.dq_rules_to_data_asset_map.rule_col")
    private String ruleCol;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.009794908Z", comments="Source field: public.dq_rules_to_data_asset_map.rule_value")
    private String ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.009914108Z", comments="Source field: public.dq_rules_to_data_asset_map.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.010038508Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.010162509Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.010286109Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.010418009Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.01054801Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.01076821Z", comments="Source field: public.dq_rules_to_data_asset_map.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.01090651Z", comments="Source field: public.dq_rules_to_data_asset_map.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.011043811Z", comments="Source field: public.dq_rules_to_data_asset_map.updated_ts")
    private Date updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.011177911Z", comments="Source field: public.dq_rules_to_data_asset_map.updated_by")
    private String updatedBy;
}
package org.pantherslabs.chimera.sentinel.data_api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DqRulesToDataAssetMap {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.42164377Z", comments="Source field: public.dq_rules_to_data_asset_map.dq_rules_to_data_asset_map_id")
    private Integer dqRulesToDataAssetMapId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.421704042Z", comments="Source field: public.dq_rules_to_data_asset_map.rule_id")
    private Integer ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.421750698Z", comments="Source field: public.dq_rules_to_data_asset_map.database_name")
    private String databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.421798352Z", comments="Source field: public.dq_rules_to_data_asset_map.schema_name")
    private String schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.421845735Z", comments="Source field: public.dq_rules_to_data_asset_map.table_name")
    private String tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.421891937Z", comments="Source field: public.dq_rules_to_data_asset_map.partition_keys")
    private String partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.421940408Z", comments="Source field: public.dq_rules_to_data_asset_map.rule_col")
    private String ruleCol;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.421986338Z", comments="Source field: public.dq_rules_to_data_asset_map.rule_value")
    private String ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.42203136Z", comments="Source field: public.dq_rules_to_data_asset_map.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422077017Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422125398Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422170329Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.42223287Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.42228234Z", comments="Source field: public.dq_rules_to_data_asset_map.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422350781Z", comments="Source field: public.dq_rules_to_data_asset_map.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422400069Z", comments="Source field: public.dq_rules_to_data_asset_map.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.42244963Z", comments="Source field: public.dq_rules_to_data_asset_map.updated_ts")
    private Date updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.422508177Z", comments="Source field: public.dq_rules_to_data_asset_map.updated_by")
    private String updatedBy;
}
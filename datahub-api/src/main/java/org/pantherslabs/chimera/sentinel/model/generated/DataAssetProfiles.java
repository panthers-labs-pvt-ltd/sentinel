package org.pantherslabs.chimera.sentinel.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataAssetProfiles {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.878619518Z", comments="Source field: public.data_asset_profiles.database_name")
    private String databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.885371233Z", comments="Source field: public.data_asset_profiles.schema_name")
    private String schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.886094335Z", comments="Source field: public.data_asset_profiles.table_name")
    private String tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.886527236Z", comments="Source field: public.data_asset_profiles.partition_key")
    private String partitionKey;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.887016637Z", comments="Source field: public.data_asset_profiles.profile_text")
    private Object profileText;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.887541338Z", comments="Source field: public.data_asset_profiles.batch_id")
    private Integer batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.888047039Z", comments="Source field: public.data_asset_profiles.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.88856814Z", comments="Source field: public.data_asset_profiles.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.888900441Z", comments="Source field: public.data_asset_profiles.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.889365542Z", comments="Source field: public.data_asset_profiles.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.889681443Z", comments="Source field: public.data_asset_profiles.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.890230144Z", comments="Source field: public.data_asset_profiles.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.890646545Z", comments="Source field: public.data_asset_profiles.created_ts")
    private Date createdTs;
}
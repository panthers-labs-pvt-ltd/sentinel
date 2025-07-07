package org.pantherslabs.chimera.sentinel.data_api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataAssetProfiles {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.389136989Z", comments="Source field: public.data_asset_profiles.database_name")
    private String databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.390130925Z", comments="Source field: public.data_asset_profiles.schema_name")
    private String schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.390232587Z", comments="Source field: public.data_asset_profiles.table_name")
    private String tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.390327806Z", comments="Source field: public.data_asset_profiles.partition_key")
    private String partitionKey;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.390724291Z", comments="Source field: public.data_asset_profiles.profile_text")
    private Object profileText;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.390917359Z", comments="Source field: public.data_asset_profiles.batch_id")
    private Integer batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.391224435Z", comments="Source field: public.data_asset_profiles.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.391534053Z", comments="Source field: public.data_asset_profiles.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.391658318Z", comments="Source field: public.data_asset_profiles.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.391875713Z", comments="Source field: public.data_asset_profiles.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.392046543Z", comments="Source field: public.data_asset_profiles.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.392186148Z", comments="Source field: public.data_asset_profiles.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.392289354Z", comments="Source field: public.data_asset_profiles.created_ts")
    private Date createdTs;
}
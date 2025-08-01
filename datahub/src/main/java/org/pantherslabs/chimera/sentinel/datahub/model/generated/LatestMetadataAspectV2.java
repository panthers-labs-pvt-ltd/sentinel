package org.pantherslabs.chimera.sentinel.datahub.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class LatestMetadataAspectV2 {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.973593726Z", comments="Source field: public.latest_metadata_aspect_v2.urn")
    private String urn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.973835892Z", comments="Source field: public.latest_metadata_aspect_v2.aspect")
    private String aspect;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.973948642Z", comments="Source field: public.latest_metadata_aspect_v2.version")
    private Long version;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.974208032Z", comments="Source field: public.latest_metadata_aspect_v2.metadata")
    private String metadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.974540975Z", comments="Source field: public.latest_metadata_aspect_v2.systemmetadata")
    private String systemmetadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.974653539Z", comments="Source field: public.latest_metadata_aspect_v2.createdon")
    private Date createdon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.97477532Z", comments="Source field: public.latest_metadata_aspect_v2.createdby")
    private String createdby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.974967302Z", comments="Source field: public.latest_metadata_aspect_v2.createdfor")
    private String createdfor;
}
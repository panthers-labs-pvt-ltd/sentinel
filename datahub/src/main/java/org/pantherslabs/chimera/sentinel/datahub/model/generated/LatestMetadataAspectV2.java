package org.pantherslabs.chimera.sentinel.datahub.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class LatestMetadataAspectV2 {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.606870056Z", comments="Source field: public.latest_metadata_aspect_v2.urn")
    private String urn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.607052155Z", comments="Source field: public.latest_metadata_aspect_v2.aspect")
    private String aspect;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.607158621Z", comments="Source field: public.latest_metadata_aspect_v2.version")
    private Long version;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.607284769Z", comments="Source field: public.latest_metadata_aspect_v2.metadata")
    private String metadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.607422819Z", comments="Source field: public.latest_metadata_aspect_v2.systemmetadata")
    private String systemmetadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.607537908Z", comments="Source field: public.latest_metadata_aspect_v2.createdon")
    private Date createdon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.607675209Z", comments="Source field: public.latest_metadata_aspect_v2.createdby")
    private String createdby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.607784862Z", comments="Source field: public.latest_metadata_aspect_v2.createdfor")
    private String createdfor;
}
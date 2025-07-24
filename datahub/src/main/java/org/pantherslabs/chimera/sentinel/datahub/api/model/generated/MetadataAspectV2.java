package org.pantherslabs.chimera.sentinel.datahub.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class MetadataAspectV2 {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.949222777Z", comments="Source field: public.metadata_aspect_v2.urn")
    private String urn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.950577267Z", comments="Source field: public.metadata_aspect_v2.aspect")
    private String aspect;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.950807516Z", comments="Source field: public.metadata_aspect_v2.version")
    private Long version;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.95099298Z", comments="Source field: public.metadata_aspect_v2.metadata")
    private String metadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.951204701Z", comments="Source field: public.metadata_aspect_v2.systemmetadata")
    private String systemmetadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.95143616Z", comments="Source field: public.metadata_aspect_v2.createdon")
    private Date createdon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.951647415Z", comments="Source field: public.metadata_aspect_v2.createdby")
    private String createdby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.951819286Z", comments="Source field: public.metadata_aspect_v2.createdfor")
    private String createdfor;
}
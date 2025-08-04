package org.pantherslabs.chimera.sentinel.datahub.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class MetadataAspectV2 {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.583777128Z", comments="Source field: public.metadata_aspect_v2.urn")
    private String urn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.585179094Z", comments="Source field: public.metadata_aspect_v2.aspect")
    private String aspect;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.585385748Z", comments="Source field: public.metadata_aspect_v2.version")
    private Long version;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.585532233Z", comments="Source field: public.metadata_aspect_v2.metadata")
    private String metadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.585702617Z", comments="Source field: public.metadata_aspect_v2.systemmetadata")
    private String systemmetadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.58616091Z", comments="Source field: public.metadata_aspect_v2.createdon")
    private Date createdon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.586605708Z", comments="Source field: public.metadata_aspect_v2.createdby")
    private String createdby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.586822202Z", comments="Source field: public.metadata_aspect_v2.createdfor")
    private String createdfor;
}
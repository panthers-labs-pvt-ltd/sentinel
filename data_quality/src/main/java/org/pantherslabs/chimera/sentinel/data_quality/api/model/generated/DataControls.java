package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControls {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847969599Z", comments="Source field: sentinel.data_controls.control_id")
    private String controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848113807Z", comments="Source field: sentinel.data_controls.control_name")
    private String controlName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.84816691Z", comments="Source field: sentinel.data_controls.control_short_desc")
    private String controlShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848217713Z", comments="Source field: sentinel.data_controls.control_long_desc")
    private String controlLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848267616Z", comments="Source field: sentinel.data_controls.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848356921Z", comments="Source field: sentinel.data_controls.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848411224Z", comments="Source field: sentinel.data_controls.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848462027Z", comments="Source field: sentinel.data_controls.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848510729Z", comments="Source field: sentinel.data_controls.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848558832Z", comments="Source field: sentinel.data_controls.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848606635Z", comments="Source field: sentinel.data_controls.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848684639Z", comments="Source field: sentinel.data_controls.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848733142Z", comments="Source field: sentinel.data_controls.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848782345Z", comments="Source field: sentinel.data_controls.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.848831547Z", comments="Source field: sentinel.data_controls.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.84887995Z", comments="Source field: sentinel.data_controls.updated_ts")
    private Date updatedTs;
}
package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControls {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.693920858Z", comments="Source field: sentinel.data_controls.control_id")
    private String controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.693987128Z", comments="Source field: sentinel.data_controls.control_name")
    private String controlName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.694043316Z", comments="Source field: sentinel.data_controls.control_short_desc")
    private String controlShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.694096387Z", comments="Source field: sentinel.data_controls.control_long_desc")
    private String controlLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.694148816Z", comments="Source field: sentinel.data_controls.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.694201246Z", comments="Source field: sentinel.data_controls.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.694288048Z", comments="Source field: sentinel.data_controls.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.694354593Z", comments="Source field: sentinel.data_controls.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.694413164Z", comments="Source field: sentinel.data_controls.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.694502715Z", comments="Source field: sentinel.data_controls.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69466147Z", comments="Source field: sentinel.data_controls.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695001987Z", comments="Source field: sentinel.data_controls.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695073665Z", comments="Source field: sentinel.data_controls.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69512582Z", comments="Source field: sentinel.data_controls.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695179807Z", comments="Source field: sentinel.data_controls.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69523737Z", comments="Source field: sentinel.data_controls.updated_ts")
    private Date updatedTs;
}
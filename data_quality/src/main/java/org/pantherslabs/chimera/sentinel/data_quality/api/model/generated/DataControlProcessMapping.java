package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControlProcessMapping {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845016233Z", comments="Source field: sentinel.data_control_process_mapping.mapping_id")
    private String mappingId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845072236Z", comments="Source field: sentinel.data_control_process_mapping.process_id")
    private String processId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845120239Z", comments="Source field: sentinel.data_control_process_mapping.control_id")
    private String controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845167542Z", comments="Source field: sentinel.data_control_process_mapping.check_lvl")
    private String checkLvl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845214944Z", comments="Source field: sentinel.data_control_process_mapping.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845262147Z", comments="Source field: sentinel.data_control_process_mapping.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845330151Z", comments="Source field: sentinel.data_control_process_mapping.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845393354Z", comments="Source field: sentinel.data_control_process_mapping.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845440257Z", comments="Source field: sentinel.data_control_process_mapping.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845487259Z", comments="Source field: sentinel.data_control_process_mapping.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845535062Z", comments="Source field: sentinel.data_control_process_mapping.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845581865Z", comments="Source field: sentinel.data_control_process_mapping.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845628767Z", comments="Source field: sentinel.data_control_process_mapping.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845700771Z", comments="Source field: sentinel.data_control_process_mapping.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845748974Z", comments="Source field: sentinel.data_control_process_mapping.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845795177Z", comments="Source field: sentinel.data_control_process_mapping.updated_ts")
    private Date updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845841279Z", comments="Source field: sentinel.data_control_process_mapping.ref_metadata")
    private String refMetadata;
}
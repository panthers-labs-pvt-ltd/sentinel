package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControlProcessMapping {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.691216339Z", comments="Source field: sentinel.data_control_process_mapping.mapping_id")
    private String mappingId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.691300941Z", comments="Source field: sentinel.data_control_process_mapping.process_id")
    private String processId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.691389851Z", comments="Source field: sentinel.data_control_process_mapping.control_id")
    private String controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.691445397Z", comments="Source field: sentinel.data_control_process_mapping.check_lvl")
    private String checkLvl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.691499568Z", comments="Source field: sentinel.data_control_process_mapping.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.691582521Z", comments="Source field: sentinel.data_control_process_mapping.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69163715Z", comments="Source field: sentinel.data_control_process_mapping.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69168903Z", comments="Source field: sentinel.data_control_process_mapping.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.691741184Z", comments="Source field: sentinel.data_control_process_mapping.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.691792972Z", comments="Source field: sentinel.data_control_process_mapping.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.691893431Z", comments="Source field: sentinel.data_control_process_mapping.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69195136Z", comments="Source field: sentinel.data_control_process_mapping.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.692007731Z", comments="Source field: sentinel.data_control_process_mapping.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.692062819Z", comments="Source field: sentinel.data_control_process_mapping.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.692115157Z", comments="Source field: sentinel.data_control_process_mapping.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69216667Z", comments="Source field: sentinel.data_control_process_mapping.updated_ts")
    private Date updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.692220474Z", comments="Source field: sentinel.data_control_process_mapping.ref_metadata")
    private String refMetadata;
}
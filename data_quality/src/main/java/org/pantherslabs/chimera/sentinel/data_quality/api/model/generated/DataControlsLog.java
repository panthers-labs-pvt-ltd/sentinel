package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControlsLog {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686390167Z", comments="Source field: sentinel.data_controls_log.log_id")
    private Long logId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686453413Z", comments="Source field: sentinel.data_controls_log.batch_id")
    private String batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686507492Z", comments="Source field: sentinel.data_controls_log.process_name")
    private String processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686559922Z", comments="Source field: sentinel.data_controls_log.control_id")
    private String controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686638016Z", comments="Source field: sentinel.data_controls_log.control_name")
    private String controlName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686694295Z", comments="Source field: sentinel.data_controls_log.control_dim_id")
    private String controlDimId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686782197Z", comments="Source field: sentinel.data_controls_log.control_dim_name")
    private String controlDimName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686885681Z", comments="Source field: sentinel.data_controls_log.start_ts")
    private Date startTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686944069Z", comments="Source field: sentinel.data_controls_log.end_ts")
    private Date endTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687024729Z", comments="Source field: sentinel.data_controls_log.status_desc")
    private String statusDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.687129588Z", comments="Source field: sentinel.data_controls_log.status")
    private String status;
}
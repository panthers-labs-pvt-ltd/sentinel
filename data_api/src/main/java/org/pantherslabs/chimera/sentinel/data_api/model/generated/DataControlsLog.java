package org.pantherslabs.chimera.sentinel.data_api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControlsLog {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406853553Z", comments="Source field: public.data_controls_log.data_controls_log_id")
    private Long dataControlsLogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406925171Z", comments="Source field: public.data_controls_log.batch_id")
    private String batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.407009315Z", comments="Source field: public.data_controls_log.process_typ_nm")
    private String processTypNm;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.407083111Z", comments="Source field: public.data_controls_log.control_id")
    private Short controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.407147195Z", comments="Source field: public.data_controls_log.start_ts")
    private Date startTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.407216544Z", comments="Source field: public.data_controls_log.end_ts")
    private Date endTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.407279175Z", comments="Source field: public.data_controls_log.status_desc")
    private String statusDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.407341625Z", comments="Source field: public.data_controls_log.status")
    private String status;
}
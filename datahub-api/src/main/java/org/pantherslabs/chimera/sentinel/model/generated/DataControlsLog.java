package org.pantherslabs.chimera.sentinel.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControlsLog {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.954149185Z", comments="Source field: public.data_controls_log.data_controls_log_id")
    private Long dataControlsLogId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.954559886Z", comments="Source field: public.data_controls_log.batch_id")
    private String batchId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.954760586Z", comments="Source field: public.data_controls_log.process_typ_nm")
    private String processTypNm;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.954952287Z", comments="Source field: public.data_controls_log.control_id")
    private Short controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.955405188Z", comments="Source field: public.data_controls_log.start_ts")
    private Date startTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.95632169Z", comments="Source field: public.data_controls_log.end_ts")
    private Date endTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.95656919Z", comments="Source field: public.data_controls_log.status_desc")
    private String statusDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.956834691Z", comments="Source field: public.data_controls_log.status")
    private String status;
}
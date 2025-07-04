package org.pantherslabs.chimera.sentinel.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataManagementProcesses {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.97442563Z", comments="Source field: public.data_management_processes.process_id")
    private Short processId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.974824031Z", comments="Source field: public.data_management_processes.process_name")
    private String processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.974993531Z", comments="Source field: public.data_management_processes.process_short_desc")
    private String processShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.975338032Z", comments="Source field: public.data_management_processes.process_long_desc")
    private String processLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.975836133Z", comments="Source field: public.data_management_processes.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.976017933Z", comments="Source field: public.data_management_processes.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.976369334Z", comments="Source field: public.data_management_processes.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.976643035Z", comments="Source field: public.data_management_processes.updated_ts")
    private Date updatedTs;
}
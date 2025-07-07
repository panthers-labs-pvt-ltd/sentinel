package org.pantherslabs.chimera.sentinel.data_api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataManagementProcesses {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.411794639Z", comments="Source field: public.data_management_processes.process_id")
    private Short processId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41185609Z", comments="Source field: public.data_management_processes.process_name")
    private String processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.411907739Z", comments="Source field: public.data_management_processes.process_short_desc")
    private String processShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.411963563Z", comments="Source field: public.data_management_processes.process_long_desc")
    private String processLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412015756Z", comments="Source field: public.data_management_processes.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412067222Z", comments="Source field: public.data_management_processes.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412117872Z", comments="Source field: public.data_management_processes.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.412168068Z", comments="Source field: public.data_management_processes.updated_ts")
    private Date updatedTs;
}
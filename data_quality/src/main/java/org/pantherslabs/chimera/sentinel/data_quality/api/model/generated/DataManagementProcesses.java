package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataManagementProcesses {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.842135071Z", comments="Source field: sentinel.data_management_processes.process_id")
    private String processId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.842219076Z", comments="Source field: sentinel.data_management_processes.process_name")
    private String processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.842307881Z", comments="Source field: sentinel.data_management_processes.process_short_desc")
    private String processShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.842376085Z", comments="Source field: sentinel.data_management_processes.process_long_desc")
    private String processLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.842426488Z", comments="Source field: sentinel.data_management_processes.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.843248634Z", comments="Source field: sentinel.data_management_processes.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.843305537Z", comments="Source field: sentinel.data_management_processes.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.84335374Z", comments="Source field: sentinel.data_management_processes.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.843402042Z", comments="Source field: sentinel.data_management_processes.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.843448145Z", comments="Source field: sentinel.data_management_processes.updated_ts")
    private Date updatedTs;
}
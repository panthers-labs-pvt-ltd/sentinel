package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataManagementProcesses {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688949222Z", comments="Source field: sentinel.data_management_processes.process_id")
    private String processId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689063338Z", comments="Source field: sentinel.data_management_processes.process_name")
    private String processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689115493Z", comments="Source field: sentinel.data_management_processes.process_short_desc")
    private String processShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689165448Z", comments="Source field: sentinel.data_management_processes.process_long_desc")
    private String processLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689317328Z", comments="Source field: sentinel.data_management_processes.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689376632Z", comments="Source field: sentinel.data_management_processes.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689427412Z", comments="Source field: sentinel.data_management_processes.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689477Z", comments="Source field: sentinel.data_management_processes.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689528329Z", comments="Source field: sentinel.data_management_processes.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.689577917Z", comments="Source field: sentinel.data_management_processes.updated_ts")
    private Date updatedTs;
}
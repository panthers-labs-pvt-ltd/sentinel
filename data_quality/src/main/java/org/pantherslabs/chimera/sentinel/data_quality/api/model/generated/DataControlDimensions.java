package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControlDimensions {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.830144798Z", comments="Source field: sentinel.data_control_dimensions.dimension_id")
    private String dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.830277505Z", comments="Source field: sentinel.data_control_dimensions.control_id")
    private String controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.830351109Z", comments="Source field: sentinel.data_control_dimensions.dimension_name")
    private String dimensionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.830471916Z", comments="Source field: sentinel.data_control_dimensions.dimension_short_desc")
    private String dimensionShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.830584522Z", comments="Source field: sentinel.data_control_dimensions.dimension_long_desc")
    private String dimensionLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.830687828Z", comments="Source field: sentinel.data_control_dimensions.calculated_field")
    private Boolean calculatedField;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83090184Z", comments="Source field: sentinel.data_control_dimensions.calculation_function")
    private String calculationFunction;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.831017847Z", comments="Source field: sentinel.data_control_dimensions.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.831322364Z", comments="Source field: sentinel.data_control_dimensions.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83143537Z", comments="Source field: sentinel.data_control_dimensions.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.831503174Z", comments="Source field: sentinel.data_control_dimensions.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.831569678Z", comments="Source field: sentinel.data_control_dimensions.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.831654383Z", comments="Source field: sentinel.data_control_dimensions.updated_ts")
    private Date updatedTs;
}
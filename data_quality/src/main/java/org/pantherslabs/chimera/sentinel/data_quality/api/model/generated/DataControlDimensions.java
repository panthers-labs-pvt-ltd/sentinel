package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataControlDimensions {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.679136565Z", comments="Source field: sentinel.data_control_dimensions.dimension_id")
    private String dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.679515854Z", comments="Source field: sentinel.data_control_dimensions.control_id")
    private String controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.679606139Z", comments="Source field: sentinel.data_control_dimensions.dimension_name")
    private String dimensionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.679788267Z", comments="Source field: sentinel.data_control_dimensions.dimension_short_desc")
    private String dimensionShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.679860587Z", comments="Source field: sentinel.data_control_dimensions.dimension_long_desc")
    private String dimensionLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.67992759Z", comments="Source field: sentinel.data_control_dimensions.calculated_field")
    private Boolean calculatedField;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.679990469Z", comments="Source field: sentinel.data_control_dimensions.calculation_function")
    private String calculationFunction;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.680090379Z", comments="Source field: sentinel.data_control_dimensions.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.680165356Z", comments="Source field: sentinel.data_control_dimensions.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.68025665Z", comments="Source field: sentinel.data_control_dimensions.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.680404589Z", comments="Source field: sentinel.data_control_dimensions.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.680466643Z", comments="Source field: sentinel.data_control_dimensions.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.680528605Z", comments="Source field: sentinel.data_control_dimensions.updated_ts")
    private Date updatedTs;
}
package org.pantherslabs.chimera.sentinel.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DqDimensions {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.993889873Z", comments="Source field: public.dq_dimensions.dimension_id")
    private Short dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.994091073Z", comments="Source field: public.dq_dimensions.dimension_name")
    private String dimensionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.994249474Z", comments="Source field: public.dq_dimensions.dimension_short_desc")
    private String dimensionShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.994387574Z", comments="Source field: public.dq_dimensions.dimension_long_desc")
    private String dimensionLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.994560174Z", comments="Source field: public.dq_dimensions.calculated_field")
    private Boolean calculatedField;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.994730075Z", comments="Source field: public.dq_dimensions.calculation_function")
    private String calculationFunction;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.994861575Z", comments="Source field: public.dq_dimensions.control_id")
    private Short controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.994987575Z", comments="Source field: public.dq_dimensions.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.995112475Z", comments="Source field: public.dq_dimensions.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.995251176Z", comments="Source field: public.dq_dimensions.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.995398176Z", comments="Source field: public.dq_dimensions.updated_ts")
    private Date updatedTs;
}
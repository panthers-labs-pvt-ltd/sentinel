package org.pantherslabs.chimera.sentinel.data_api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DqDimensions {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41665385Z", comments="Source field: public.dq_dimensions.dimension_id")
    private Short dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416704591Z", comments="Source field: public.dq_dimensions.dimension_name")
    private String dimensionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416771216Z", comments="Source field: public.dq_dimensions.dimension_short_desc")
    private String dimensionShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.4168294Z", comments="Source field: public.dq_dimensions.dimension_long_desc")
    private String dimensionLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41687415Z", comments="Source field: public.dq_dimensions.calculated_field")
    private Boolean calculatedField;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416917266Z", comments="Source field: public.dq_dimensions.calculation_function")
    private String calculationFunction;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416973543Z", comments="Source field: public.dq_dimensions.control_id")
    private Short controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417033633Z", comments="Source field: public.dq_dimensions.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41707566Z", comments="Source field: public.dq_dimensions.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417122588Z", comments="Source field: public.dq_dimensions.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417167066Z", comments="Source field: public.dq_dimensions.updated_ts")
    private Date updatedTs;
}
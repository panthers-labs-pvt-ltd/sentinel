package org.pantherslabs.chimera.sentinel.data_api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DqRules {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41856266Z", comments="Source field: public.dq_rules.rule_id")
    private Integer ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.418615398Z", comments="Source field: public.dq_rules.rule_name")
    private String ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.418674308Z", comments="Source field: public.dq_rules.rule_desc")
    private String ruleDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.418719058Z", comments="Source field: public.dq_rules.rule_example")
    private String ruleExample;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.418762628Z", comments="Source field: public.dq_rules.rule_owner")
    private String ruleOwner;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.418805925Z", comments="Source field: public.dq_rules.dimension_id")
    private Integer dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.418848769Z", comments="Source field: public.dq_rules.check_level")
    private String checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.418891522Z", comments="Source field: public.dq_rules.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.418945258Z", comments="Source field: public.dq_rules.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.419002171Z", comments="Source field: public.dq_rules.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.419046467Z", comments="Source field: public.dq_rules.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.419090399Z", comments="Source field: public.dq_rules.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.419528911Z", comments="Source field: public.dq_rules.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.419607246Z", comments="Source field: public.dq_rules.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.419654084Z", comments="Source field: public.dq_rules.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.419701375Z", comments="Source field: public.dq_rules.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.419747577Z", comments="Source field: public.dq_rules.updated_ts")
    private Date updatedTs;
}
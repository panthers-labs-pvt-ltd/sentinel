package org.pantherslabs.chimera.sentinel.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DqRules {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.000177687Z", comments="Source field: public.dq_rules.rule_id")
    private Integer ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.000381987Z", comments="Source field: public.dq_rules.rule_name")
    private String ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.000535087Z", comments="Source field: public.dq_rules.rule_desc")
    private String ruleDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.000743588Z", comments="Source field: public.dq_rules.rule_example")
    private String ruleExample;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.000983688Z", comments="Source field: public.dq_rules.rule_owner")
    private String ruleOwner;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.001157489Z", comments="Source field: public.dq_rules.dimension_id")
    private Integer dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.001297889Z", comments="Source field: public.dq_rules.check_level")
    private String checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.00152039Z", comments="Source field: public.dq_rules.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.00167359Z", comments="Source field: public.dq_rules.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.00180939Z", comments="Source field: public.dq_rules.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.001944391Z", comments="Source field: public.dq_rules.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.002079291Z", comments="Source field: public.dq_rules.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.002725092Z", comments="Source field: public.dq_rules.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.002934793Z", comments="Source field: public.dq_rules.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.003072393Z", comments="Source field: public.dq_rules.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.003207093Z", comments="Source field: public.dq_rules.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.003354294Z", comments="Source field: public.dq_rules.updated_ts")
    private Date updatedTs;
}
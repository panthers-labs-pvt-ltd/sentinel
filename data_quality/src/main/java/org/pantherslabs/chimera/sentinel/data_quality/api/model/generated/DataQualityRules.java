package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataQualityRules {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83481996Z", comments="Source field: sentinel.data_quality_rules.rule_id")
    private String ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.834914666Z", comments="Source field: sentinel.data_quality_rules.dimension_id")
    private String dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.834982169Z", comments="Source field: sentinel.data_quality_rules.rule_name")
    private String ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835068874Z", comments="Source field: sentinel.data_quality_rules.rule_desc")
    private String ruleDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835130078Z", comments="Source field: sentinel.data_quality_rules.rule_example")
    private String ruleExample;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835192781Z", comments="Source field: sentinel.data_quality_rules.rule_owner")
    private String ruleOwner;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835256185Z", comments="Source field: sentinel.data_quality_rules.check_level")
    private String checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83534499Z", comments="Source field: sentinel.data_quality_rules.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835409793Z", comments="Source field: sentinel.data_quality_rules.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835480497Z", comments="Source field: sentinel.data_quality_rules.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835540601Z", comments="Source field: sentinel.data_quality_rules.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835601404Z", comments="Source field: sentinel.data_quality_rules.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835662008Z", comments="Source field: sentinel.data_quality_rules.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835730511Z", comments="Source field: sentinel.data_quality_rules.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835790915Z", comments="Source field: sentinel.data_quality_rules.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835851418Z", comments="Source field: sentinel.data_quality_rules.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835913522Z", comments="Source field: sentinel.data_quality_rules.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.835973025Z", comments="Source field: sentinel.data_quality_rules.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836074131Z", comments="Source field: sentinel.data_quality_rules.updated_ts")
    private Date updatedTs;
}
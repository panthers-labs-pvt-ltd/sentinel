package org.pantherslabs.chimera.sentinel.data_quality.api.model.generated;

import jakarta.annotation.Generated;
import java.util.Date;
import lombok.Data;

@Data
public class DataQualityRules {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.682440998Z", comments="Source field: sentinel.data_quality_rules.rule_id")
    private String ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.682520284Z", comments="Source field: sentinel.data_quality_rules.dimension_id")
    private String dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.682578946Z", comments="Source field: sentinel.data_quality_rules.rule_name")
    private String ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.682690405Z", comments="Source field: sentinel.data_quality_rules.rule_desc")
    private String ruleDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.682748151Z", comments="Source field: sentinel.data_quality_rules.rule_example")
    private String ruleExample;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.68280553Z", comments="Source field: sentinel.data_quality_rules.rule_owner")
    private String ruleOwner;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.682868134Z", comments="Source field: sentinel.data_quality_rules.check_level")
    private String checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.682995449Z", comments="Source field: sentinel.data_quality_rules.effective_from")
    private Date effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683053012Z", comments="Source field: sentinel.data_quality_rules.expiry_date")
    private Date expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683108741Z", comments="Source field: sentinel.data_quality_rules.reserved_5")
    private String reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683165203Z", comments="Source field: sentinel.data_quality_rules.reserved_4")
    private String reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683249622Z", comments="Source field: sentinel.data_quality_rules.reserved_3")
    private String reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683314334Z", comments="Source field: sentinel.data_quality_rules.reserved_2")
    private String reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683372447Z", comments="Source field: sentinel.data_quality_rules.reserved_1")
    private String reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683428909Z", comments="Source field: sentinel.data_quality_rules.active_flg")
    private String activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683486563Z", comments="Source field: sentinel.data_quality_rules.created_by")
    private String createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683548984Z", comments="Source field: sentinel.data_quality_rules.created_ts")
    private Date createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683608563Z", comments="Source field: sentinel.data_quality_rules.updated_by")
    private String updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.683663467Z", comments="Source field: sentinel.data_quality_rules.updated_ts")
    private Date updatedTs;
}
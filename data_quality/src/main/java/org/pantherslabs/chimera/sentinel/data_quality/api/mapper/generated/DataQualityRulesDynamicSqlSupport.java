package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataQualityRulesDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836255141Z", comments="Source Table: sentinel.data_quality_rules")
    public static final DataQualityRules dataQualityRules = new DataQualityRules();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836354046Z", comments="Source field: sentinel.data_quality_rules.rule_id")
    public static final SqlColumn<String> ruleId = dataQualityRules.ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836386448Z", comments="Source field: sentinel.data_quality_rules.dimension_id")
    public static final SqlColumn<String> dimensionId = dataQualityRules.dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83641595Z", comments="Source field: sentinel.data_quality_rules.rule_name")
    public static final SqlColumn<String> ruleName = dataQualityRules.ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836450252Z", comments="Source field: sentinel.data_quality_rules.rule_desc")
    public static final SqlColumn<String> ruleDesc = dataQualityRules.ruleDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836505855Z", comments="Source field: sentinel.data_quality_rules.rule_example")
    public static final SqlColumn<String> ruleExample = dataQualityRules.ruleExample;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836538657Z", comments="Source field: sentinel.data_quality_rules.rule_owner")
    public static final SqlColumn<String> ruleOwner = dataQualityRules.ruleOwner;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836567458Z", comments="Source field: sentinel.data_quality_rules.check_level")
    public static final SqlColumn<String> checkLevel = dataQualityRules.checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83659796Z", comments="Source field: sentinel.data_quality_rules.effective_from")
    public static final SqlColumn<Date> effectiveFrom = dataQualityRules.effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836629362Z", comments="Source field: sentinel.data_quality_rules.expiry_date")
    public static final SqlColumn<Date> expiryDate = dataQualityRules.expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836658564Z", comments="Source field: sentinel.data_quality_rules.reserved_5")
    public static final SqlColumn<String> reserved5 = dataQualityRules.reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836686865Z", comments="Source field: sentinel.data_quality_rules.reserved_4")
    public static final SqlColumn<String> reserved4 = dataQualityRules.reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836715767Z", comments="Source field: sentinel.data_quality_rules.reserved_3")
    public static final SqlColumn<String> reserved3 = dataQualityRules.reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836743968Z", comments="Source field: sentinel.data_quality_rules.reserved_2")
    public static final SqlColumn<String> reserved2 = dataQualityRules.reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83677427Z", comments="Source field: sentinel.data_quality_rules.reserved_1")
    public static final SqlColumn<String> reserved1 = dataQualityRules.reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836802872Z", comments="Source field: sentinel.data_quality_rules.active_flg")
    public static final SqlColumn<String> activeFlg = dataQualityRules.activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836831373Z", comments="Source field: sentinel.data_quality_rules.created_by")
    public static final SqlColumn<String> createdBy = dataQualityRules.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836861175Z", comments="Source field: sentinel.data_quality_rules.created_ts")
    public static final SqlColumn<Date> createdTs = dataQualityRules.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836888877Z", comments="Source field: sentinel.data_quality_rules.updated_by")
    public static final SqlColumn<String> updatedBy = dataQualityRules.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836917778Z", comments="Source field: sentinel.data_quality_rules.updated_ts")
    public static final SqlColumn<Date> updatedTs = dataQualityRules.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.836317144Z", comments="Source Table: sentinel.data_quality_rules")
    public static final class DataQualityRules extends AliasableSqlTable<DataQualityRules> {
        public final SqlColumn<String> ruleId = column("rule_id", JDBCType.VARCHAR);

        public final SqlColumn<String> dimensionId = column("dimension_id", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleName = column("rule_name", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleDesc = column("rule_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleExample = column("rule_example", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleOwner = column("rule_owner", JDBCType.VARCHAR);

        public final SqlColumn<String> checkLevel = column("check_level", JDBCType.VARCHAR);

        public final SqlColumn<Date> effectiveFrom = column("effective_from", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> expiryDate = column("expiry_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> reserved5 = column("reserved_5", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved4 = column("reserved_4", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved3 = column("reserved_3", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved2 = column("reserved_2", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved1 = column("reserved_1", JDBCType.VARCHAR);

        public final SqlColumn<String> activeFlg = column("active_flg", JDBCType.VARCHAR);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTs = column("created_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updatedBy = column("updated_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> updatedTs = column("updated_ts", JDBCType.TIMESTAMP);

        public DataQualityRules() {
            super("\"sentinel\".\"data_quality_rules\"", DataQualityRules::new);
        }
    }
}
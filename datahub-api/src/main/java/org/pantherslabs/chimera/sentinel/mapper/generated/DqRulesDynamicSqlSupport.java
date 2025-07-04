package org.pantherslabs.chimera.sentinel.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DqRulesDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.003681494Z", comments="Source Table: public.dq_rules")
    public static final DqRules dqRules = new DqRules();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004008495Z", comments="Source field: public.dq_rules.rule_id")
    public static final SqlColumn<Integer> ruleId = dqRules.ruleId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004105695Z", comments="Source field: public.dq_rules.rule_name")
    public static final SqlColumn<String> ruleName = dqRules.ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004191695Z", comments="Source field: public.dq_rules.rule_desc")
    public static final SqlColumn<String> ruleDesc = dqRules.ruleDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004279096Z", comments="Source field: public.dq_rules.rule_example")
    public static final SqlColumn<String> ruleExample = dqRules.ruleExample;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004357796Z", comments="Source field: public.dq_rules.rule_owner")
    public static final SqlColumn<String> ruleOwner = dqRules.ruleOwner;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004433096Z", comments="Source field: public.dq_rules.dimension_id")
    public static final SqlColumn<Integer> dimensionId = dqRules.dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004509996Z", comments="Source field: public.dq_rules.check_level")
    public static final SqlColumn<String> checkLevel = dqRules.checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004621596Z", comments="Source field: public.dq_rules.reserved_5")
    public static final SqlColumn<String> reserved5 = dqRules.reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004712997Z", comments="Source field: public.dq_rules.reserved_4")
    public static final SqlColumn<String> reserved4 = dqRules.reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004790897Z", comments="Source field: public.dq_rules.reserved_3")
    public static final SqlColumn<String> reserved3 = dqRules.reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004868497Z", comments="Source field: public.dq_rules.reserved_2")
    public static final SqlColumn<String> reserved2 = dqRules.reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.004963897Z", comments="Source field: public.dq_rules.reserved_1")
    public static final SqlColumn<String> reserved1 = dqRules.reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.005047697Z", comments="Source field: public.dq_rules.active_flg")
    public static final SqlColumn<String> activeFlg = dqRules.activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.005130498Z", comments="Source field: public.dq_rules.created_by")
    public static final SqlColumn<String> createdBy = dqRules.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.005218298Z", comments="Source field: public.dq_rules.created_ts")
    public static final SqlColumn<Date> createdTs = dqRules.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.005305898Z", comments="Source field: public.dq_rules.updated_by")
    public static final SqlColumn<String> updatedBy = dqRules.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.005388298Z", comments="Source field: public.dq_rules.updated_ts")
    public static final SqlColumn<Date> updatedTs = dqRules.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.003826795Z", comments="Source Table: public.dq_rules")
    public static final class DqRules extends AliasableSqlTable<DqRules> {
        public final SqlColumn<Integer> ruleId = column("rule_id", JDBCType.INTEGER);

        public final SqlColumn<String> ruleName = column("rule_name", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleDesc = column("rule_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleExample = column("rule_example", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleOwner = column("rule_owner", JDBCType.VARCHAR);

        public final SqlColumn<Integer> dimensionId = column("dimension_id", JDBCType.INTEGER);

        public final SqlColumn<String> checkLevel = column("check_level", JDBCType.VARCHAR);

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

        public DqRules() {
            super("\"public\".\"dq_rules\"", DqRules::new);
        }
    }
}
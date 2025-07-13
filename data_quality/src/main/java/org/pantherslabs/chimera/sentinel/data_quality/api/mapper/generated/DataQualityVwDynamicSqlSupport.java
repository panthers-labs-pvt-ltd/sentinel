package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataQualityVwDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.851221482Z", comments="Source Table: sentinel.data_quality_vw")
    public static final DataQualityVw dataQualityVw = new DataQualityVw();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.851284585Z", comments="Source field: sentinel.data_quality_vw.rownum")
    public static final SqlColumn<Long> rownum = dataQualityVw.rownum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.851308286Z", comments="Source field: sentinel.data_quality_vw.process_name")
    public static final SqlColumn<String> processName = dataQualityVw.processName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.851330088Z", comments="Source field: sentinel.data_quality_vw.control_name")
    public static final SqlColumn<String> controlName = dataQualityVw.controlName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.851350889Z", comments="Source field: sentinel.data_quality_vw.dimension_name")
    public static final SqlColumn<String> dimensionName = dataQualityVw.dimensionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.852168335Z", comments="Source field: sentinel.data_quality_vw.rule_name")
    public static final SqlColumn<String> ruleName = dataQualityVw.ruleName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.852227438Z", comments="Source field: sentinel.data_quality_vw.rule_column")
    public static final SqlColumn<String> ruleColumn = dataQualityVw.ruleColumn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.852250439Z", comments="Source field: sentinel.data_quality_vw.rule_value")
    public static final SqlColumn<String> ruleValue = dataQualityVw.ruleValue;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.852270941Z", comments="Source field: sentinel.data_quality_vw.database_name")
    public static final SqlColumn<String> databaseName = dataQualityVw.databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.852300342Z", comments="Source field: sentinel.data_quality_vw.schema_name")
    public static final SqlColumn<String> schemaName = dataQualityVw.schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.852321543Z", comments="Source field: sentinel.data_quality_vw.table_name")
    public static final SqlColumn<String> tableName = dataQualityVw.tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.852340844Z", comments="Source field: sentinel.data_quality_vw.partition_keys")
    public static final SqlColumn<String> partitionKeys = dataQualityVw.partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.852359646Z", comments="Source field: sentinel.data_quality_vw.check_level")
    public static final SqlColumn<String> checkLevel = dataQualityVw.checkLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.851253083Z", comments="Source Table: sentinel.data_quality_vw")
    public static final class DataQualityVw extends AliasableSqlTable<DataQualityVw> {
        public final SqlColumn<Long> rownum = column("rownum", JDBCType.BIGINT);

        public final SqlColumn<String> processName = column("process_name", JDBCType.VARCHAR);

        public final SqlColumn<String> controlName = column("control_name", JDBCType.VARCHAR);

        public final SqlColumn<String> dimensionName = column("dimension_name", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleName = column("rule_name", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleColumn = column("rule_column", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleValue = column("rule_value", JDBCType.VARCHAR);

        public final SqlColumn<String> databaseName = column("database_name", JDBCType.VARCHAR);

        public final SqlColumn<String> schemaName = column("schema_name", JDBCType.VARCHAR);

        public final SqlColumn<String> tableName = column("table_name", JDBCType.VARCHAR);

        public final SqlColumn<String> partitionKeys = column("partition_keys", JDBCType.VARCHAR);

        public final SqlColumn<String> checkLevel = column("check_level", JDBCType.VARCHAR);

        public DataQualityVw() {
            super("\"sentinel\".\"data_quality_vw\"", DataQualityVw::new);
        }
    }
}
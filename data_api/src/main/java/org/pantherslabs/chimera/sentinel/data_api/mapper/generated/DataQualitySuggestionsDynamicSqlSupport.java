package org.pantherslabs.chimera.sentinel.data_api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataQualitySuggestionsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415296197Z", comments="Source Table: public.data_quality_suggestions")
    public static final DataQualitySuggestions dataQualitySuggestions = new DataQualitySuggestions();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415375349Z", comments="Source field: public.data_quality_suggestions.dq_cnstnt_id")
    public static final SqlColumn<String> dqCnstntId = dataQualitySuggestions.dqCnstntId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415459039Z", comments="Source field: public.data_quality_suggestions.row_num")
    public static final SqlColumn<Integer> rowNum = dataQualitySuggestions.rowNum;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415491535Z", comments="Source field: public.data_quality_suggestions.process_typ_nm")
    public static final SqlColumn<String> processTypNm = dataQualitySuggestions.processTypNm;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415517223Z", comments="Source field: public.data_quality_suggestions.database_name")
    public static final SqlColumn<String> databaseName = dataQualitySuggestions.databaseName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41554273Z", comments="Source field: public.data_quality_suggestions.schema_name")
    public static final SqlColumn<String> schemaName = dataQualitySuggestions.schemaName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415570052Z", comments="Source field: public.data_quality_suggestions.table_name")
    public static final SqlColumn<String> tableName = dataQualitySuggestions.tableName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41559574Z", comments="Source field: public.data_quality_suggestions.partition_keys")
    public static final SqlColumn<String> partitionKeys = dataQualitySuggestions.partitionKeys;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415626148Z", comments="Source field: public.data_quality_suggestions.rule_col")
    public static final SqlColumn<String> ruleCol = dataQualitySuggestions.ruleCol;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415650928Z", comments="Source field: public.data_quality_suggestions.dq_constraint")
    public static final SqlColumn<String> dqConstraint = dataQualitySuggestions.dqConstraint;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415674437Z", comments="Source field: public.data_quality_suggestions.scala_code")
    public static final SqlColumn<String> scalaCode = dataQualitySuggestions.scalaCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415697947Z", comments="Source field: public.data_quality_suggestions.reserved_5")
    public static final SqlColumn<String> reserved5 = dataQualitySuggestions.reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415721366Z", comments="Source field: public.data_quality_suggestions.reserved_4")
    public static final SqlColumn<String> reserved4 = dataQualitySuggestions.reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415745057Z", comments="Source field: public.data_quality_suggestions.reserved_3")
    public static final SqlColumn<String> reserved3 = dataQualitySuggestions.reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415769293Z", comments="Source field: public.data_quality_suggestions.reserved_2")
    public static final SqlColumn<String> reserved2 = dataQualitySuggestions.reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415793801Z", comments="Source field: public.data_quality_suggestions.reserved_1")
    public static final SqlColumn<String> reserved1 = dataQualitySuggestions.reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415817764Z", comments="Source field: public.data_quality_suggestions.suggestion_counter")
    public static final SqlColumn<Integer> suggestionCounter = dataQualitySuggestions.suggestionCounter;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415862877Z", comments="Source field: public.data_quality_suggestions.ranking")
    public static final SqlColumn<Integer> ranking = dataQualitySuggestions.ranking;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415345032Z", comments="Source Table: public.data_quality_suggestions")
    public static final class DataQualitySuggestions extends AliasableSqlTable<DataQualitySuggestions> {
        public final SqlColumn<String> dqCnstntId = column("dq_cnstnt_id", JDBCType.VARCHAR);

        public final SqlColumn<Integer> rowNum = column("row_num", JDBCType.INTEGER);

        public final SqlColumn<String> processTypNm = column("process_typ_nm", JDBCType.VARCHAR);

        public final SqlColumn<String> databaseName = column("database_name", JDBCType.VARCHAR);

        public final SqlColumn<String> schemaName = column("schema_name", JDBCType.VARCHAR);

        public final SqlColumn<String> tableName = column("table_name", JDBCType.VARCHAR);

        public final SqlColumn<String> partitionKeys = column("partition_keys", JDBCType.VARCHAR);

        public final SqlColumn<String> ruleCol = column("rule_col", JDBCType.VARCHAR);

        public final SqlColumn<String> dqConstraint = column("dq_constraint", JDBCType.VARCHAR);

        public final SqlColumn<String> scalaCode = column("scala_code", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved5 = column("reserved_5", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved4 = column("reserved_4", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved3 = column("reserved_3", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved2 = column("reserved_2", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved1 = column("reserved_1", JDBCType.VARCHAR);

        public final SqlColumn<Integer> suggestionCounter = column("suggestion_counter", JDBCType.INTEGER);

        public final SqlColumn<Integer> ranking = column("ranking", JDBCType.INTEGER);

        public DataQualitySuggestions() {
            super("\"public\".\"data_quality_suggestions\"", DataQualitySuggestions::new);
        }
    }
}
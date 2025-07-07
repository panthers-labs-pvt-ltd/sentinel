package org.pantherslabs.chimera.sentinel.data_api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.data_api.mapper.generated.DataQualitySuggestionsDynamicSqlSupport.*;

import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.pantherslabs.chimera.sentinel.data_api.model.generated.DataQualitySuggestions;

@Mapper
public interface DataQualitySuggestionsMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataQualitySuggestions>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416261722Z", comments="Source Table: public.data_quality_suggestions")
    BasicColumn[] selectList = BasicColumn.columnList(dqCnstntId, rowNum, processTypNm, databaseName, schemaName, tableName, partitionKeys, ruleCol, dqConstraint, scalaCode, reserved5, reserved4, reserved3, reserved2, reserved1, suggestionCounter, ranking);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415895282Z", comments="Source Table: public.data_quality_suggestions")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataQualitySuggestionsResult", value = {
        @Result(column="dq_cnstnt_id", property="dqCnstntId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="row_num", property="rowNum", jdbcType=JdbcType.INTEGER),
        @Result(column="process_typ_nm", property="processTypNm", jdbcType=JdbcType.VARCHAR),
        @Result(column="database_name", property="databaseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="schema_name", property="schemaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="table_name", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="partition_keys", property="partitionKeys", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_col", property="ruleCol", jdbcType=JdbcType.VARCHAR),
        @Result(column="dq_constraint", property="dqConstraint", jdbcType=JdbcType.VARCHAR),
        @Result(column="scala_code", property="scalaCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_5", property="reserved5", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_4", property="reserved4", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_3", property="reserved3", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_2", property="reserved2", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_1", property="reserved1", jdbcType=JdbcType.VARCHAR),
        @Result(column="suggestion_counter", property="suggestionCounter", jdbcType=JdbcType.INTEGER),
        @Result(column="ranking", property="ranking", jdbcType=JdbcType.INTEGER)
    })
    List<DataQualitySuggestions> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415960364Z", comments="Source Table: public.data_quality_suggestions")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataQualitySuggestionsResult")
    Optional<DataQualitySuggestions> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.415989683Z", comments="Source Table: public.data_quality_suggestions")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataQualitySuggestions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41601882Z", comments="Source Table: public.data_quality_suggestions")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataQualitySuggestions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416042693Z", comments="Source Table: public.data_quality_suggestions")
    default int deleteByPrimaryKey(String dqCnstntId_) {
        return delete(c -> 
            c.where(dqCnstntId, isEqualTo(dqCnstntId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416066656Z", comments="Source Table: public.data_quality_suggestions")
    default int insert(DataQualitySuggestions row) {
        return MyBatis3Utils.insert(this::insert, row, dataQualitySuggestions, c ->
            c.map(dqCnstntId).toProperty("dqCnstntId")
            .map(rowNum).toProperty("rowNum")
            .map(processTypNm).toProperty("processTypNm")
            .map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKeys).toProperty("partitionKeys")
            .map(ruleCol).toProperty("ruleCol")
            .map(dqConstraint).toProperty("dqConstraint")
            .map(scalaCode).toProperty("scalaCode")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
            .map(suggestionCounter).toProperty("suggestionCounter")
            .map(ranking).toProperty("ranking")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416120302Z", comments="Source Table: public.data_quality_suggestions")
    default int insertMultiple(Collection<DataQualitySuggestions> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataQualitySuggestions, c ->
            c.map(dqCnstntId).toProperty("dqCnstntId")
            .map(rowNum).toProperty("rowNum")
            .map(processTypNm).toProperty("processTypNm")
            .map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKeys).toProperty("partitionKeys")
            .map(ruleCol).toProperty("ruleCol")
            .map(dqConstraint).toProperty("dqConstraint")
            .map(scalaCode).toProperty("scalaCode")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
            .map(suggestionCounter).toProperty("suggestionCounter")
            .map(ranking).toProperty("ranking")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416175762Z", comments="Source Table: public.data_quality_suggestions")
    default int insertSelective(DataQualitySuggestions row) {
        return MyBatis3Utils.insert(this::insert, row, dataQualitySuggestions, c ->
            c.map(dqCnstntId).toPropertyWhenPresent("dqCnstntId", row::getDqCnstntId)
            .map(rowNum).toPropertyWhenPresent("rowNum", row::getRowNum)
            .map(processTypNm).toPropertyWhenPresent("processTypNm", row::getProcessTypNm)
            .map(databaseName).toPropertyWhenPresent("databaseName", row::getDatabaseName)
            .map(schemaName).toPropertyWhenPresent("schemaName", row::getSchemaName)
            .map(tableName).toPropertyWhenPresent("tableName", row::getTableName)
            .map(partitionKeys).toPropertyWhenPresent("partitionKeys", row::getPartitionKeys)
            .map(ruleCol).toPropertyWhenPresent("ruleCol", row::getRuleCol)
            .map(dqConstraint).toPropertyWhenPresent("dqConstraint", row::getDqConstraint)
            .map(scalaCode).toPropertyWhenPresent("scalaCode", row::getScalaCode)
            .map(reserved5).toPropertyWhenPresent("reserved5", row::getReserved5)
            .map(reserved4).toPropertyWhenPresent("reserved4", row::getReserved4)
            .map(reserved3).toPropertyWhenPresent("reserved3", row::getReserved3)
            .map(reserved2).toPropertyWhenPresent("reserved2", row::getReserved2)
            .map(reserved1).toPropertyWhenPresent("reserved1", row::getReserved1)
            .map(suggestionCounter).toPropertyWhenPresent("suggestionCounter", row::getSuggestionCounter)
            .map(ranking).toPropertyWhenPresent("ranking", row::getRanking)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416288227Z", comments="Source Table: public.data_quality_suggestions")
    default Optional<DataQualitySuggestions> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataQualitySuggestions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416313279Z", comments="Source Table: public.data_quality_suggestions")
    default List<DataQualitySuggestions> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataQualitySuggestions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416338877Z", comments="Source Table: public.data_quality_suggestions")
    default List<DataQualitySuggestions> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataQualitySuggestions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41636284Z", comments="Source Table: public.data_quality_suggestions")
    default Optional<DataQualitySuggestions> selectByPrimaryKey(String dqCnstntId_) {
        return selectOne(c ->
            c.where(dqCnstntId, isEqualTo(dqCnstntId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416389164Z", comments="Source Table: public.data_quality_suggestions")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataQualitySuggestions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416414307Z", comments="Source Table: public.data_quality_suggestions")
    static UpdateDSL<UpdateModel> updateAllColumns(DataQualitySuggestions row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dqCnstntId).equalTo(row::getDqCnstntId)
                .set(rowNum).equalTo(row::getRowNum)
                .set(processTypNm).equalTo(row::getProcessTypNm)
                .set(databaseName).equalTo(row::getDatabaseName)
                .set(schemaName).equalTo(row::getSchemaName)
                .set(tableName).equalTo(row::getTableName)
                .set(partitionKeys).equalTo(row::getPartitionKeys)
                .set(ruleCol).equalTo(row::getRuleCol)
                .set(dqConstraint).equalTo(row::getDqConstraint)
                .set(scalaCode).equalTo(row::getScalaCode)
                .set(reserved5).equalTo(row::getReserved5)
                .set(reserved4).equalTo(row::getReserved4)
                .set(reserved3).equalTo(row::getReserved3)
                .set(reserved2).equalTo(row::getReserved2)
                .set(reserved1).equalTo(row::getReserved1)
                .set(suggestionCounter).equalTo(row::getSuggestionCounter)
                .set(ranking).equalTo(row::getRanking);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416464957Z", comments="Source Table: public.data_quality_suggestions")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataQualitySuggestions row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dqCnstntId).equalToWhenPresent(row::getDqCnstntId)
                .set(rowNum).equalToWhenPresent(row::getRowNum)
                .set(processTypNm).equalToWhenPresent(row::getProcessTypNm)
                .set(databaseName).equalToWhenPresent(row::getDatabaseName)
                .set(schemaName).equalToWhenPresent(row::getSchemaName)
                .set(tableName).equalToWhenPresent(row::getTableName)
                .set(partitionKeys).equalToWhenPresent(row::getPartitionKeys)
                .set(ruleCol).equalToWhenPresent(row::getRuleCol)
                .set(dqConstraint).equalToWhenPresent(row::getDqConstraint)
                .set(scalaCode).equalToWhenPresent(row::getScalaCode)
                .set(reserved5).equalToWhenPresent(row::getReserved5)
                .set(reserved4).equalToWhenPresent(row::getReserved4)
                .set(reserved3).equalToWhenPresent(row::getReserved3)
                .set(reserved2).equalToWhenPresent(row::getReserved2)
                .set(reserved1).equalToWhenPresent(row::getReserved1)
                .set(suggestionCounter).equalToWhenPresent(row::getSuggestionCounter)
                .set(ranking).equalToWhenPresent(row::getRanking);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416519419Z", comments="Source Table: public.data_quality_suggestions")
    default int updateByPrimaryKey(DataQualitySuggestions row) {
        return update(c ->
            c.set(rowNum).equalTo(row::getRowNum)
            .set(processTypNm).equalTo(row::getProcessTypNm)
            .set(databaseName).equalTo(row::getDatabaseName)
            .set(schemaName).equalTo(row::getSchemaName)
            .set(tableName).equalTo(row::getTableName)
            .set(partitionKeys).equalTo(row::getPartitionKeys)
            .set(ruleCol).equalTo(row::getRuleCol)
            .set(dqConstraint).equalTo(row::getDqConstraint)
            .set(scalaCode).equalTo(row::getScalaCode)
            .set(reserved5).equalTo(row::getReserved5)
            .set(reserved4).equalTo(row::getReserved4)
            .set(reserved3).equalTo(row::getReserved3)
            .set(reserved2).equalTo(row::getReserved2)
            .set(reserved1).equalTo(row::getReserved1)
            .set(suggestionCounter).equalTo(row::getSuggestionCounter)
            .set(ranking).equalTo(row::getRanking)
            .where(dqCnstntId, isEqualTo(row::getDqCnstntId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.416573246Z", comments="Source Table: public.data_quality_suggestions")
    default int updateByPrimaryKeySelective(DataQualitySuggestions row) {
        return update(c ->
            c.set(rowNum).equalToWhenPresent(row::getRowNum)
            .set(processTypNm).equalToWhenPresent(row::getProcessTypNm)
            .set(databaseName).equalToWhenPresent(row::getDatabaseName)
            .set(schemaName).equalToWhenPresent(row::getSchemaName)
            .set(tableName).equalToWhenPresent(row::getTableName)
            .set(partitionKeys).equalToWhenPresent(row::getPartitionKeys)
            .set(ruleCol).equalToWhenPresent(row::getRuleCol)
            .set(dqConstraint).equalToWhenPresent(row::getDqConstraint)
            .set(scalaCode).equalToWhenPresent(row::getScalaCode)
            .set(reserved5).equalToWhenPresent(row::getReserved5)
            .set(reserved4).equalToWhenPresent(row::getReserved4)
            .set(reserved3).equalToWhenPresent(row::getReserved3)
            .set(reserved2).equalToWhenPresent(row::getReserved2)
            .set(reserved1).equalToWhenPresent(row::getReserved1)
            .set(suggestionCounter).equalToWhenPresent(row::getSuggestionCounter)
            .set(ranking).equalToWhenPresent(row::getRanking)
            .where(dqCnstntId, isEqualTo(row::getDqCnstntId))
        );
    }
}
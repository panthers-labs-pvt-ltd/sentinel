package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import static org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated.DataQualityVwDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataQualityVw;

@Mapper
public interface DataQualityVwMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataQualityVw>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698515588Z", comments="Source Table: sentinel.data_quality_vw")
    BasicColumn[] selectList = BasicColumn.columnList(rownum, processName, controlName, dimensionName, ruleName, ruleColumn, ruleValue, databaseName, schemaName, tableName, partitionKeys, checkLevel);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698017966Z", comments="Source Table: sentinel.data_quality_vw")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataQualityVwResult", value = {
        @Result(column="rownum", property="rownum", jdbcType=JdbcType.BIGINT),
        @Result(column="process_name", property="processName", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_name", property="controlName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dimension_name", property="dimensionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_name", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_column", property="ruleColumn", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_value", property="ruleValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="database_name", property="databaseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="schema_name", property="schemaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="table_name", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="partition_keys", property="partitionKeys", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_level", property="checkLevel", jdbcType=JdbcType.VARCHAR)
    })
    List<DataQualityVw> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698094044Z", comments="Source Table: sentinel.data_quality_vw")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataQualityVwResult")
    Optional<DataQualityVw> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698151148Z", comments="Source Table: sentinel.data_quality_vw")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataQualityVw, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698178096Z", comments="Source Table: sentinel.data_quality_vw")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataQualityVw, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698203944Z", comments="Source Table: sentinel.data_quality_vw")
    default int insert(DataQualityVw row) {
        return MyBatis3Utils.insert(this::insert, row, dataQualityVw, c ->
            c.map(rownum).toProperty("rownum")
            .map(processName).toProperty("processName")
            .map(controlName).toProperty("controlName")
            .map(dimensionName).toProperty("dimensionName")
            .map(ruleName).toProperty("ruleName")
            .map(ruleColumn).toProperty("ruleColumn")
            .map(ruleValue).toProperty("ruleValue")
            .map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKeys).toProperty("partitionKeys")
            .map(checkLevel).toProperty("checkLevel")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698311003Z", comments="Source Table: sentinel.data_quality_vw")
    default int insertMultiple(Collection<DataQualityVw> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataQualityVw, c ->
            c.map(rownum).toProperty("rownum")
            .map(processName).toProperty("processName")
            .map(controlName).toProperty("controlName")
            .map(dimensionName).toProperty("dimensionName")
            .map(ruleName).toProperty("ruleName")
            .map(ruleColumn).toProperty("ruleColumn")
            .map(ruleValue).toProperty("ruleValue")
            .map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKeys).toProperty("partitionKeys")
            .map(checkLevel).toProperty("checkLevel")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698406696Z", comments="Source Table: sentinel.data_quality_vw")
    default int insertSelective(DataQualityVw row) {
        return MyBatis3Utils.insert(this::insert, row, dataQualityVw, c ->
            c.map(rownum).toPropertyWhenPresent("rownum", row::getRownum)
            .map(processName).toPropertyWhenPresent("processName", row::getProcessName)
            .map(controlName).toPropertyWhenPresent("controlName", row::getControlName)
            .map(dimensionName).toPropertyWhenPresent("dimensionName", row::getDimensionName)
            .map(ruleName).toPropertyWhenPresent("ruleName", row::getRuleName)
            .map(ruleColumn).toPropertyWhenPresent("ruleColumn", row::getRuleColumn)
            .map(ruleValue).toPropertyWhenPresent("ruleValue", row::getRuleValue)
            .map(databaseName).toPropertyWhenPresent("databaseName", row::getDatabaseName)
            .map(schemaName).toPropertyWhenPresent("schemaName", row::getSchemaName)
            .map(tableName).toPropertyWhenPresent("tableName", row::getTableName)
            .map(partitionKeys).toPropertyWhenPresent("partitionKeys", row::getPartitionKeys)
            .map(checkLevel).toPropertyWhenPresent("checkLevel", row::getCheckLevel)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69855326Z", comments="Source Table: sentinel.data_quality_vw")
    default Optional<DataQualityVw> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataQualityVw, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698580667Z", comments="Source Table: sentinel.data_quality_vw")
    default List<DataQualityVw> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataQualityVw, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698609815Z", comments="Source Table: sentinel.data_quality_vw")
    default List<DataQualityVw> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataQualityVw, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698636304Z", comments="Source Table: sentinel.data_quality_vw")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataQualityVw, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698662061Z", comments="Source Table: sentinel.data_quality_vw")
    static UpdateDSL<UpdateModel> updateAllColumns(DataQualityVw row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(rownum).equalTo(row::getRownum)
                .set(processName).equalTo(row::getProcessName)
                .set(controlName).equalTo(row::getControlName)
                .set(dimensionName).equalTo(row::getDimensionName)
                .set(ruleName).equalTo(row::getRuleName)
                .set(ruleColumn).equalTo(row::getRuleColumn)
                .set(ruleValue).equalTo(row::getRuleValue)
                .set(databaseName).equalTo(row::getDatabaseName)
                .set(schemaName).equalTo(row::getSchemaName)
                .set(tableName).equalTo(row::getTableName)
                .set(partitionKeys).equalTo(row::getPartitionKeys)
                .set(checkLevel).equalTo(row::getCheckLevel);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.698707341Z", comments="Source Table: sentinel.data_quality_vw")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataQualityVw row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(rownum).equalToWhenPresent(row::getRownum)
                .set(processName).equalToWhenPresent(row::getProcessName)
                .set(controlName).equalToWhenPresent(row::getControlName)
                .set(dimensionName).equalToWhenPresent(row::getDimensionName)
                .set(ruleName).equalToWhenPresent(row::getRuleName)
                .set(ruleColumn).equalToWhenPresent(row::getRuleColumn)
                .set(ruleValue).equalToWhenPresent(row::getRuleValue)
                .set(databaseName).equalToWhenPresent(row::getDatabaseName)
                .set(schemaName).equalToWhenPresent(row::getSchemaName)
                .set(tableName).equalToWhenPresent(row::getTableName)
                .set(partitionKeys).equalToWhenPresent(row::getPartitionKeys)
                .set(checkLevel).equalToWhenPresent(row::getCheckLevel);
    }
}
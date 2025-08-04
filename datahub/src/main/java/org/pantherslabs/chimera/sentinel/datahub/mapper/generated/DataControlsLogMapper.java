package org.pantherslabs.chimera.sentinel.datahub.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.datahub.mapper.generated.DataControlsLogDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.datahub.model.generated.DataControlsLog;

@Mapper
public interface DataControlsLogMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataControlsLog>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.61488288Z", comments="Source Table: public.data_controls_log")
    BasicColumn[] selectList = BasicColumn.columnList(logId, batchId, controlType, controlDimension, processType, databaseName, schemaName, tableName, partitionKeys, businessDate, ruleColumn, ruleName, ruleValue, checkLevel, constraintDesc, constraintMsg, status, executionTs, reserved5, reserved4, reserved3, reserved2, reserved1);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.614087755Z", comments="Source Table: public.data_controls_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataControlsLogResult", value = {
        @Result(column="log_id", property="logId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="batch_id", property="batchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_type", property="controlType", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_dimension", property="controlDimension", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_type", property="processType", jdbcType=JdbcType.VARCHAR),
        @Result(column="database_name", property="databaseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="schema_name", property="schemaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="table_name", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="partition_keys", property="partitionKeys", jdbcType=JdbcType.VARCHAR),
        @Result(column="business_date", property="businessDate", jdbcType=JdbcType.DATE),
        @Result(column="rule_column", property="ruleColumn", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_name", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_value", property="ruleValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_level", property="checkLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="constraint_desc", property="constraintDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="constraint_msg", property="constraintMsg", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="execution_ts", property="executionTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reserved_5", property="reserved5", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_4", property="reserved4", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_3", property="reserved3", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_2", property="reserved2", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_1", property="reserved1", jdbcType=JdbcType.VARCHAR)
    })
    List<DataControlsLog> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.614201344Z", comments="Source Table: public.data_controls_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataControlsLogResult")
    Optional<DataControlsLog> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.614272103Z", comments="Source Table: public.data_controls_log")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.614321119Z", comments="Source Table: public.data_controls_log")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.614361981Z", comments="Source Table: public.data_controls_log")
    default int deleteByPrimaryKey(Long logId_) {
        return delete(c -> 
            c.where(logId, isEqualTo(logId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.614405093Z", comments="Source Table: public.data_controls_log")
    default int insert(DataControlsLog row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlsLog, c ->
            c.map(logId).toProperty("logId")
            .map(batchId).toProperty("batchId")
            .map(controlType).toProperty("controlType")
            .map(controlDimension).toProperty("controlDimension")
            .map(processType).toProperty("processType")
            .map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKeys).toProperty("partitionKeys")
            .map(businessDate).toProperty("businessDate")
            .map(ruleColumn).toProperty("ruleColumn")
            .map(ruleName).toProperty("ruleName")
            .map(ruleValue).toProperty("ruleValue")
            .map(checkLevel).toProperty("checkLevel")
            .map(constraintDesc).toProperty("constraintDesc")
            .map(constraintMsg).toProperty("constraintMsg")
            .map(status).toProperty("status")
            .map(executionTs).toProperty("executionTs")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.614548673Z", comments="Source Table: public.data_controls_log")
    default int insertMultiple(Collection<DataControlsLog> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataControlsLog, c ->
            c.map(logId).toProperty("logId")
            .map(batchId).toProperty("batchId")
            .map(controlType).toProperty("controlType")
            .map(controlDimension).toProperty("controlDimension")
            .map(processType).toProperty("processType")
            .map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKeys).toProperty("partitionKeys")
            .map(businessDate).toProperty("businessDate")
            .map(ruleColumn).toProperty("ruleColumn")
            .map(ruleName).toProperty("ruleName")
            .map(ruleValue).toProperty("ruleValue")
            .map(checkLevel).toProperty("checkLevel")
            .map(constraintDesc).toProperty("constraintDesc")
            .map(constraintMsg).toProperty("constraintMsg")
            .map(status).toProperty("status")
            .map(executionTs).toProperty("executionTs")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.61468841Z", comments="Source Table: public.data_controls_log")
    default int insertSelective(DataControlsLog row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlsLog, c ->
            c.map(logId).toPropertyWhenPresent("logId", row::getLogId)
            .map(batchId).toPropertyWhenPresent("batchId", row::getBatchId)
            .map(controlType).toPropertyWhenPresent("controlType", row::getControlType)
            .map(controlDimension).toPropertyWhenPresent("controlDimension", row::getControlDimension)
            .map(processType).toPropertyWhenPresent("processType", row::getProcessType)
            .map(databaseName).toPropertyWhenPresent("databaseName", row::getDatabaseName)
            .map(schemaName).toPropertyWhenPresent("schemaName", row::getSchemaName)
            .map(tableName).toPropertyWhenPresent("tableName", row::getTableName)
            .map(partitionKeys).toPropertyWhenPresent("partitionKeys", row::getPartitionKeys)
            .map(businessDate).toPropertyWhenPresent("businessDate", row::getBusinessDate)
            .map(ruleColumn).toPropertyWhenPresent("ruleColumn", row::getRuleColumn)
            .map(ruleName).toPropertyWhenPresent("ruleName", row::getRuleName)
            .map(ruleValue).toPropertyWhenPresent("ruleValue", row::getRuleValue)
            .map(checkLevel).toPropertyWhenPresent("checkLevel", row::getCheckLevel)
            .map(constraintDesc).toPropertyWhenPresent("constraintDesc", row::getConstraintDesc)
            .map(constraintMsg).toPropertyWhenPresent("constraintMsg", row::getConstraintMsg)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(executionTs).toPropertyWhenPresent("executionTs", row::getExecutionTs)
            .map(reserved5).toPropertyWhenPresent("reserved5", row::getReserved5)
            .map(reserved4).toPropertyWhenPresent("reserved4", row::getReserved4)
            .map(reserved3).toPropertyWhenPresent("reserved3", row::getReserved3)
            .map(reserved2).toPropertyWhenPresent("reserved2", row::getReserved2)
            .map(reserved1).toPropertyWhenPresent("reserved1", row::getReserved1)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.614926179Z", comments="Source Table: public.data_controls_log")
    default Optional<DataControlsLog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.614977257Z", comments="Source Table: public.data_controls_log")
    default List<DataControlsLog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.615016994Z", comments="Source Table: public.data_controls_log")
    default List<DataControlsLog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.615054014Z", comments="Source Table: public.data_controls_log")
    default Optional<DataControlsLog> selectByPrimaryKey(Long logId_) {
        return selectOne(c ->
            c.where(logId, isEqualTo(logId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.615148578Z", comments="Source Table: public.data_controls_log")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.615202842Z", comments="Source Table: public.data_controls_log")
    static UpdateDSL<UpdateModel> updateAllColumns(DataControlsLog row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(logId).equalTo(row::getLogId)
                .set(batchId).equalTo(row::getBatchId)
                .set(controlType).equalTo(row::getControlType)
                .set(controlDimension).equalTo(row::getControlDimension)
                .set(processType).equalTo(row::getProcessType)
                .set(databaseName).equalTo(row::getDatabaseName)
                .set(schemaName).equalTo(row::getSchemaName)
                .set(tableName).equalTo(row::getTableName)
                .set(partitionKeys).equalTo(row::getPartitionKeys)
                .set(businessDate).equalTo(row::getBusinessDate)
                .set(ruleColumn).equalTo(row::getRuleColumn)
                .set(ruleName).equalTo(row::getRuleName)
                .set(ruleValue).equalTo(row::getRuleValue)
                .set(checkLevel).equalTo(row::getCheckLevel)
                .set(constraintDesc).equalTo(row::getConstraintDesc)
                .set(constraintMsg).equalTo(row::getConstraintMsg)
                .set(status).equalTo(row::getStatus)
                .set(executionTs).equalTo(row::getExecutionTs)
                .set(reserved5).equalTo(row::getReserved5)
                .set(reserved4).equalTo(row::getReserved4)
                .set(reserved3).equalTo(row::getReserved3)
                .set(reserved2).equalTo(row::getReserved2)
                .set(reserved1).equalTo(row::getReserved1);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.615310808Z", comments="Source Table: public.data_controls_log")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataControlsLog row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(logId).equalToWhenPresent(row::getLogId)
                .set(batchId).equalToWhenPresent(row::getBatchId)
                .set(controlType).equalToWhenPresent(row::getControlType)
                .set(controlDimension).equalToWhenPresent(row::getControlDimension)
                .set(processType).equalToWhenPresent(row::getProcessType)
                .set(databaseName).equalToWhenPresent(row::getDatabaseName)
                .set(schemaName).equalToWhenPresent(row::getSchemaName)
                .set(tableName).equalToWhenPresent(row::getTableName)
                .set(partitionKeys).equalToWhenPresent(row::getPartitionKeys)
                .set(businessDate).equalToWhenPresent(row::getBusinessDate)
                .set(ruleColumn).equalToWhenPresent(row::getRuleColumn)
                .set(ruleName).equalToWhenPresent(row::getRuleName)
                .set(ruleValue).equalToWhenPresent(row::getRuleValue)
                .set(checkLevel).equalToWhenPresent(row::getCheckLevel)
                .set(constraintDesc).equalToWhenPresent(row::getConstraintDesc)
                .set(constraintMsg).equalToWhenPresent(row::getConstraintMsg)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(executionTs).equalToWhenPresent(row::getExecutionTs)
                .set(reserved5).equalToWhenPresent(row::getReserved5)
                .set(reserved4).equalToWhenPresent(row::getReserved4)
                .set(reserved3).equalToWhenPresent(row::getReserved3)
                .set(reserved2).equalToWhenPresent(row::getReserved2)
                .set(reserved1).equalToWhenPresent(row::getReserved1);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.615468071Z", comments="Source Table: public.data_controls_log")
    default int updateByPrimaryKey(DataControlsLog row) {
        return update(c ->
            c.set(batchId).equalTo(row::getBatchId)
            .set(controlType).equalTo(row::getControlType)
            .set(controlDimension).equalTo(row::getControlDimension)
            .set(processType).equalTo(row::getProcessType)
            .set(databaseName).equalTo(row::getDatabaseName)
            .set(schemaName).equalTo(row::getSchemaName)
            .set(tableName).equalTo(row::getTableName)
            .set(partitionKeys).equalTo(row::getPartitionKeys)
            .set(businessDate).equalTo(row::getBusinessDate)
            .set(ruleColumn).equalTo(row::getRuleColumn)
            .set(ruleName).equalTo(row::getRuleName)
            .set(ruleValue).equalTo(row::getRuleValue)
            .set(checkLevel).equalTo(row::getCheckLevel)
            .set(constraintDesc).equalTo(row::getConstraintDesc)
            .set(constraintMsg).equalTo(row::getConstraintMsg)
            .set(status).equalTo(row::getStatus)
            .set(executionTs).equalTo(row::getExecutionTs)
            .set(reserved5).equalTo(row::getReserved5)
            .set(reserved4).equalTo(row::getReserved4)
            .set(reserved3).equalTo(row::getReserved3)
            .set(reserved2).equalTo(row::getReserved2)
            .set(reserved1).equalTo(row::getReserved1)
            .where(logId, isEqualTo(row::getLogId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.615642204Z", comments="Source Table: public.data_controls_log")
    default int updateByPrimaryKeySelective(DataControlsLog row) {
        return update(c ->
            c.set(batchId).equalToWhenPresent(row::getBatchId)
            .set(controlType).equalToWhenPresent(row::getControlType)
            .set(controlDimension).equalToWhenPresent(row::getControlDimension)
            .set(processType).equalToWhenPresent(row::getProcessType)
            .set(databaseName).equalToWhenPresent(row::getDatabaseName)
            .set(schemaName).equalToWhenPresent(row::getSchemaName)
            .set(tableName).equalToWhenPresent(row::getTableName)
            .set(partitionKeys).equalToWhenPresent(row::getPartitionKeys)
            .set(businessDate).equalToWhenPresent(row::getBusinessDate)
            .set(ruleColumn).equalToWhenPresent(row::getRuleColumn)
            .set(ruleName).equalToWhenPresent(row::getRuleName)
            .set(ruleValue).equalToWhenPresent(row::getRuleValue)
            .set(checkLevel).equalToWhenPresent(row::getCheckLevel)
            .set(constraintDesc).equalToWhenPresent(row::getConstraintDesc)
            .set(constraintMsg).equalToWhenPresent(row::getConstraintMsg)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(executionTs).equalToWhenPresent(row::getExecutionTs)
            .set(reserved5).equalToWhenPresent(row::getReserved5)
            .set(reserved4).equalToWhenPresent(row::getReserved4)
            .set(reserved3).equalToWhenPresent(row::getReserved3)
            .set(reserved2).equalToWhenPresent(row::getReserved2)
            .set(reserved1).equalToWhenPresent(row::getReserved1)
            .where(logId, isEqualTo(row::getLogId))
        );
    }
}
package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated.DataManagementProcessesDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataManagementProcesses;

@Mapper
public interface DataManagementProcessesMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataManagementProcesses>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.84459911Z", comments="Source Table: sentinel.data_management_processes")
    BasicColumn[] selectList = BasicColumn.columnList(processId, processName, processShortDesc, processLongDesc, effectiveFrom, expiryDate, createdBy, createdTs, updatedBy, updatedTs);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844177086Z", comments="Source Table: sentinel.data_management_processes")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataManagementProcessesResult", value = {
        @Result(column="process_id", property="processId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="process_name", property="processName", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_short_desc", property="processShortDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_long_desc", property="processLongDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="effective_from", property="effectiveFrom", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expiry_date", property="expiryDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_ts", property="createdTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_ts", property="updatedTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DataManagementProcesses> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844235489Z", comments="Source Table: sentinel.data_management_processes")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataManagementProcessesResult")
    Optional<DataManagementProcesses> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844266691Z", comments="Source Table: sentinel.data_management_processes")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844313194Z", comments="Source Table: sentinel.data_management_processes")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844351496Z", comments="Source Table: sentinel.data_management_processes")
    default int deleteByPrimaryKey(String processId_) {
        return delete(c -> 
            c.where(processId, isEqualTo(processId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844376297Z", comments="Source Table: sentinel.data_management_processes")
    default int insert(DataManagementProcesses row) {
        return MyBatis3Utils.insert(this::insert, row, dataManagementProcesses, c ->
            c.map(processId).toProperty("processId")
            .map(processName).toProperty("processName")
            .map(processShortDesc).toProperty("processShortDesc")
            .map(processLongDesc).toProperty("processLongDesc")
            .map(effectiveFrom).toProperty("effectiveFrom")
            .map(expiryDate).toProperty("expiryDate")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.8444268Z", comments="Source Table: sentinel.data_management_processes")
    default int insertMultiple(Collection<DataManagementProcesses> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataManagementProcesses, c ->
            c.map(processId).toProperty("processId")
            .map(processName).toProperty("processName")
            .map(processShortDesc).toProperty("processShortDesc")
            .map(processLongDesc).toProperty("processLongDesc")
            .map(effectiveFrom).toProperty("effectiveFrom")
            .map(expiryDate).toProperty("expiryDate")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844508605Z", comments="Source Table: sentinel.data_management_processes")
    default int insertSelective(DataManagementProcesses row) {
        return MyBatis3Utils.insert(this::insert, row, dataManagementProcesses, c ->
            c.map(processId).toPropertyWhenPresent("processId", row::getProcessId)
            .map(processName).toPropertyWhenPresent("processName", row::getProcessName)
            .map(processShortDesc).toPropertyWhenPresent("processShortDesc", row::getProcessShortDesc)
            .map(processLongDesc).toPropertyWhenPresent("processLongDesc", row::getProcessLongDesc)
            .map(effectiveFrom).toPropertyWhenPresent("effectiveFrom", row::getEffectiveFrom)
            .map(expiryDate).toPropertyWhenPresent("expiryDate", row::getExpiryDate)
            .map(createdBy).toPropertyWhenPresent("createdBy", row::getCreatedBy)
            .map(createdTs).toPropertyWhenPresent("createdTs", row::getCreatedTs)
            .map(updatedBy).toPropertyWhenPresent("updatedBy", row::getUpdatedBy)
            .map(updatedTs).toPropertyWhenPresent("updatedTs", row::getUpdatedTs)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844631911Z", comments="Source Table: sentinel.data_management_processes")
    default Optional<DataManagementProcesses> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844658713Z", comments="Source Table: sentinel.data_management_processes")
    default List<DataManagementProcesses> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844684514Z", comments="Source Table: sentinel.data_management_processes")
    default List<DataManagementProcesses> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844709416Z", comments="Source Table: sentinel.data_management_processes")
    default Optional<DataManagementProcesses> selectByPrimaryKey(String processId_) {
        return selectOne(c ->
            c.where(processId, isEqualTo(processId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844736417Z", comments="Source Table: sentinel.data_management_processes")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844762119Z", comments="Source Table: sentinel.data_management_processes")
    static UpdateDSL<UpdateModel> updateAllColumns(DataManagementProcesses row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(processId).equalTo(row::getProcessId)
                .set(processName).equalTo(row::getProcessName)
                .set(processShortDesc).equalTo(row::getProcessShortDesc)
                .set(processLongDesc).equalTo(row::getProcessLongDesc)
                .set(effectiveFrom).equalTo(row::getEffectiveFrom)
                .set(expiryDate).equalTo(row::getExpiryDate)
                .set(createdBy).equalTo(row::getCreatedBy)
                .set(createdTs).equalTo(row::getCreatedTs)
                .set(updatedBy).equalTo(row::getUpdatedBy)
                .set(updatedTs).equalTo(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844809721Z", comments="Source Table: sentinel.data_management_processes")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataManagementProcesses row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(processId).equalToWhenPresent(row::getProcessId)
                .set(processName).equalToWhenPresent(row::getProcessName)
                .set(processShortDesc).equalToWhenPresent(row::getProcessShortDesc)
                .set(processLongDesc).equalToWhenPresent(row::getProcessLongDesc)
                .set(effectiveFrom).equalToWhenPresent(row::getEffectiveFrom)
                .set(expiryDate).equalToWhenPresent(row::getExpiryDate)
                .set(createdBy).equalToWhenPresent(row::getCreatedBy)
                .set(createdTs).equalToWhenPresent(row::getCreatedTs)
                .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
                .set(updatedTs).equalToWhenPresent(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844870125Z", comments="Source Table: sentinel.data_management_processes")
    default int updateByPrimaryKey(DataManagementProcesses row) {
        return update(c ->
            c.set(processName).equalTo(row::getProcessName)
            .set(processShortDesc).equalTo(row::getProcessShortDesc)
            .set(processLongDesc).equalTo(row::getProcessLongDesc)
            .set(effectiveFrom).equalTo(row::getEffectiveFrom)
            .set(expiryDate).equalTo(row::getExpiryDate)
            .set(createdBy).equalTo(row::getCreatedBy)
            .set(createdTs).equalTo(row::getCreatedTs)
            .set(updatedBy).equalTo(row::getUpdatedBy)
            .set(updatedTs).equalTo(row::getUpdatedTs)
            .where(processId, isEqualTo(row::getProcessId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.844916727Z", comments="Source Table: sentinel.data_management_processes")
    default int updateByPrimaryKeySelective(DataManagementProcesses row) {
        return update(c ->
            c.set(processName).equalToWhenPresent(row::getProcessName)
            .set(processShortDesc).equalToWhenPresent(row::getProcessShortDesc)
            .set(processLongDesc).equalToWhenPresent(row::getProcessLongDesc)
            .set(effectiveFrom).equalToWhenPresent(row::getEffectiveFrom)
            .set(expiryDate).equalToWhenPresent(row::getExpiryDate)
            .set(createdBy).equalToWhenPresent(row::getCreatedBy)
            .set(createdTs).equalToWhenPresent(row::getCreatedTs)
            .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
            .set(updatedTs).equalToWhenPresent(row::getUpdatedTs)
            .where(processId, isEqualTo(row::getProcessId))
        );
    }
}
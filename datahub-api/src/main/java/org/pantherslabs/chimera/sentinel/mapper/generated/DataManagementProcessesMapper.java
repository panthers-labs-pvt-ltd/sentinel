package org.pantherslabs.chimera.sentinel.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.mapper.generated.DataManagementProcessesDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.model.generated.DataManagementProcesses;

@Mapper
public interface DataManagementProcessesMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataManagementProcesses>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.979915342Z", comments="Source Table: public.data_management_processes")
    BasicColumn[] selectList = BasicColumn.columnList(processId, processName, processShortDesc, processLongDesc, createdBy, createdTs, updatedBy, updatedTs);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.978502239Z", comments="Source Table: public.data_management_processes")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataManagementProcessesResult", value = {
        @Result(column="process_id", property="processId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="process_name", property="processName", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_short_desc", property="processShortDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_long_desc", property="processLongDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_ts", property="createdTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_ts", property="updatedTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DataManagementProcesses> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.978781839Z", comments="Source Table: public.data_management_processes")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataManagementProcessesResult")
    Optional<DataManagementProcesses> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.97888994Z", comments="Source Table: public.data_management_processes")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.97900424Z", comments="Source Table: public.data_management_processes")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.97908644Z", comments="Source Table: public.data_management_processes")
    default int deleteByPrimaryKey(Short processId_) {
        return delete(c -> 
            c.where(processId, isEqualTo(processId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.97916934Z", comments="Source Table: public.data_management_processes")
    default int insert(DataManagementProcesses row) {
        return MyBatis3Utils.insert(this::insert, row, dataManagementProcesses, c ->
            c.map(processId).toProperty("processId")
            .map(processName).toProperty("processName")
            .map(processShortDesc).toProperty("processShortDesc")
            .map(processLongDesc).toProperty("processLongDesc")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.979352441Z", comments="Source Table: public.data_management_processes")
    default int insertMultiple(Collection<DataManagementProcesses> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataManagementProcesses, c ->
            c.map(processId).toProperty("processId")
            .map(processName).toProperty("processName")
            .map(processShortDesc).toProperty("processShortDesc")
            .map(processLongDesc).toProperty("processLongDesc")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.979596041Z", comments="Source Table: public.data_management_processes")
    default int insertSelective(DataManagementProcesses row) {
        return MyBatis3Utils.insert(this::insert, row, dataManagementProcesses, c ->
            c.map(processId).toPropertyWhenPresent("processId", row::getProcessId)
            .map(processName).toPropertyWhenPresent("processName", row::getProcessName)
            .map(processShortDesc).toPropertyWhenPresent("processShortDesc", row::getProcessShortDesc)
            .map(processLongDesc).toPropertyWhenPresent("processLongDesc", row::getProcessLongDesc)
            .map(createdBy).toPropertyWhenPresent("createdBy", row::getCreatedBy)
            .map(createdTs).toPropertyWhenPresent("createdTs", row::getCreatedTs)
            .map(updatedBy).toPropertyWhenPresent("updatedBy", row::getUpdatedBy)
            .map(updatedTs).toPropertyWhenPresent("updatedTs", row::getUpdatedTs)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.980013242Z", comments="Source Table: public.data_management_processes")
    default Optional<DataManagementProcesses> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.980099742Z", comments="Source Table: public.data_management_processes")
    default List<DataManagementProcesses> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.980215543Z", comments="Source Table: public.data_management_processes")
    default List<DataManagementProcesses> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.980310543Z", comments="Source Table: public.data_management_processes")
    default Optional<DataManagementProcesses> selectByPrimaryKey(Short processId_) {
        return selectOne(c ->
            c.where(processId, isEqualTo(processId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.980706344Z", comments="Source Table: public.data_management_processes")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataManagementProcesses, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.980816844Z", comments="Source Table: public.data_management_processes")
    static UpdateDSL<UpdateModel> updateAllColumns(DataManagementProcesses row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(processId).equalTo(row::getProcessId)
                .set(processName).equalTo(row::getProcessName)
                .set(processShortDesc).equalTo(row::getProcessShortDesc)
                .set(processLongDesc).equalTo(row::getProcessLongDesc)
                .set(createdBy).equalTo(row::getCreatedBy)
                .set(createdTs).equalTo(row::getCreatedTs)
                .set(updatedBy).equalTo(row::getUpdatedBy)
                .set(updatedTs).equalTo(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.981003244Z", comments="Source Table: public.data_management_processes")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataManagementProcesses row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(processId).equalToWhenPresent(row::getProcessId)
                .set(processName).equalToWhenPresent(row::getProcessName)
                .set(processShortDesc).equalToWhenPresent(row::getProcessShortDesc)
                .set(processLongDesc).equalToWhenPresent(row::getProcessLongDesc)
                .set(createdBy).equalToWhenPresent(row::getCreatedBy)
                .set(createdTs).equalToWhenPresent(row::getCreatedTs)
                .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
                .set(updatedTs).equalToWhenPresent(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.981176745Z", comments="Source Table: public.data_management_processes")
    default int updateByPrimaryKey(DataManagementProcesses row) {
        return update(c ->
            c.set(processName).equalTo(row::getProcessName)
            .set(processShortDesc).equalTo(row::getProcessShortDesc)
            .set(processLongDesc).equalTo(row::getProcessLongDesc)
            .set(createdBy).equalTo(row::getCreatedBy)
            .set(createdTs).equalTo(row::getCreatedTs)
            .set(updatedBy).equalTo(row::getUpdatedBy)
            .set(updatedTs).equalTo(row::getUpdatedTs)
            .where(processId, isEqualTo(row::getProcessId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.981328445Z", comments="Source Table: public.data_management_processes")
    default int updateByPrimaryKeySelective(DataManagementProcesses row) {
        return update(c ->
            c.set(processName).equalToWhenPresent(row::getProcessName)
            .set(processShortDesc).equalToWhenPresent(row::getProcessShortDesc)
            .set(processLongDesc).equalToWhenPresent(row::getProcessLongDesc)
            .set(createdBy).equalToWhenPresent(row::getCreatedBy)
            .set(createdTs).equalToWhenPresent(row::getCreatedTs)
            .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
            .set(updatedTs).equalToWhenPresent(row::getUpdatedTs)
            .where(processId, isEqualTo(row::getProcessId))
        );
    }
}
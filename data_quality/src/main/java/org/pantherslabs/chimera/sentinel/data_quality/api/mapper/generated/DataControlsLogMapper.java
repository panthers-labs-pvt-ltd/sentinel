package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated.DataControlsLogDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataControlsLog;

@Mapper
public interface DataControlsLogMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataControlsLog>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688442159Z", comments="Source Table: sentinel.data_controls_log")
    BasicColumn[] selectList = BasicColumn.columnList(logId, batchId, processName, controlId, controlName, controlDimId, controlDimName, startTs, endTs, statusDesc, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.68790659Z", comments="Source Table: sentinel.data_controls_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataControlsLogResult", value = {
        @Result(column="log_id", property="logId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="batch_id", property="batchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_name", property="processName", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_id", property="controlId", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_name", property="controlName", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_dim_id", property="controlDimId", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_dim_name", property="controlDimName", jdbcType=JdbcType.VARCHAR),
        @Result(column="start_ts", property="startTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_ts", property="endTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_desc", property="statusDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<DataControlsLog> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688011815Z", comments="Source Table: sentinel.data_controls_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataControlsLogResult")
    Optional<DataControlsLog> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688076711Z", comments="Source Table: sentinel.data_controls_log")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.6881153Z", comments="Source Table: sentinel.data_controls_log")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688162596Z", comments="Source Table: sentinel.data_controls_log")
    default int deleteByPrimaryKey(Long logId_) {
        return delete(c -> 
            c.where(logId, isEqualTo(logId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688193027Z", comments="Source Table: sentinel.data_controls_log")
    default int insert(DataControlsLog row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlsLog, c ->
            c.map(logId).toProperty("logId")
            .map(batchId).toProperty("batchId")
            .map(processName).toProperty("processName")
            .map(controlId).toProperty("controlId")
            .map(controlName).toProperty("controlName")
            .map(controlDimId).toProperty("controlDimId")
            .map(controlDimName).toProperty("controlDimName")
            .map(startTs).toProperty("startTs")
            .map(endTs).toProperty("endTs")
            .map(statusDesc).toProperty("statusDesc")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688259572Z", comments="Source Table: sentinel.data_controls_log")
    default int insertMultiple(Collection<DataControlsLog> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataControlsLog, c ->
            c.map(logId).toProperty("logId")
            .map(batchId).toProperty("batchId")
            .map(processName).toProperty("processName")
            .map(controlId).toProperty("controlId")
            .map(controlName).toProperty("controlName")
            .map(controlDimId).toProperty("controlDimId")
            .map(controlDimName).toProperty("controlDimName")
            .map(startTs).toProperty("startTs")
            .map(endTs).toProperty("endTs")
            .map(statusDesc).toProperty("statusDesc")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.68833015Z", comments="Source Table: sentinel.data_controls_log")
    default int insertSelective(DataControlsLog row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlsLog, c ->
            c.map(logId).toPropertyWhenPresent("logId", row::getLogId)
            .map(batchId).toPropertyWhenPresent("batchId", row::getBatchId)
            .map(processName).toPropertyWhenPresent("processName", row::getProcessName)
            .map(controlId).toPropertyWhenPresent("controlId", row::getControlId)
            .map(controlName).toPropertyWhenPresent("controlName", row::getControlName)
            .map(controlDimId).toPropertyWhenPresent("controlDimId", row::getControlDimId)
            .map(controlDimName).toPropertyWhenPresent("controlDimName", row::getControlDimName)
            .map(startTs).toPropertyWhenPresent("startTs", row::getStartTs)
            .map(endTs).toPropertyWhenPresent("endTs", row::getEndTs)
            .map(statusDesc).toPropertyWhenPresent("statusDesc", row::getStatusDesc)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.68847424Z", comments="Source Table: sentinel.data_controls_log")
    default Optional<DataControlsLog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688504396Z", comments="Source Table: sentinel.data_controls_log")
    default List<DataControlsLog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688534094Z", comments="Source Table: sentinel.data_controls_log")
    default List<DataControlsLog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688562508Z", comments="Source Table: sentinel.data_controls_log")
    default Optional<DataControlsLog> selectByPrimaryKey(Long logId_) {
        return selectOne(c ->
            c.where(logId, isEqualTo(logId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688592756Z", comments="Source Table: sentinel.data_controls_log")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688651052Z", comments="Source Table: sentinel.data_controls_log")
    static UpdateDSL<UpdateModel> updateAllColumns(DataControlsLog row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(logId).equalTo(row::getLogId)
                .set(batchId).equalTo(row::getBatchId)
                .set(processName).equalTo(row::getProcessName)
                .set(controlId).equalTo(row::getControlId)
                .set(controlName).equalTo(row::getControlName)
                .set(controlDimId).equalTo(row::getControlDimId)
                .set(controlDimName).equalTo(row::getControlDimName)
                .set(startTs).equalTo(row::getStartTs)
                .set(endTs).equalTo(row::getEndTs)
                .set(statusDesc).equalTo(row::getStatusDesc)
                .set(status).equalTo(row::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688748395Z", comments="Source Table: sentinel.data_controls_log")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataControlsLog row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(logId).equalToWhenPresent(row::getLogId)
                .set(batchId).equalToWhenPresent(row::getBatchId)
                .set(processName).equalToWhenPresent(row::getProcessName)
                .set(controlId).equalToWhenPresent(row::getControlId)
                .set(controlName).equalToWhenPresent(row::getControlName)
                .set(controlDimId).equalToWhenPresent(row::getControlDimId)
                .set(controlDimName).equalToWhenPresent(row::getControlDimName)
                .set(startTs).equalToWhenPresent(row::getStartTs)
                .set(endTs).equalToWhenPresent(row::getEndTs)
                .set(statusDesc).equalToWhenPresent(row::getStatusDesc)
                .set(status).equalToWhenPresent(row::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688802933Z", comments="Source Table: sentinel.data_controls_log")
    default int updateByPrimaryKey(DataControlsLog row) {
        return update(c ->
            c.set(batchId).equalTo(row::getBatchId)
            .set(processName).equalTo(row::getProcessName)
            .set(controlId).equalTo(row::getControlId)
            .set(controlName).equalTo(row::getControlName)
            .set(controlDimId).equalTo(row::getControlDimId)
            .set(controlDimName).equalTo(row::getControlDimName)
            .set(startTs).equalTo(row::getStartTs)
            .set(endTs).equalTo(row::getEndTs)
            .set(statusDesc).equalTo(row::getStatusDesc)
            .set(status).equalTo(row::getStatus)
            .where(logId, isEqualTo(row::getLogId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.688851146Z", comments="Source Table: sentinel.data_controls_log")
    default int updateByPrimaryKeySelective(DataControlsLog row) {
        return update(c ->
            c.set(batchId).equalToWhenPresent(row::getBatchId)
            .set(processName).equalToWhenPresent(row::getProcessName)
            .set(controlId).equalToWhenPresent(row::getControlId)
            .set(controlName).equalToWhenPresent(row::getControlName)
            .set(controlDimId).equalToWhenPresent(row::getControlDimId)
            .set(controlDimName).equalToWhenPresent(row::getControlDimName)
            .set(startTs).equalToWhenPresent(row::getStartTs)
            .set(endTs).equalToWhenPresent(row::getEndTs)
            .set(statusDesc).equalToWhenPresent(row::getStatusDesc)
            .set(status).equalToWhenPresent(row::getStatus)
            .where(logId, isEqualTo(row::getLogId))
        );
    }
}
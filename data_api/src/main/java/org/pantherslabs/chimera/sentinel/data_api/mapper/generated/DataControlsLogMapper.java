package org.pantherslabs.chimera.sentinel.data_api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.data_api.mapper.generated.DataControlsLogDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.data_api.model.generated.DataControlsLog;

@Mapper
public interface DataControlsLogMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataControlsLog>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408446845Z", comments="Source Table: public.data_controls_log")
    BasicColumn[] selectList = BasicColumn.columnList(dataControlsLogId, batchId, processTypNm, controlId, startTs, endTs, statusDesc, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.40804092Z", comments="Source Table: public.data_controls_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataControlsLogResult", value = {
        @Result(column="data_controls_log_id", property="dataControlsLogId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="batch_id", property="batchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="process_typ_nm", property="processTypNm", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_id", property="controlId", jdbcType=JdbcType.SMALLINT),
        @Result(column="start_ts", property="startTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="end_ts", property="endTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status_desc", property="statusDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<DataControlsLog> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408107455Z", comments="Source Table: public.data_controls_log")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataControlsLogResult")
    Optional<DataControlsLog> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408142674Z", comments="Source Table: public.data_controls_log")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408175624Z", comments="Source Table: public.data_controls_log")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408210207Z", comments="Source Table: public.data_controls_log")
    default int deleteByPrimaryKey(Long dataControlsLogId_) {
        return delete(c -> 
            c.where(dataControlsLogId, isEqualTo(dataControlsLogId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.40824116Z", comments="Source Table: public.data_controls_log")
    default int insert(DataControlsLog row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlsLog, c ->
            c.map(dataControlsLogId).toProperty("dataControlsLogId")
            .map(batchId).toProperty("batchId")
            .map(processTypNm).toProperty("processTypNm")
            .map(controlId).toProperty("controlId")
            .map(startTs).toProperty("startTs")
            .map(endTs).toProperty("endTs")
            .map(statusDesc).toProperty("statusDesc")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408299434Z", comments="Source Table: public.data_controls_log")
    default int insertMultiple(Collection<DataControlsLog> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataControlsLog, c ->
            c.map(dataControlsLogId).toProperty("dataControlsLogId")
            .map(batchId).toProperty("batchId")
            .map(processTypNm).toProperty("processTypNm")
            .map(controlId).toProperty("controlId")
            .map(startTs).toProperty("startTs")
            .map(endTs).toProperty("endTs")
            .map(statusDesc).toProperty("statusDesc")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408359524Z", comments="Source Table: public.data_controls_log")
    default int insertSelective(DataControlsLog row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlsLog, c ->
            c.map(dataControlsLogId).toPropertyWhenPresent("dataControlsLogId", row::getDataControlsLogId)
            .map(batchId).toPropertyWhenPresent("batchId", row::getBatchId)
            .map(processTypNm).toPropertyWhenPresent("processTypNm", row::getProcessTypNm)
            .map(controlId).toPropertyWhenPresent("controlId", row::getControlId)
            .map(startTs).toPropertyWhenPresent("startTs", row::getStartTs)
            .map(endTs).toPropertyWhenPresent("endTs", row::getEndTs)
            .map(statusDesc).toPropertyWhenPresent("statusDesc", row::getStatusDesc)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408483789Z", comments="Source Table: public.data_controls_log")
    default Optional<DataControlsLog> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408514197Z", comments="Source Table: public.data_controls_log")
    default List<DataControlsLog> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408546602Z", comments="Source Table: public.data_controls_log")
    default List<DataControlsLog> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.40857465Z", comments="Source Table: public.data_controls_log")
    default Optional<DataControlsLog> selectByPrimaryKey(Long dataControlsLogId_) {
        return selectOne(c ->
            c.where(dataControlsLogId, isEqualTo(dataControlsLogId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408606238Z", comments="Source Table: public.data_controls_log")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataControlsLog, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408638462Z", comments="Source Table: public.data_controls_log")
    static UpdateDSL<UpdateModel> updateAllColumns(DataControlsLog row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dataControlsLogId).equalTo(row::getDataControlsLogId)
                .set(batchId).equalTo(row::getBatchId)
                .set(processTypNm).equalTo(row::getProcessTypNm)
                .set(controlId).equalTo(row::getControlId)
                .set(startTs).equalTo(row::getStartTs)
                .set(endTs).equalTo(row::getEndTs)
                .set(statusDesc).equalTo(row::getStatusDesc)
                .set(status).equalTo(row::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408692289Z", comments="Source Table: public.data_controls_log")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataControlsLog row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dataControlsLogId).equalToWhenPresent(row::getDataControlsLogId)
                .set(batchId).equalToWhenPresent(row::getBatchId)
                .set(processTypNm).equalToWhenPresent(row::getProcessTypNm)
                .set(controlId).equalToWhenPresent(row::getControlId)
                .set(startTs).equalToWhenPresent(row::getStartTs)
                .set(endTs).equalToWhenPresent(row::getEndTs)
                .set(statusDesc).equalToWhenPresent(row::getStatusDesc)
                .set(status).equalToWhenPresent(row::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408747568Z", comments="Source Table: public.data_controls_log")
    default int updateByPrimaryKey(DataControlsLog row) {
        return update(c ->
            c.set(batchId).equalTo(row::getBatchId)
            .set(processTypNm).equalTo(row::getProcessTypNm)
            .set(controlId).equalTo(row::getControlId)
            .set(startTs).equalTo(row::getStartTs)
            .set(endTs).equalTo(row::getEndTs)
            .set(statusDesc).equalTo(row::getStatusDesc)
            .set(status).equalTo(row::getStatus)
            .where(dataControlsLogId, isEqualTo(row::getDataControlsLogId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.408801304Z", comments="Source Table: public.data_controls_log")
    default int updateByPrimaryKeySelective(DataControlsLog row) {
        return update(c ->
            c.set(batchId).equalToWhenPresent(row::getBatchId)
            .set(processTypNm).equalToWhenPresent(row::getProcessTypNm)
            .set(controlId).equalToWhenPresent(row::getControlId)
            .set(startTs).equalToWhenPresent(row::getStartTs)
            .set(endTs).equalToWhenPresent(row::getEndTs)
            .set(statusDesc).equalToWhenPresent(row::getStatusDesc)
            .set(status).equalToWhenPresent(row::getStatus)
            .where(dataControlsLogId, isEqualTo(row::getDataControlsLogId))
        );
    }
}
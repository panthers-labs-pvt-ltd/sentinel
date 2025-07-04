package org.pantherslabs.chimera.sentinel.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.mapper.generated.DataControlsToProcessMapsDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.model.generated.DataControlsToProcessMaps;

@Mapper
public interface DataControlsToProcessMapsMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataControlsToProcessMaps>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.972370125Z", comments="Source Table: public.data_controls_to_process_maps")
    BasicColumn[] selectList = BasicColumn.columnList(controlId, processId, tbdRefMetadata, tbdCheckLvl, activeFlg, reserved5, reserved4, reserved3, reserved2, reserved1, createdBy, createdTs, updatedBy, updatedTs);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.970739222Z", comments="Source Table: public.data_controls_to_process_maps")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataControlsToProcessMapsResult", value = {
        @Result(column="control_id", property="controlId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="process_id", property="processId", jdbcType=JdbcType.INTEGER),
        @Result(column="tbd_ref_metadata", property="tbdRefMetadata", jdbcType=JdbcType.VARCHAR),
        @Result(column="tbd_check_lvl", property="tbdCheckLvl", jdbcType=JdbcType.VARCHAR),
        @Result(column="active_flg", property="activeFlg", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_5", property="reserved5", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_4", property="reserved4", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_3", property="reserved3", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_2", property="reserved2", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_1", property="reserved1", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_ts", property="createdTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_ts", property="updatedTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DataControlsToProcessMaps> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.971009222Z", comments="Source Table: public.data_controls_to_process_maps")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataControlsToProcessMapsResult")
    Optional<DataControlsToProcessMaps> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.971176423Z", comments="Source Table: public.data_controls_to_process_maps")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataControlsToProcessMaps, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.971276623Z", comments="Source Table: public.data_controls_to_process_maps")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataControlsToProcessMaps, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.971365223Z", comments="Source Table: public.data_controls_to_process_maps")
    default int deleteByPrimaryKey(Integer controlId_) {
        return delete(c -> 
            c.where(controlId, isEqualTo(controlId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.971493223Z", comments="Source Table: public.data_controls_to_process_maps")
    default int insert(DataControlsToProcessMaps row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlsToProcessMaps, c ->
            c.map(controlId).toProperty("controlId")
            .map(processId).toProperty("processId")
            .map(tbdRefMetadata).toProperty("tbdRefMetadata")
            .map(tbdCheckLvl).toProperty("tbdCheckLvl")
            .map(activeFlg).toProperty("activeFlg")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.971783124Z", comments="Source Table: public.data_controls_to_process_maps")
    default int insertMultiple(Collection<DataControlsToProcessMaps> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataControlsToProcessMaps, c ->
            c.map(controlId).toProperty("controlId")
            .map(processId).toProperty("processId")
            .map(tbdRefMetadata).toProperty("tbdRefMetadata")
            .map(tbdCheckLvl).toProperty("tbdCheckLvl")
            .map(activeFlg).toProperty("activeFlg")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.972002724Z", comments="Source Table: public.data_controls_to_process_maps")
    default int insertSelective(DataControlsToProcessMaps row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlsToProcessMaps, c ->
            c.map(controlId).toPropertyWhenPresent("controlId", row::getControlId)
            .map(processId).toPropertyWhenPresent("processId", row::getProcessId)
            .map(tbdRefMetadata).toPropertyWhenPresent("tbdRefMetadata", row::getTbdRefMetadata)
            .map(tbdCheckLvl).toPropertyWhenPresent("tbdCheckLvl", row::getTbdCheckLvl)
            .map(activeFlg).toPropertyWhenPresent("activeFlg", row::getActiveFlg)
            .map(reserved5).toPropertyWhenPresent("reserved5", row::getReserved5)
            .map(reserved4).toPropertyWhenPresent("reserved4", row::getReserved4)
            .map(reserved3).toPropertyWhenPresent("reserved3", row::getReserved3)
            .map(reserved2).toPropertyWhenPresent("reserved2", row::getReserved2)
            .map(reserved1).toPropertyWhenPresent("reserved1", row::getReserved1)
            .map(createdBy).toPropertyWhenPresent("createdBy", row::getCreatedBy)
            .map(createdTs).toPropertyWhenPresent("createdTs", row::getCreatedTs)
            .map(updatedBy).toPropertyWhenPresent("updatedBy", row::getUpdatedBy)
            .map(updatedTs).toPropertyWhenPresent("updatedTs", row::getUpdatedTs)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.972512926Z", comments="Source Table: public.data_controls_to_process_maps")
    default Optional<DataControlsToProcessMaps> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataControlsToProcessMaps, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.972674426Z", comments="Source Table: public.data_controls_to_process_maps")
    default List<DataControlsToProcessMaps> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataControlsToProcessMaps, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.972777126Z", comments="Source Table: public.data_controls_to_process_maps")
    default List<DataControlsToProcessMaps> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataControlsToProcessMaps, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.972930027Z", comments="Source Table: public.data_controls_to_process_maps")
    default Optional<DataControlsToProcessMaps> selectByPrimaryKey(Integer controlId_) {
        return selectOne(c ->
            c.where(controlId, isEqualTo(controlId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.973245327Z", comments="Source Table: public.data_controls_to_process_maps")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataControlsToProcessMaps, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.973336827Z", comments="Source Table: public.data_controls_to_process_maps")
    static UpdateDSL<UpdateModel> updateAllColumns(DataControlsToProcessMaps row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(controlId).equalTo(row::getControlId)
                .set(processId).equalTo(row::getProcessId)
                .set(tbdRefMetadata).equalTo(row::getTbdRefMetadata)
                .set(tbdCheckLvl).equalTo(row::getTbdCheckLvl)
                .set(activeFlg).equalTo(row::getActiveFlg)
                .set(reserved5).equalTo(row::getReserved5)
                .set(reserved4).equalTo(row::getReserved4)
                .set(reserved3).equalTo(row::getReserved3)
                .set(reserved2).equalTo(row::getReserved2)
                .set(reserved1).equalTo(row::getReserved1)
                .set(createdBy).equalTo(row::getCreatedBy)
                .set(createdTs).equalTo(row::getCreatedTs)
                .set(updatedBy).equalTo(row::getUpdatedBy)
                .set(updatedTs).equalTo(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.973550928Z", comments="Source Table: public.data_controls_to_process_maps")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataControlsToProcessMaps row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(controlId).equalToWhenPresent(row::getControlId)
                .set(processId).equalToWhenPresent(row::getProcessId)
                .set(tbdRefMetadata).equalToWhenPresent(row::getTbdRefMetadata)
                .set(tbdCheckLvl).equalToWhenPresent(row::getTbdCheckLvl)
                .set(activeFlg).equalToWhenPresent(row::getActiveFlg)
                .set(reserved5).equalToWhenPresent(row::getReserved5)
                .set(reserved4).equalToWhenPresent(row::getReserved4)
                .set(reserved3).equalToWhenPresent(row::getReserved3)
                .set(reserved2).equalToWhenPresent(row::getReserved2)
                .set(reserved1).equalToWhenPresent(row::getReserved1)
                .set(createdBy).equalToWhenPresent(row::getCreatedBy)
                .set(createdTs).equalToWhenPresent(row::getCreatedTs)
                .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
                .set(updatedTs).equalToWhenPresent(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.973755828Z", comments="Source Table: public.data_controls_to_process_maps")
    default int updateByPrimaryKey(DataControlsToProcessMaps row) {
        return update(c ->
            c.set(processId).equalTo(row::getProcessId)
            .set(tbdRefMetadata).equalTo(row::getTbdRefMetadata)
            .set(tbdCheckLvl).equalTo(row::getTbdCheckLvl)
            .set(activeFlg).equalTo(row::getActiveFlg)
            .set(reserved5).equalTo(row::getReserved5)
            .set(reserved4).equalTo(row::getReserved4)
            .set(reserved3).equalTo(row::getReserved3)
            .set(reserved2).equalTo(row::getReserved2)
            .set(reserved1).equalTo(row::getReserved1)
            .set(createdBy).equalTo(row::getCreatedBy)
            .set(createdTs).equalTo(row::getCreatedTs)
            .set(updatedBy).equalTo(row::getUpdatedBy)
            .set(updatedTs).equalTo(row::getUpdatedTs)
            .where(controlId, isEqualTo(row::getControlId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.973973129Z", comments="Source Table: public.data_controls_to_process_maps")
    default int updateByPrimaryKeySelective(DataControlsToProcessMaps row) {
        return update(c ->
            c.set(processId).equalToWhenPresent(row::getProcessId)
            .set(tbdRefMetadata).equalToWhenPresent(row::getTbdRefMetadata)
            .set(tbdCheckLvl).equalToWhenPresent(row::getTbdCheckLvl)
            .set(activeFlg).equalToWhenPresent(row::getActiveFlg)
            .set(reserved5).equalToWhenPresent(row::getReserved5)
            .set(reserved4).equalToWhenPresent(row::getReserved4)
            .set(reserved3).equalToWhenPresent(row::getReserved3)
            .set(reserved2).equalToWhenPresent(row::getReserved2)
            .set(reserved1).equalToWhenPresent(row::getReserved1)
            .set(createdBy).equalToWhenPresent(row::getCreatedBy)
            .set(createdTs).equalToWhenPresent(row::getCreatedTs)
            .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
            .set(updatedTs).equalToWhenPresent(row::getUpdatedTs)
            .where(controlId, isEqualTo(row::getControlId))
        );
    }
}
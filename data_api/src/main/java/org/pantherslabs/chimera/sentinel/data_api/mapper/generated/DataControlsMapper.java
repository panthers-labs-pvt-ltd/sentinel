package org.pantherslabs.chimera.sentinel.data_api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.data_api.mapper.generated.DataControlsDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.data_api.model.generated.DataControls;

@Mapper
public interface DataControlsMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataControls>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406190838Z", comments="Source Table: public.data_controls")
    BasicColumn[] selectList = BasicColumn.columnList(controlId, controlName, controlShortDesc, controlLongDesc, activeFlg, reserved5, reserved4, reserved3, reserved2, reserved1, createdBy, createdTs, updatedBy, updatedTs);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.405494811Z", comments="Source Table: public.data_controls")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataControlsResult", value = {
        @Result(column="control_id", property="controlId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="control_name", property="controlName", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_short_desc", property="controlShortDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_long_desc", property="controlLongDesc", jdbcType=JdbcType.VARCHAR),
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
    List<DataControls> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.405654748Z", comments="Source Table: public.data_controls")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataControlsResult")
    Optional<DataControls> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.405732085Z", comments="Source Table: public.data_controls")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.405778559Z", comments="Source Table: public.data_controls")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.405834746Z", comments="Source Table: public.data_controls")
    default int deleteByPrimaryKey(Short controlId_) {
        return delete(c -> 
            c.where(controlId, isEqualTo(controlId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.405898648Z", comments="Source Table: public.data_controls")
    default int insert(DataControls row) {
        return MyBatis3Utils.insert(this::insert, row, dataControls, c ->
            c.map(controlId).toProperty("controlId")
            .map(controlName).toProperty("controlName")
            .map(controlShortDesc).toProperty("controlShortDesc")
            .map(controlLongDesc).toProperty("controlLongDesc")
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.405981431Z", comments="Source Table: public.data_controls")
    default int insertMultiple(Collection<DataControls> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataControls, c ->
            c.map(controlId).toProperty("controlId")
            .map(controlName).toProperty("controlName")
            .map(controlShortDesc).toProperty("controlShortDesc")
            .map(controlLongDesc).toProperty("controlLongDesc")
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406054773Z", comments="Source Table: public.data_controls")
    default int insertSelective(DataControls row) {
        return MyBatis3Utils.insert(this::insert, row, dataControls, c ->
            c.map(controlId).toPropertyWhenPresent("controlId", row::getControlId)
            .map(controlName).toPropertyWhenPresent("controlName", row::getControlName)
            .map(controlShortDesc).toPropertyWhenPresent("controlShortDesc", row::getControlShortDesc)
            .map(controlLongDesc).toPropertyWhenPresent("controlLongDesc", row::getControlLongDesc)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406230142Z", comments="Source Table: public.data_controls")
    default Optional<DataControls> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.40626291Z", comments="Source Table: public.data_controls")
    default List<DataControls> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406294589Z", comments="Source Table: public.data_controls")
    default List<DataControls> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406338703Z", comments="Source Table: public.data_controls")
    default Optional<DataControls> selectByPrimaryKey(Short controlId_) {
        return selectOne(c ->
            c.where(controlId, isEqualTo(controlId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.40638545Z", comments="Source Table: public.data_controls")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406418944Z", comments="Source Table: public.data_controls")
    static UpdateDSL<UpdateModel> updateAllColumns(DataControls row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(controlId).equalTo(row::getControlId)
                .set(controlName).equalTo(row::getControlName)
                .set(controlShortDesc).equalTo(row::getControlShortDesc)
                .set(controlLongDesc).equalTo(row::getControlLongDesc)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406513073Z", comments="Source Table: public.data_controls")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataControls row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(controlId).equalToWhenPresent(row::getControlId)
                .set(controlName).equalToWhenPresent(row::getControlName)
                .set(controlShortDesc).equalToWhenPresent(row::getControlShortDesc)
                .set(controlLongDesc).equalToWhenPresent(row::getControlLongDesc)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406599123Z", comments="Source Table: public.data_controls")
    default int updateByPrimaryKey(DataControls row) {
        return update(c ->
            c.set(controlName).equalTo(row::getControlName)
            .set(controlShortDesc).equalTo(row::getControlShortDesc)
            .set(controlLongDesc).equalTo(row::getControlLongDesc)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.406691528Z", comments="Source Table: public.data_controls")
    default int updateByPrimaryKeySelective(DataControls row) {
        return update(c ->
            c.set(controlName).equalToWhenPresent(row::getControlName)
            .set(controlShortDesc).equalToWhenPresent(row::getControlShortDesc)
            .set(controlLongDesc).equalToWhenPresent(row::getControlLongDesc)
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
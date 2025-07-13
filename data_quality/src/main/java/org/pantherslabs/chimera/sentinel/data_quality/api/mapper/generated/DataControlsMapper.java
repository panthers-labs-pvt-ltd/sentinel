package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated.DataControlsDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataControls;

@Mapper
public interface DataControlsMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataControls>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849829603Z", comments="Source Table: sentinel.data_controls")
    BasicColumn[] selectList = BasicColumn.columnList(controlId, controlName, controlShortDesc, controlLongDesc, activeFlg, effectiveFrom, expiryDate, reserved5, reserved4, reserved3, reserved2, reserved1, createdBy, createdTs, updatedBy, updatedTs);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849464983Z", comments="Source Table: sentinel.data_controls")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataControlsResult", value = {
        @Result(column="control_id", property="controlId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="control_name", property="controlName", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_short_desc", property="controlShortDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_long_desc", property="controlLongDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="active_flg", property="activeFlg", jdbcType=JdbcType.VARCHAR),
        @Result(column="effective_from", property="effectiveFrom", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expiry_date", property="expiryDate", jdbcType=JdbcType.TIMESTAMP),
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849527286Z", comments="Source Table: sentinel.data_controls")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataControlsResult")
    Optional<DataControls> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849558388Z", comments="Source Table: sentinel.data_controls")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.84958479Z", comments="Source Table: sentinel.data_controls")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849609091Z", comments="Source Table: sentinel.data_controls")
    default int deleteByPrimaryKey(String controlId_) {
        return delete(c -> 
            c.where(controlId, isEqualTo(controlId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849634592Z", comments="Source Table: sentinel.data_controls")
    default int insert(DataControls row) {
        return MyBatis3Utils.insert(this::insert, row, dataControls, c ->
            c.map(controlId).toProperty("controlId")
            .map(controlName).toProperty("controlName")
            .map(controlShortDesc).toProperty("controlShortDesc")
            .map(controlLongDesc).toProperty("controlLongDesc")
            .map(activeFlg).toProperty("activeFlg")
            .map(effectiveFrom).toProperty("effectiveFrom")
            .map(expiryDate).toProperty("expiryDate")
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849687595Z", comments="Source Table: sentinel.data_controls")
    default int insertMultiple(Collection<DataControls> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataControls, c ->
            c.map(controlId).toProperty("controlId")
            .map(controlName).toProperty("controlName")
            .map(controlShortDesc).toProperty("controlShortDesc")
            .map(controlLongDesc).toProperty("controlLongDesc")
            .map(activeFlg).toProperty("activeFlg")
            .map(effectiveFrom).toProperty("effectiveFrom")
            .map(expiryDate).toProperty("expiryDate")
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849739898Z", comments="Source Table: sentinel.data_controls")
    default int insertSelective(DataControls row) {
        return MyBatis3Utils.insert(this::insert, row, dataControls, c ->
            c.map(controlId).toPropertyWhenPresent("controlId", row::getControlId)
            .map(controlName).toPropertyWhenPresent("controlName", row::getControlName)
            .map(controlShortDesc).toPropertyWhenPresent("controlShortDesc", row::getControlShortDesc)
            .map(controlLongDesc).toPropertyWhenPresent("controlLongDesc", row::getControlLongDesc)
            .map(activeFlg).toPropertyWhenPresent("activeFlg", row::getActiveFlg)
            .map(effectiveFrom).toPropertyWhenPresent("effectiveFrom", row::getEffectiveFrom)
            .map(expiryDate).toPropertyWhenPresent("expiryDate", row::getExpiryDate)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849856105Z", comments="Source Table: sentinel.data_controls")
    default Optional<DataControls> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849882506Z", comments="Source Table: sentinel.data_controls")
    default List<DataControls> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849908108Z", comments="Source Table: sentinel.data_controls")
    default List<DataControls> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849932809Z", comments="Source Table: sentinel.data_controls")
    default Optional<DataControls> selectByPrimaryKey(String controlId_) {
        return selectOne(c ->
            c.where(controlId, isEqualTo(controlId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849960111Z", comments="Source Table: sentinel.data_controls")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataControls, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.849985912Z", comments="Source Table: sentinel.data_controls")
    static UpdateDSL<UpdateModel> updateAllColumns(DataControls row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(controlId).equalTo(row::getControlId)
                .set(controlName).equalTo(row::getControlName)
                .set(controlShortDesc).equalTo(row::getControlShortDesc)
                .set(controlLongDesc).equalTo(row::getControlLongDesc)
                .set(activeFlg).equalTo(row::getActiveFlg)
                .set(effectiveFrom).equalTo(row::getEffectiveFrom)
                .set(expiryDate).equalTo(row::getExpiryDate)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850032415Z", comments="Source Table: sentinel.data_controls")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataControls row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(controlId).equalToWhenPresent(row::getControlId)
                .set(controlName).equalToWhenPresent(row::getControlName)
                .set(controlShortDesc).equalToWhenPresent(row::getControlShortDesc)
                .set(controlLongDesc).equalToWhenPresent(row::getControlLongDesc)
                .set(activeFlg).equalToWhenPresent(row::getActiveFlg)
                .set(effectiveFrom).equalToWhenPresent(row::getEffectiveFrom)
                .set(expiryDate).equalToWhenPresent(row::getExpiryDate)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850103219Z", comments="Source Table: sentinel.data_controls")
    default int updateByPrimaryKey(DataControls row) {
        return update(c ->
            c.set(controlName).equalTo(row::getControlName)
            .set(controlShortDesc).equalTo(row::getControlShortDesc)
            .set(controlLongDesc).equalTo(row::getControlLongDesc)
            .set(activeFlg).equalTo(row::getActiveFlg)
            .set(effectiveFrom).equalTo(row::getEffectiveFrom)
            .set(expiryDate).equalTo(row::getExpiryDate)
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.850151521Z", comments="Source Table: sentinel.data_controls")
    default int updateByPrimaryKeySelective(DataControls row) {
        return update(c ->
            c.set(controlName).equalToWhenPresent(row::getControlName)
            .set(controlShortDesc).equalToWhenPresent(row::getControlShortDesc)
            .set(controlLongDesc).equalToWhenPresent(row::getControlLongDesc)
            .set(activeFlg).equalToWhenPresent(row::getActiveFlg)
            .set(effectiveFrom).equalToWhenPresent(row::getEffectiveFrom)
            .set(expiryDate).equalToWhenPresent(row::getExpiryDate)
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
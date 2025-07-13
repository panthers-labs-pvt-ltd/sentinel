package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated.DataControlProcessMappingDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataControlProcessMapping;

@Mapper
public interface DataControlProcessMappingMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataControlProcessMapping>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847190855Z", comments="Source Table: sentinel.data_control_process_mapping")
    BasicColumn[] selectList = BasicColumn.columnList(mappingId, processId, controlId, checkLvl, effectiveFrom, expiryDate, activeFlg, reserved5, reserved4, reserved3, reserved2, reserved1, createdBy, createdTs, updatedBy, updatedTs, refMetadata);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846690527Z", comments="Source Table: sentinel.data_control_process_mapping")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataControlProcessMappingResult", value = {
        @Result(column="mapping_id", property="mappingId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="process_id", property="processId", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_id", property="controlId", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_lvl", property="checkLvl", jdbcType=JdbcType.VARCHAR),
        @Result(column="effective_from", property="effectiveFrom", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expiry_date", property="expiryDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="active_flg", property="activeFlg", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_5", property="reserved5", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_4", property="reserved4", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_3", property="reserved3", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_2", property="reserved2", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_1", property="reserved1", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_ts", property="createdTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_ts", property="updatedTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="ref_metadata", property="refMetadata", jdbcType=JdbcType.VARCHAR)
    })
    List<DataControlProcessMapping> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846848136Z", comments="Source Table: sentinel.data_control_process_mapping")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataControlProcessMappingResult")
    Optional<DataControlProcessMapping> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846882738Z", comments="Source Table: sentinel.data_control_process_mapping")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataControlProcessMapping, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846929841Z", comments="Source Table: sentinel.data_control_process_mapping")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataControlProcessMapping, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846955042Z", comments="Source Table: sentinel.data_control_process_mapping")
    default int deleteByPrimaryKey(String mappingId_) {
        return delete(c -> 
            c.where(mappingId, isEqualTo(mappingId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846981543Z", comments="Source Table: sentinel.data_control_process_mapping")
    default int insert(DataControlProcessMapping row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlProcessMapping, c ->
            c.map(mappingId).toProperty("mappingId")
            .map(processId).toProperty("processId")
            .map(controlId).toProperty("controlId")
            .map(checkLvl).toProperty("checkLvl")
            .map(effectiveFrom).toProperty("effectiveFrom")
            .map(expiryDate).toProperty("expiryDate")
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
            .map(refMetadata).toProperty("refMetadata")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847038847Z", comments="Source Table: sentinel.data_control_process_mapping")
    default int insertMultiple(Collection<DataControlProcessMapping> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataControlProcessMapping, c ->
            c.map(mappingId).toProperty("mappingId")
            .map(processId).toProperty("processId")
            .map(controlId).toProperty("controlId")
            .map(checkLvl).toProperty("checkLvl")
            .map(effectiveFrom).toProperty("effectiveFrom")
            .map(expiryDate).toProperty("expiryDate")
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
            .map(refMetadata).toProperty("refMetadata")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.84710225Z", comments="Source Table: sentinel.data_control_process_mapping")
    default int insertSelective(DataControlProcessMapping row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlProcessMapping, c ->
            c.map(mappingId).toPropertyWhenPresent("mappingId", row::getMappingId)
            .map(processId).toPropertyWhenPresent("processId", row::getProcessId)
            .map(controlId).toPropertyWhenPresent("controlId", row::getControlId)
            .map(checkLvl).toPropertyWhenPresent("checkLvl", row::getCheckLvl)
            .map(effectiveFrom).toPropertyWhenPresent("effectiveFrom", row::getEffectiveFrom)
            .map(expiryDate).toPropertyWhenPresent("expiryDate", row::getExpiryDate)
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
            .map(refMetadata).toPropertyWhenPresent("refMetadata", row::getRefMetadata)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847217157Z", comments="Source Table: sentinel.data_control_process_mapping")
    default Optional<DataControlProcessMapping> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataControlProcessMapping, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847246558Z", comments="Source Table: sentinel.data_control_process_mapping")
    default List<DataControlProcessMapping> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataControlProcessMapping, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.84727176Z", comments="Source Table: sentinel.data_control_process_mapping")
    default List<DataControlProcessMapping> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataControlProcessMapping, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847316662Z", comments="Source Table: sentinel.data_control_process_mapping")
    default Optional<DataControlProcessMapping> selectByPrimaryKey(String mappingId_) {
        return selectOne(c ->
            c.where(mappingId, isEqualTo(mappingId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847344664Z", comments="Source Table: sentinel.data_control_process_mapping")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataControlProcessMapping, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847410768Z", comments="Source Table: sentinel.data_control_process_mapping")
    static UpdateDSL<UpdateModel> updateAllColumns(DataControlProcessMapping row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(mappingId).equalTo(row::getMappingId)
                .set(processId).equalTo(row::getProcessId)
                .set(controlId).equalTo(row::getControlId)
                .set(checkLvl).equalTo(row::getCheckLvl)
                .set(effectiveFrom).equalTo(row::getEffectiveFrom)
                .set(expiryDate).equalTo(row::getExpiryDate)
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
                .set(refMetadata).equalTo(row::getRefMetadata);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847532674Z", comments="Source Table: sentinel.data_control_process_mapping")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataControlProcessMapping row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(mappingId).equalToWhenPresent(row::getMappingId)
                .set(processId).equalToWhenPresent(row::getProcessId)
                .set(controlId).equalToWhenPresent(row::getControlId)
                .set(checkLvl).equalToWhenPresent(row::getCheckLvl)
                .set(effectiveFrom).equalToWhenPresent(row::getEffectiveFrom)
                .set(expiryDate).equalToWhenPresent(row::getExpiryDate)
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
                .set(refMetadata).equalToWhenPresent(row::getRefMetadata);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847708784Z", comments="Source Table: sentinel.data_control_process_mapping")
    default int updateByPrimaryKey(DataControlProcessMapping row) {
        return update(c ->
            c.set(processId).equalTo(row::getProcessId)
            .set(controlId).equalTo(row::getControlId)
            .set(checkLvl).equalTo(row::getCheckLvl)
            .set(effectiveFrom).equalTo(row::getEffectiveFrom)
            .set(expiryDate).equalTo(row::getExpiryDate)
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
            .set(refMetadata).equalTo(row::getRefMetadata)
            .where(mappingId, isEqualTo(row::getMappingId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.847774788Z", comments="Source Table: sentinel.data_control_process_mapping")
    default int updateByPrimaryKeySelective(DataControlProcessMapping row) {
        return update(c ->
            c.set(processId).equalToWhenPresent(row::getProcessId)
            .set(controlId).equalToWhenPresent(row::getControlId)
            .set(checkLvl).equalToWhenPresent(row::getCheckLvl)
            .set(effectiveFrom).equalToWhenPresent(row::getEffectiveFrom)
            .set(expiryDate).equalToWhenPresent(row::getExpiryDate)
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
            .set(refMetadata).equalToWhenPresent(row::getRefMetadata)
            .where(mappingId, isEqualTo(row::getMappingId))
        );
    }
}
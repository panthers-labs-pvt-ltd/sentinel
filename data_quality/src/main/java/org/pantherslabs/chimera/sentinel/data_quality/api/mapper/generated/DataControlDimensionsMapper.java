package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated.DataControlDimensionsDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataControlDimensions;

@Mapper
public interface DataControlDimensionsMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataControlDimensions>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83391571Z", comments="Source Table: sentinel.data_control_dimensions")
    BasicColumn[] selectList = BasicColumn.columnList(dimensionId, controlId, dimensionName, dimensionShortDesc, dimensionLongDesc, calculatedField, calculationFunction, effectiveFrom, expiryDate, createdBy, createdTs, updatedBy, updatedTs);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833456284Z", comments="Source Table: sentinel.data_control_dimensions")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataControlDimensionsResult", value = {
        @Result(column="dimension_id", property="dimensionId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="control_id", property="controlId", jdbcType=JdbcType.VARCHAR),
        @Result(column="dimension_name", property="dimensionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dimension_short_desc", property="dimensionShortDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="dimension_long_desc", property="dimensionLongDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="calculated_field", property="calculatedField", jdbcType=JdbcType.BIT),
        @Result(column="calculation_function", property="calculationFunction", jdbcType=JdbcType.VARCHAR),
        @Result(column="effective_from", property="effectiveFrom", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expiry_date", property="expiryDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_ts", property="createdTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_ts", property="updatedTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DataControlDimensions> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833547889Z", comments="Source Table: sentinel.data_control_dimensions")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataControlDimensionsResult")
    Optional<DataControlDimensions> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833585491Z", comments="Source Table: sentinel.data_control_dimensions")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataControlDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833618793Z", comments="Source Table: sentinel.data_control_dimensions")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataControlDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833648595Z", comments="Source Table: sentinel.data_control_dimensions")
    default int deleteByPrimaryKey(String dimensionId_) {
        return delete(c -> 
            c.where(dimensionId, isEqualTo(dimensionId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833679096Z", comments="Source Table: sentinel.data_control_dimensions")
    default int insert(DataControlDimensions row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlDimensions, c ->
            c.map(dimensionId).toProperty("dimensionId")
            .map(controlId).toProperty("controlId")
            .map(dimensionName).toProperty("dimensionName")
            .map(dimensionShortDesc).toProperty("dimensionShortDesc")
            .map(dimensionLongDesc).toProperty("dimensionLongDesc")
            .map(calculatedField).toProperty("calculatedField")
            .map(calculationFunction).toProperty("calculationFunction")
            .map(effectiveFrom).toProperty("effectiveFrom")
            .map(expiryDate).toProperty("expiryDate")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.8337463Z", comments="Source Table: sentinel.data_control_dimensions")
    default int insertMultiple(Collection<DataControlDimensions> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataControlDimensions, c ->
            c.map(dimensionId).toProperty("dimensionId")
            .map(controlId).toProperty("controlId")
            .map(dimensionName).toProperty("dimensionName")
            .map(dimensionShortDesc).toProperty("dimensionShortDesc")
            .map(dimensionLongDesc).toProperty("dimensionLongDesc")
            .map(calculatedField).toProperty("calculatedField")
            .map(calculationFunction).toProperty("calculationFunction")
            .map(effectiveFrom).toProperty("effectiveFrom")
            .map(expiryDate).toProperty("expiryDate")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833811504Z", comments="Source Table: sentinel.data_control_dimensions")
    default int insertSelective(DataControlDimensions row) {
        return MyBatis3Utils.insert(this::insert, row, dataControlDimensions, c ->
            c.map(dimensionId).toPropertyWhenPresent("dimensionId", row::getDimensionId)
            .map(controlId).toPropertyWhenPresent("controlId", row::getControlId)
            .map(dimensionName).toPropertyWhenPresent("dimensionName", row::getDimensionName)
            .map(dimensionShortDesc).toPropertyWhenPresent("dimensionShortDesc", row::getDimensionShortDesc)
            .map(dimensionLongDesc).toPropertyWhenPresent("dimensionLongDesc", row::getDimensionLongDesc)
            .map(calculatedField).toPropertyWhenPresent("calculatedField", row::getCalculatedField)
            .map(calculationFunction).toPropertyWhenPresent("calculationFunction", row::getCalculationFunction)
            .map(effectiveFrom).toPropertyWhenPresent("effectiveFrom", row::getEffectiveFrom)
            .map(expiryDate).toPropertyWhenPresent("expiryDate", row::getExpiryDate)
            .map(createdBy).toPropertyWhenPresent("createdBy", row::getCreatedBy)
            .map(createdTs).toPropertyWhenPresent("createdTs", row::getCreatedTs)
            .map(updatedBy).toPropertyWhenPresent("updatedBy", row::getUpdatedBy)
            .map(updatedTs).toPropertyWhenPresent("updatedTs", row::getUpdatedTs)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833948411Z", comments="Source Table: sentinel.data_control_dimensions")
    default Optional<DataControlDimensions> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataControlDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833980113Z", comments="Source Table: sentinel.data_control_dimensions")
    default List<DataControlDimensions> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataControlDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.834011315Z", comments="Source Table: sentinel.data_control_dimensions")
    default List<DataControlDimensions> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataControlDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.834085019Z", comments="Source Table: sentinel.data_control_dimensions")
    default Optional<DataControlDimensions> selectByPrimaryKey(String dimensionId_) {
        return selectOne(c ->
            c.where(dimensionId, isEqualTo(dimensionId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.834394836Z", comments="Source Table: sentinel.data_control_dimensions")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataControlDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83445054Z", comments="Source Table: sentinel.data_control_dimensions")
    static UpdateDSL<UpdateModel> updateAllColumns(DataControlDimensions row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dimensionId).equalTo(row::getDimensionId)
                .set(controlId).equalTo(row::getControlId)
                .set(dimensionName).equalTo(row::getDimensionName)
                .set(dimensionShortDesc).equalTo(row::getDimensionShortDesc)
                .set(dimensionLongDesc).equalTo(row::getDimensionLongDesc)
                .set(calculatedField).equalTo(row::getCalculatedField)
                .set(calculationFunction).equalTo(row::getCalculationFunction)
                .set(effectiveFrom).equalTo(row::getEffectiveFrom)
                .set(expiryDate).equalTo(row::getExpiryDate)
                .set(createdBy).equalTo(row::getCreatedBy)
                .set(createdTs).equalTo(row::getCreatedTs)
                .set(updatedBy).equalTo(row::getUpdatedBy)
                .set(updatedTs).equalTo(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.834562546Z", comments="Source Table: sentinel.data_control_dimensions")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataControlDimensions row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dimensionId).equalToWhenPresent(row::getDimensionId)
                .set(controlId).equalToWhenPresent(row::getControlId)
                .set(dimensionName).equalToWhenPresent(row::getDimensionName)
                .set(dimensionShortDesc).equalToWhenPresent(row::getDimensionShortDesc)
                .set(dimensionLongDesc).equalToWhenPresent(row::getDimensionLongDesc)
                .set(calculatedField).equalToWhenPresent(row::getCalculatedField)
                .set(calculationFunction).equalToWhenPresent(row::getCalculationFunction)
                .set(effectiveFrom).equalToWhenPresent(row::getEffectiveFrom)
                .set(expiryDate).equalToWhenPresent(row::getExpiryDate)
                .set(createdBy).equalToWhenPresent(row::getCreatedBy)
                .set(createdTs).equalToWhenPresent(row::getCreatedTs)
                .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
                .set(updatedTs).equalToWhenPresent(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.834646551Z", comments="Source Table: sentinel.data_control_dimensions")
    default int updateByPrimaryKey(DataControlDimensions row) {
        return update(c ->
            c.set(controlId).equalTo(row::getControlId)
            .set(dimensionName).equalTo(row::getDimensionName)
            .set(dimensionShortDesc).equalTo(row::getDimensionShortDesc)
            .set(dimensionLongDesc).equalTo(row::getDimensionLongDesc)
            .set(calculatedField).equalTo(row::getCalculatedField)
            .set(calculationFunction).equalTo(row::getCalculationFunction)
            .set(effectiveFrom).equalTo(row::getEffectiveFrom)
            .set(expiryDate).equalTo(row::getExpiryDate)
            .set(createdBy).equalTo(row::getCreatedBy)
            .set(createdTs).equalTo(row::getCreatedTs)
            .set(updatedBy).equalTo(row::getUpdatedBy)
            .set(updatedTs).equalTo(row::getUpdatedTs)
            .where(dimensionId, isEqualTo(row::getDimensionId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.834712254Z", comments="Source Table: sentinel.data_control_dimensions")
    default int updateByPrimaryKeySelective(DataControlDimensions row) {
        return update(c ->
            c.set(controlId).equalToWhenPresent(row::getControlId)
            .set(dimensionName).equalToWhenPresent(row::getDimensionName)
            .set(dimensionShortDesc).equalToWhenPresent(row::getDimensionShortDesc)
            .set(dimensionLongDesc).equalToWhenPresent(row::getDimensionLongDesc)
            .set(calculatedField).equalToWhenPresent(row::getCalculatedField)
            .set(calculationFunction).equalToWhenPresent(row::getCalculationFunction)
            .set(effectiveFrom).equalToWhenPresent(row::getEffectiveFrom)
            .set(expiryDate).equalToWhenPresent(row::getExpiryDate)
            .set(createdBy).equalToWhenPresent(row::getCreatedBy)
            .set(createdTs).equalToWhenPresent(row::getCreatedTs)
            .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
            .set(updatedTs).equalToWhenPresent(row::getUpdatedTs)
            .where(dimensionId, isEqualTo(row::getDimensionId))
        );
    }
}
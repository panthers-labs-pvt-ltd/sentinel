package org.pantherslabs.chimera.sentinel.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.mapper.generated.DqDimensionsDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.model.generated.DqDimensions;

@Mapper
public interface DqDimensionsMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DqDimensions>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.998121682Z", comments="Source Table: public.dq_dimensions")
    BasicColumn[] selectList = BasicColumn.columnList(dimensionId, dimensionName, dimensionShortDesc, dimensionLongDesc, calculatedField, calculationFunction, controlId, createdBy, createdTs, updatedBy, updatedTs);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.996946779Z", comments="Source Table: public.dq_dimensions")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DqDimensionsResult", value = {
        @Result(column="dimension_id", property="dimensionId", jdbcType=JdbcType.SMALLINT, id=true),
        @Result(column="dimension_name", property="dimensionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="dimension_short_desc", property="dimensionShortDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="dimension_long_desc", property="dimensionLongDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="calculated_field", property="calculatedField", jdbcType=JdbcType.BIT),
        @Result(column="calculation_function", property="calculationFunction", jdbcType=JdbcType.VARCHAR),
        @Result(column="control_id", property="controlId", jdbcType=JdbcType.SMALLINT),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_ts", property="createdTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_ts", property="updatedTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DqDimensions> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.99712018Z", comments="Source Table: public.dq_dimensions")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DqDimensionsResult")
    Optional<DqDimensions> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.99721698Z", comments="Source Table: public.dq_dimensions")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dqDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.99731748Z", comments="Source Table: public.dq_dimensions")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dqDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.997402581Z", comments="Source Table: public.dq_dimensions")
    default int deleteByPrimaryKey(Short dimensionId_) {
        return delete(c -> 
            c.where(dimensionId, isEqualTo(dimensionId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.997510881Z", comments="Source Table: public.dq_dimensions")
    default int insert(DqDimensions row) {
        return MyBatis3Utils.insert(this::insert, row, dqDimensions, c ->
            c.map(dimensionId).toProperty("dimensionId")
            .map(dimensionName).toProperty("dimensionName")
            .map(dimensionShortDesc).toProperty("dimensionShortDesc")
            .map(dimensionLongDesc).toProperty("dimensionLongDesc")
            .map(calculatedField).toProperty("calculatedField")
            .map(calculationFunction).toProperty("calculationFunction")
            .map(controlId).toProperty("controlId")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.997708881Z", comments="Source Table: public.dq_dimensions")
    default int insertMultiple(Collection<DqDimensions> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dqDimensions, c ->
            c.map(dimensionId).toProperty("dimensionId")
            .map(dimensionName).toProperty("dimensionName")
            .map(dimensionShortDesc).toProperty("dimensionShortDesc")
            .map(dimensionLongDesc).toProperty("dimensionLongDesc")
            .map(calculatedField).toProperty("calculatedField")
            .map(calculationFunction).toProperty("calculationFunction")
            .map(controlId).toProperty("controlId")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.997866382Z", comments="Source Table: public.dq_dimensions")
    default int insertSelective(DqDimensions row) {
        return MyBatis3Utils.insert(this::insert, row, dqDimensions, c ->
            c.map(dimensionId).toPropertyWhenPresent("dimensionId", row::getDimensionId)
            .map(dimensionName).toPropertyWhenPresent("dimensionName", row::getDimensionName)
            .map(dimensionShortDesc).toPropertyWhenPresent("dimensionShortDesc", row::getDimensionShortDesc)
            .map(dimensionLongDesc).toPropertyWhenPresent("dimensionLongDesc", row::getDimensionLongDesc)
            .map(calculatedField).toPropertyWhenPresent("calculatedField", row::getCalculatedField)
            .map(calculationFunction).toPropertyWhenPresent("calculationFunction", row::getCalculationFunction)
            .map(controlId).toPropertyWhenPresent("controlId", row::getControlId)
            .map(createdBy).toPropertyWhenPresent("createdBy", row::getCreatedBy)
            .map(createdTs).toPropertyWhenPresent("createdTs", row::getCreatedTs)
            .map(updatedBy).toPropertyWhenPresent("updatedBy", row::getUpdatedBy)
            .map(updatedTs).toPropertyWhenPresent("updatedTs", row::getUpdatedTs)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.998208882Z", comments="Source Table: public.dq_dimensions")
    default Optional<DqDimensions> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dqDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.998292182Z", comments="Source Table: public.dq_dimensions")
    default List<DqDimensions> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dqDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.998371383Z", comments="Source Table: public.dq_dimensions")
    default List<DqDimensions> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dqDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.998454683Z", comments="Source Table: public.dq_dimensions")
    default Optional<DqDimensions> selectByPrimaryKey(Short dimensionId_) {
        return selectOne(c ->
            c.where(dimensionId, isEqualTo(dimensionId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.998580283Z", comments="Source Table: public.dq_dimensions")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dqDimensions, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.999274085Z", comments="Source Table: public.dq_dimensions")
    static UpdateDSL<UpdateModel> updateAllColumns(DqDimensions row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dimensionId).equalTo(row::getDimensionId)
                .set(dimensionName).equalTo(row::getDimensionName)
                .set(dimensionShortDesc).equalTo(row::getDimensionShortDesc)
                .set(dimensionLongDesc).equalTo(row::getDimensionLongDesc)
                .set(calculatedField).equalTo(row::getCalculatedField)
                .set(calculationFunction).equalTo(row::getCalculationFunction)
                .set(controlId).equalTo(row::getControlId)
                .set(createdBy).equalTo(row::getCreatedBy)
                .set(createdTs).equalTo(row::getCreatedTs)
                .set(updatedBy).equalTo(row::getUpdatedBy)
                .set(updatedTs).equalTo(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.999519185Z", comments="Source Table: public.dq_dimensions")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DqDimensions row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dimensionId).equalToWhenPresent(row::getDimensionId)
                .set(dimensionName).equalToWhenPresent(row::getDimensionName)
                .set(dimensionShortDesc).equalToWhenPresent(row::getDimensionShortDesc)
                .set(dimensionLongDesc).equalToWhenPresent(row::getDimensionLongDesc)
                .set(calculatedField).equalToWhenPresent(row::getCalculatedField)
                .set(calculationFunction).equalToWhenPresent(row::getCalculationFunction)
                .set(controlId).equalToWhenPresent(row::getControlId)
                .set(createdBy).equalToWhenPresent(row::getCreatedBy)
                .set(createdTs).equalToWhenPresent(row::getCreatedTs)
                .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
                .set(updatedTs).equalToWhenPresent(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.999711686Z", comments="Source Table: public.dq_dimensions")
    default int updateByPrimaryKey(DqDimensions row) {
        return update(c ->
            c.set(dimensionName).equalTo(row::getDimensionName)
            .set(dimensionShortDesc).equalTo(row::getDimensionShortDesc)
            .set(dimensionLongDesc).equalTo(row::getDimensionLongDesc)
            .set(calculatedField).equalTo(row::getCalculatedField)
            .set(calculationFunction).equalTo(row::getCalculationFunction)
            .set(controlId).equalTo(row::getControlId)
            .set(createdBy).equalTo(row::getCreatedBy)
            .set(createdTs).equalTo(row::getCreatedTs)
            .set(updatedBy).equalTo(row::getUpdatedBy)
            .set(updatedTs).equalTo(row::getUpdatedTs)
            .where(dimensionId, isEqualTo(row::getDimensionId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.999869386Z", comments="Source Table: public.dq_dimensions")
    default int updateByPrimaryKeySelective(DqDimensions row) {
        return update(c ->
            c.set(dimensionName).equalToWhenPresent(row::getDimensionName)
            .set(dimensionShortDesc).equalToWhenPresent(row::getDimensionShortDesc)
            .set(dimensionLongDesc).equalToWhenPresent(row::getDimensionLongDesc)
            .set(calculatedField).equalToWhenPresent(row::getCalculatedField)
            .set(calculationFunction).equalToWhenPresent(row::getCalculationFunction)
            .set(controlId).equalToWhenPresent(row::getControlId)
            .set(createdBy).equalToWhenPresent(row::getCreatedBy)
            .set(createdTs).equalToWhenPresent(row::getCreatedTs)
            .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
            .set(updatedTs).equalToWhenPresent(row::getUpdatedTs)
            .where(dimensionId, isEqualTo(row::getDimensionId))
        );
    }
}
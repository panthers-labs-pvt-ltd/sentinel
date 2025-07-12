package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated.DataQualityRulesDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataQualityRules;

@Mapper
public interface DataQualityRulesMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataQualityRules>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.685597125Z", comments="Source Table: sentinel.data_quality_rules")
    BasicColumn[] selectList = BasicColumn.columnList(ruleId, dimensionId, ruleName, ruleDesc, ruleExample, ruleOwner, checkLevel, effectiveFrom, expiryDate, reserved5, reserved4, reserved3, reserved2, reserved1, activeFlg, createdBy, createdTs, updatedBy, updatedTs);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.684703716Z", comments="Source Table: sentinel.data_quality_rules")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataQualityRulesResult", value = {
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="dimension_id", property="dimensionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_name", property="ruleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_desc", property="ruleDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_example", property="ruleExample", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_owner", property="ruleOwner", jdbcType=JdbcType.VARCHAR),
        @Result(column="check_level", property="checkLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="effective_from", property="effectiveFrom", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expiry_date", property="expiryDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="reserved_5", property="reserved5", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_4", property="reserved4", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_3", property="reserved3", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_2", property="reserved2", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_1", property="reserved1", jdbcType=JdbcType.VARCHAR),
        @Result(column="active_flg", property="activeFlg", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_ts", property="createdTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="updated_ts", property="updatedTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DataQualityRules> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.684798492Z", comments="Source Table: sentinel.data_quality_rules")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataQualityRulesResult")
    Optional<DataQualityRules> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.684832498Z", comments="Source Table: sentinel.data_quality_rules")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataQualityRules, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.684865496Z", comments="Source Table: sentinel.data_quality_rules")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataQualityRules, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.684894002Z", comments="Source Table: sentinel.data_quality_rules")
    default int deleteByPrimaryKey(String ruleId_) {
        return delete(c -> 
            c.where(ruleId, isEqualTo(ruleId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.684931308Z", comments="Source Table: sentinel.data_quality_rules")
    default int insert(DataQualityRules row) {
        return MyBatis3Utils.insert(this::insert, row, dataQualityRules, c ->
            c.map(ruleId).toProperty("ruleId")
            .map(dimensionId).toProperty("dimensionId")
            .map(ruleName).toProperty("ruleName")
            .map(ruleDesc).toProperty("ruleDesc")
            .map(ruleExample).toProperty("ruleExample")
            .map(ruleOwner).toProperty("ruleOwner")
            .map(checkLevel).toProperty("checkLevel")
            .map(effectiveFrom).toProperty("effectiveFrom")
            .map(expiryDate).toProperty("expiryDate")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
            .map(activeFlg).toProperty("activeFlg")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.68523956Z", comments="Source Table: sentinel.data_quality_rules")
    default int insertMultiple(Collection<DataQualityRules> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataQualityRules, c ->
            c.map(ruleId).toProperty("ruleId")
            .map(dimensionId).toProperty("dimensionId")
            .map(ruleName).toProperty("ruleName")
            .map(ruleDesc).toProperty("ruleDesc")
            .map(ruleExample).toProperty("ruleExample")
            .map(ruleOwner).toProperty("ruleOwner")
            .map(checkLevel).toProperty("checkLevel")
            .map(effectiveFrom).toProperty("effectiveFrom")
            .map(expiryDate).toProperty("expiryDate")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
            .map(activeFlg).toProperty("activeFlg")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedBy).toProperty("updatedBy")
            .map(updatedTs).toProperty("updatedTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.685399873Z", comments="Source Table: sentinel.data_quality_rules")
    default int insertSelective(DataQualityRules row) {
        return MyBatis3Utils.insert(this::insert, row, dataQualityRules, c ->
            c.map(ruleId).toPropertyWhenPresent("ruleId", row::getRuleId)
            .map(dimensionId).toPropertyWhenPresent("dimensionId", row::getDimensionId)
            .map(ruleName).toPropertyWhenPresent("ruleName", row::getRuleName)
            .map(ruleDesc).toPropertyWhenPresent("ruleDesc", row::getRuleDesc)
            .map(ruleExample).toPropertyWhenPresent("ruleExample", row::getRuleExample)
            .map(ruleOwner).toPropertyWhenPresent("ruleOwner", row::getRuleOwner)
            .map(checkLevel).toPropertyWhenPresent("checkLevel", row::getCheckLevel)
            .map(effectiveFrom).toPropertyWhenPresent("effectiveFrom", row::getEffectiveFrom)
            .map(expiryDate).toPropertyWhenPresent("expiryDate", row::getExpiryDate)
            .map(reserved5).toPropertyWhenPresent("reserved5", row::getReserved5)
            .map(reserved4).toPropertyWhenPresent("reserved4", row::getReserved4)
            .map(reserved3).toPropertyWhenPresent("reserved3", row::getReserved3)
            .map(reserved2).toPropertyWhenPresent("reserved2", row::getReserved2)
            .map(reserved1).toPropertyWhenPresent("reserved1", row::getReserved1)
            .map(activeFlg).toPropertyWhenPresent("activeFlg", row::getActiveFlg)
            .map(createdBy).toPropertyWhenPresent("createdBy", row::getCreatedBy)
            .map(createdTs).toPropertyWhenPresent("createdTs", row::getCreatedTs)
            .map(updatedBy).toPropertyWhenPresent("updatedBy", row::getUpdatedBy)
            .map(updatedTs).toPropertyWhenPresent("updatedTs", row::getUpdatedTs)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.685661562Z", comments="Source Table: sentinel.data_quality_rules")
    default Optional<DataQualityRules> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataQualityRules, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.685714634Z", comments="Source Table: sentinel.data_quality_rules")
    default List<DataQualityRules> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataQualityRules, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.685810143Z", comments="Source Table: sentinel.data_quality_rules")
    default List<DataQualityRules> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataQualityRules, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.685865231Z", comments="Source Table: sentinel.data_quality_rules")
    default Optional<DataQualityRules> selectByPrimaryKey(String ruleId_) {
        return selectOne(c ->
            c.where(ruleId, isEqualTo(ruleId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.685931318Z", comments="Source Table: sentinel.data_quality_rules")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataQualityRules, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.685984389Z", comments="Source Table: sentinel.data_quality_rules")
    static UpdateDSL<UpdateModel> updateAllColumns(DataQualityRules row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ruleId).equalTo(row::getRuleId)
                .set(dimensionId).equalTo(row::getDimensionId)
                .set(ruleName).equalTo(row::getRuleName)
                .set(ruleDesc).equalTo(row::getRuleDesc)
                .set(ruleExample).equalTo(row::getRuleExample)
                .set(ruleOwner).equalTo(row::getRuleOwner)
                .set(checkLevel).equalTo(row::getCheckLevel)
                .set(effectiveFrom).equalTo(row::getEffectiveFrom)
                .set(expiryDate).equalTo(row::getExpiryDate)
                .set(reserved5).equalTo(row::getReserved5)
                .set(reserved4).equalTo(row::getReserved4)
                .set(reserved3).equalTo(row::getReserved3)
                .set(reserved2).equalTo(row::getReserved2)
                .set(reserved1).equalTo(row::getReserved1)
                .set(activeFlg).equalTo(row::getActiveFlg)
                .set(createdBy).equalTo(row::getCreatedBy)
                .set(createdTs).equalTo(row::getCreatedTs)
                .set(updatedBy).equalTo(row::getUpdatedBy)
                .set(updatedTs).equalTo(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686075315Z", comments="Source Table: sentinel.data_quality_rules")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataQualityRules row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(ruleId).equalToWhenPresent(row::getRuleId)
                .set(dimensionId).equalToWhenPresent(row::getDimensionId)
                .set(ruleName).equalToWhenPresent(row::getRuleName)
                .set(ruleDesc).equalToWhenPresent(row::getRuleDesc)
                .set(ruleExample).equalToWhenPresent(row::getRuleExample)
                .set(ruleOwner).equalToWhenPresent(row::getRuleOwner)
                .set(checkLevel).equalToWhenPresent(row::getCheckLevel)
                .set(effectiveFrom).equalToWhenPresent(row::getEffectiveFrom)
                .set(expiryDate).equalToWhenPresent(row::getExpiryDate)
                .set(reserved5).equalToWhenPresent(row::getReserved5)
                .set(reserved4).equalToWhenPresent(row::getReserved4)
                .set(reserved3).equalToWhenPresent(row::getReserved3)
                .set(reserved2).equalToWhenPresent(row::getReserved2)
                .set(reserved1).equalToWhenPresent(row::getReserved1)
                .set(activeFlg).equalToWhenPresent(row::getActiveFlg)
                .set(createdBy).equalToWhenPresent(row::getCreatedBy)
                .set(createdTs).equalToWhenPresent(row::getCreatedTs)
                .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
                .set(updatedTs).equalToWhenPresent(row::getUpdatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686187874Z", comments="Source Table: sentinel.data_quality_rules")
    default int updateByPrimaryKey(DataQualityRules row) {
        return update(c ->
            c.set(dimensionId).equalTo(row::getDimensionId)
            .set(ruleName).equalTo(row::getRuleName)
            .set(ruleDesc).equalTo(row::getRuleDesc)
            .set(ruleExample).equalTo(row::getRuleExample)
            .set(ruleOwner).equalTo(row::getRuleOwner)
            .set(checkLevel).equalTo(row::getCheckLevel)
            .set(effectiveFrom).equalTo(row::getEffectiveFrom)
            .set(expiryDate).equalTo(row::getExpiryDate)
            .set(reserved5).equalTo(row::getReserved5)
            .set(reserved4).equalTo(row::getReserved4)
            .set(reserved3).equalTo(row::getReserved3)
            .set(reserved2).equalTo(row::getReserved2)
            .set(reserved1).equalTo(row::getReserved1)
            .set(activeFlg).equalTo(row::getActiveFlg)
            .set(createdBy).equalTo(row::getCreatedBy)
            .set(createdTs).equalTo(row::getCreatedTs)
            .set(updatedBy).equalTo(row::getUpdatedBy)
            .set(updatedTs).equalTo(row::getUpdatedTs)
            .where(ruleId, isEqualTo(row::getRuleId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.686263952Z", comments="Source Table: sentinel.data_quality_rules")
    default int updateByPrimaryKeySelective(DataQualityRules row) {
        return update(c ->
            c.set(dimensionId).equalToWhenPresent(row::getDimensionId)
            .set(ruleName).equalToWhenPresent(row::getRuleName)
            .set(ruleDesc).equalToWhenPresent(row::getRuleDesc)
            .set(ruleExample).equalToWhenPresent(row::getRuleExample)
            .set(ruleOwner).equalToWhenPresent(row::getRuleOwner)
            .set(checkLevel).equalToWhenPresent(row::getCheckLevel)
            .set(effectiveFrom).equalToWhenPresent(row::getEffectiveFrom)
            .set(expiryDate).equalToWhenPresent(row::getExpiryDate)
            .set(reserved5).equalToWhenPresent(row::getReserved5)
            .set(reserved4).equalToWhenPresent(row::getReserved4)
            .set(reserved3).equalToWhenPresent(row::getReserved3)
            .set(reserved2).equalToWhenPresent(row::getReserved2)
            .set(reserved1).equalToWhenPresent(row::getReserved1)
            .set(activeFlg).equalToWhenPresent(row::getActiveFlg)
            .set(createdBy).equalToWhenPresent(row::getCreatedBy)
            .set(createdTs).equalToWhenPresent(row::getCreatedTs)
            .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
            .set(updatedTs).equalToWhenPresent(row::getUpdatedTs)
            .where(ruleId, isEqualTo(row::getRuleId))
        );
    }
}
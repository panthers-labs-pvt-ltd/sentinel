package org.pantherslabs.chimera.sentinel.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.mapper.generated.DqRulesToDataAssetMapDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.model.generated.DqRulesToDataAssetMap;

@Mapper
public interface DqRulesToDataAssetMapMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DqRulesToDataAssetMap>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.019051028Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    BasicColumn[] selectList = BasicColumn.columnList(dqRulesToDataAssetMapId, ruleId, databaseName, schemaName, tableName, partitionKeys, ruleCol, ruleValue, activeFlg, reserved5, reserved4, reserved3, reserved2, reserved1, createdBy, createdTs, updatedTs, updatedBy);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.017566025Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DqRulesToDataAssetMapResult", value = {
        @Result(column="dq_rules_to_data_asset_map_id", property="dqRulesToDataAssetMapId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.INTEGER),
        @Result(column="database_name", property="databaseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="schema_name", property="schemaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="table_name", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="partition_keys", property="partitionKeys", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_col", property="ruleCol", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_value", property="ruleValue", jdbcType=JdbcType.VARCHAR),
        @Result(column="active_flg", property="activeFlg", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_5", property="reserved5", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_4", property="reserved4", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_3", property="reserved3", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_2", property="reserved2", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_1", property="reserved1", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_ts", property="createdTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_ts", property="updatedTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.VARCHAR)
    })
    List<DqRulesToDataAssetMap> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.017881226Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DqRulesToDataAssetMapResult")
    Optional<DqRulesToDataAssetMap> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.018086026Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dqRulesToDataAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.018170026Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dqRulesToDataAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.018263226Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default int deleteByPrimaryKey(Integer dqRulesToDataAssetMapId_) {
        return delete(c -> 
            c.where(dqRulesToDataAssetMapId, isEqualTo(dqRulesToDataAssetMapId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.018344427Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default int insert(DqRulesToDataAssetMap row) {
        return MyBatis3Utils.insert(this::insert, row, dqRulesToDataAssetMap, c ->
            c.map(dqRulesToDataAssetMapId).toProperty("dqRulesToDataAssetMapId")
            .map(ruleId).toProperty("ruleId")
            .map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKeys).toProperty("partitionKeys")
            .map(ruleCol).toProperty("ruleCol")
            .map(ruleValue).toProperty("ruleValue")
            .map(activeFlg).toProperty("activeFlg")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedTs).toProperty("updatedTs")
            .map(updatedBy).toProperty("updatedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.018548427Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default int insertMultiple(Collection<DqRulesToDataAssetMap> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dqRulesToDataAssetMap, c ->
            c.map(dqRulesToDataAssetMapId).toProperty("dqRulesToDataAssetMapId")
            .map(ruleId).toProperty("ruleId")
            .map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKeys).toProperty("partitionKeys")
            .map(ruleCol).toProperty("ruleCol")
            .map(ruleValue).toProperty("ruleValue")
            .map(activeFlg).toProperty("activeFlg")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
            .map(updatedTs).toProperty("updatedTs")
            .map(updatedBy).toProperty("updatedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.018775027Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default int insertSelective(DqRulesToDataAssetMap row) {
        return MyBatis3Utils.insert(this::insert, row, dqRulesToDataAssetMap, c ->
            c.map(dqRulesToDataAssetMapId).toPropertyWhenPresent("dqRulesToDataAssetMapId", row::getDqRulesToDataAssetMapId)
            .map(ruleId).toPropertyWhenPresent("ruleId", row::getRuleId)
            .map(databaseName).toPropertyWhenPresent("databaseName", row::getDatabaseName)
            .map(schemaName).toPropertyWhenPresent("schemaName", row::getSchemaName)
            .map(tableName).toPropertyWhenPresent("tableName", row::getTableName)
            .map(partitionKeys).toPropertyWhenPresent("partitionKeys", row::getPartitionKeys)
            .map(ruleCol).toPropertyWhenPresent("ruleCol", row::getRuleCol)
            .map(ruleValue).toPropertyWhenPresent("ruleValue", row::getRuleValue)
            .map(activeFlg).toPropertyWhenPresent("activeFlg", row::getActiveFlg)
            .map(reserved5).toPropertyWhenPresent("reserved5", row::getReserved5)
            .map(reserved4).toPropertyWhenPresent("reserved4", row::getReserved4)
            .map(reserved3).toPropertyWhenPresent("reserved3", row::getReserved3)
            .map(reserved2).toPropertyWhenPresent("reserved2", row::getReserved2)
            .map(reserved1).toPropertyWhenPresent("reserved1", row::getReserved1)
            .map(createdBy).toPropertyWhenPresent("createdBy", row::getCreatedBy)
            .map(createdTs).toPropertyWhenPresent("createdTs", row::getCreatedTs)
            .map(updatedTs).toPropertyWhenPresent("updatedTs", row::getUpdatedTs)
            .map(updatedBy).toPropertyWhenPresent("updatedBy", row::getUpdatedBy)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.019126828Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default Optional<DqRulesToDataAssetMap> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dqRulesToDataAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.019207528Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default List<DqRulesToDataAssetMap> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dqRulesToDataAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.019270529Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default List<DqRulesToDataAssetMap> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dqRulesToDataAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.019333529Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default Optional<DqRulesToDataAssetMap> selectByPrimaryKey(Integer dqRulesToDataAssetMapId_) {
        return selectOne(c ->
            c.where(dqRulesToDataAssetMapId, isEqualTo(dqRulesToDataAssetMapId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.019421129Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dqRulesToDataAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.019496829Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    static UpdateDSL<UpdateModel> updateAllColumns(DqRulesToDataAssetMap row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dqRulesToDataAssetMapId).equalTo(row::getDqRulesToDataAssetMapId)
                .set(ruleId).equalTo(row::getRuleId)
                .set(databaseName).equalTo(row::getDatabaseName)
                .set(schemaName).equalTo(row::getSchemaName)
                .set(tableName).equalTo(row::getTableName)
                .set(partitionKeys).equalTo(row::getPartitionKeys)
                .set(ruleCol).equalTo(row::getRuleCol)
                .set(ruleValue).equalTo(row::getRuleValue)
                .set(activeFlg).equalTo(row::getActiveFlg)
                .set(reserved5).equalTo(row::getReserved5)
                .set(reserved4).equalTo(row::getReserved4)
                .set(reserved3).equalTo(row::getReserved3)
                .set(reserved2).equalTo(row::getReserved2)
                .set(reserved1).equalTo(row::getReserved1)
                .set(createdBy).equalTo(row::getCreatedBy)
                .set(createdTs).equalTo(row::getCreatedTs)
                .set(updatedTs).equalTo(row::getUpdatedTs)
                .set(updatedBy).equalTo(row::getUpdatedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.019672729Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DqRulesToDataAssetMap row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(dqRulesToDataAssetMapId).equalToWhenPresent(row::getDqRulesToDataAssetMapId)
                .set(ruleId).equalToWhenPresent(row::getRuleId)
                .set(databaseName).equalToWhenPresent(row::getDatabaseName)
                .set(schemaName).equalToWhenPresent(row::getSchemaName)
                .set(tableName).equalToWhenPresent(row::getTableName)
                .set(partitionKeys).equalToWhenPresent(row::getPartitionKeys)
                .set(ruleCol).equalToWhenPresent(row::getRuleCol)
                .set(ruleValue).equalToWhenPresent(row::getRuleValue)
                .set(activeFlg).equalToWhenPresent(row::getActiveFlg)
                .set(reserved5).equalToWhenPresent(row::getReserved5)
                .set(reserved4).equalToWhenPresent(row::getReserved4)
                .set(reserved3).equalToWhenPresent(row::getReserved3)
                .set(reserved2).equalToWhenPresent(row::getReserved2)
                .set(reserved1).equalToWhenPresent(row::getReserved1)
                .set(createdBy).equalToWhenPresent(row::getCreatedBy)
                .set(createdTs).equalToWhenPresent(row::getCreatedTs)
                .set(updatedTs).equalToWhenPresent(row::getUpdatedTs)
                .set(updatedBy).equalToWhenPresent(row::getUpdatedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.01991153Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default int updateByPrimaryKey(DqRulesToDataAssetMap row) {
        return update(c ->
            c.set(ruleId).equalTo(row::getRuleId)
            .set(databaseName).equalTo(row::getDatabaseName)
            .set(schemaName).equalTo(row::getSchemaName)
            .set(tableName).equalTo(row::getTableName)
            .set(partitionKeys).equalTo(row::getPartitionKeys)
            .set(ruleCol).equalTo(row::getRuleCol)
            .set(ruleValue).equalTo(row::getRuleValue)
            .set(activeFlg).equalTo(row::getActiveFlg)
            .set(reserved5).equalTo(row::getReserved5)
            .set(reserved4).equalTo(row::getReserved4)
            .set(reserved3).equalTo(row::getReserved3)
            .set(reserved2).equalTo(row::getReserved2)
            .set(reserved1).equalTo(row::getReserved1)
            .set(createdBy).equalTo(row::getCreatedBy)
            .set(createdTs).equalTo(row::getCreatedTs)
            .set(updatedTs).equalTo(row::getUpdatedTs)
            .set(updatedBy).equalTo(row::getUpdatedBy)
            .where(dqRulesToDataAssetMapId, isEqualTo(row::getDqRulesToDataAssetMapId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:41.02008283Z", comments="Source Table: public.dq_rules_to_data_asset_map")
    default int updateByPrimaryKeySelective(DqRulesToDataAssetMap row) {
        return update(c ->
            c.set(ruleId).equalToWhenPresent(row::getRuleId)
            .set(databaseName).equalToWhenPresent(row::getDatabaseName)
            .set(schemaName).equalToWhenPresent(row::getSchemaName)
            .set(tableName).equalToWhenPresent(row::getTableName)
            .set(partitionKeys).equalToWhenPresent(row::getPartitionKeys)
            .set(ruleCol).equalToWhenPresent(row::getRuleCol)
            .set(ruleValue).equalToWhenPresent(row::getRuleValue)
            .set(activeFlg).equalToWhenPresent(row::getActiveFlg)
            .set(reserved5).equalToWhenPresent(row::getReserved5)
            .set(reserved4).equalToWhenPresent(row::getReserved4)
            .set(reserved3).equalToWhenPresent(row::getReserved3)
            .set(reserved2).equalToWhenPresent(row::getReserved2)
            .set(reserved1).equalToWhenPresent(row::getReserved1)
            .set(createdBy).equalToWhenPresent(row::getCreatedBy)
            .set(createdTs).equalToWhenPresent(row::getCreatedTs)
            .set(updatedTs).equalToWhenPresent(row::getUpdatedTs)
            .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
            .where(dqRulesToDataAssetMapId, isEqualTo(row::getDqRulesToDataAssetMapId))
        );
    }
}
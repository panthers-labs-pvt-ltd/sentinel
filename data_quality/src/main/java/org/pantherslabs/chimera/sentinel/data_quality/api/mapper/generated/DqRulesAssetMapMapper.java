package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated.DqRulesAssetMapDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DqRulesAssetMap;

@Mapper
public interface DqRulesAssetMapMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DqRulesAssetMap>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.674254481Z", comments="Source Table: sentinel.dq_rules_asset_map")
    BasicColumn[] selectList = BasicColumn.columnList(assetMapId, ruleId, databaseName, schemaName, tableName, partitionKeys, ruleColumn, ruleValue, effectiveFrom, expiryDate, activeFlg, reserved5, reserved4, reserved3, reserved2, reserved1, createdBy, createdTs, updatedTs, updatedBy);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.669119048Z", comments="Source Table: sentinel.dq_rules_asset_map")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DqRulesAssetMapResult", value = {
        @Result(column="asset_map_id", property="assetMapId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="rule_id", property="ruleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="database_name", property="databaseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="schema_name", property="schemaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="table_name", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="partition_keys", property="partitionKeys", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_column", property="ruleColumn", jdbcType=JdbcType.VARCHAR),
        @Result(column="rule_value", property="ruleValue", jdbcType=JdbcType.VARCHAR),
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
        @Result(column="updated_ts", property="updatedTs", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updated_by", property="updatedBy", jdbcType=JdbcType.VARCHAR)
    })
    List<DqRulesAssetMap> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.67016168Z", comments="Source Table: sentinel.dq_rules_asset_map")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DqRulesAssetMapResult")
    Optional<DqRulesAssetMap> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.670449401Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dqRulesAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.670727681Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dqRulesAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.671078647Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default int deleteByPrimaryKey(String assetMapId_) {
        return delete(c -> 
            c.where(assetMapId, isEqualTo(assetMapId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.671297805Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default int insert(DqRulesAssetMap row) {
        return MyBatis3Utils.insert(this::insert, row, dqRulesAssetMap, c ->
            c.map(assetMapId).toProperty("assetMapId")
            .map(ruleId).toProperty("ruleId")
            .map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKeys).toProperty("partitionKeys")
            .map(ruleColumn).toProperty("ruleColumn")
            .map(ruleValue).toProperty("ruleValue")
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
            .map(updatedTs).toProperty("updatedTs")
            .map(updatedBy).toProperty("updatedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.672483977Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default int insertMultiple(Collection<DqRulesAssetMap> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dqRulesAssetMap, c ->
            c.map(assetMapId).toProperty("assetMapId")
            .map(ruleId).toProperty("ruleId")
            .map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKeys).toProperty("partitionKeys")
            .map(ruleColumn).toProperty("ruleColumn")
            .map(ruleValue).toProperty("ruleValue")
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
            .map(updatedTs).toProperty("updatedTs")
            .map(updatedBy).toProperty("updatedBy")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.673195992Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default int insertSelective(DqRulesAssetMap row) {
        return MyBatis3Utils.insert(this::insert, row, dqRulesAssetMap, c ->
            c.map(assetMapId).toPropertyWhenPresent("assetMapId", row::getAssetMapId)
            .map(ruleId).toPropertyWhenPresent("ruleId", row::getRuleId)
            .map(databaseName).toPropertyWhenPresent("databaseName", row::getDatabaseName)
            .map(schemaName).toPropertyWhenPresent("schemaName", row::getSchemaName)
            .map(tableName).toPropertyWhenPresent("tableName", row::getTableName)
            .map(partitionKeys).toPropertyWhenPresent("partitionKeys", row::getPartitionKeys)
            .map(ruleColumn).toPropertyWhenPresent("ruleColumn", row::getRuleColumn)
            .map(ruleValue).toPropertyWhenPresent("ruleValue", row::getRuleValue)
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
            .map(updatedTs).toPropertyWhenPresent("updatedTs", row::getUpdatedTs)
            .map(updatedBy).toPropertyWhenPresent("updatedBy", row::getUpdatedBy)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.67485357Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default Optional<DqRulesAssetMap> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dqRulesAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.675180521Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default List<DqRulesAssetMap> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dqRulesAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.675409213Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default List<DqRulesAssetMap> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dqRulesAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.675615356Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default Optional<DqRulesAssetMap> selectByPrimaryKey(String assetMapId_) {
        return selectOne(c ->
            c.where(assetMapId, isEqualTo(assetMapId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.675811508Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dqRulesAssetMap, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.676029292Z", comments="Source Table: sentinel.dq_rules_asset_map")
    static UpdateDSL<UpdateModel> updateAllColumns(DqRulesAssetMap row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(assetMapId).equalTo(row::getAssetMapId)
                .set(ruleId).equalTo(row::getRuleId)
                .set(databaseName).equalTo(row::getDatabaseName)
                .set(schemaName).equalTo(row::getSchemaName)
                .set(tableName).equalTo(row::getTableName)
                .set(partitionKeys).equalTo(row::getPartitionKeys)
                .set(ruleColumn).equalTo(row::getRuleColumn)
                .set(ruleValue).equalTo(row::getRuleValue)
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
                .set(updatedTs).equalTo(row::getUpdatedTs)
                .set(updatedBy).equalTo(row::getUpdatedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.67631518Z", comments="Source Table: sentinel.dq_rules_asset_map")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DqRulesAssetMap row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(assetMapId).equalToWhenPresent(row::getAssetMapId)
                .set(ruleId).equalToWhenPresent(row::getRuleId)
                .set(databaseName).equalToWhenPresent(row::getDatabaseName)
                .set(schemaName).equalToWhenPresent(row::getSchemaName)
                .set(tableName).equalToWhenPresent(row::getTableName)
                .set(partitionKeys).equalToWhenPresent(row::getPartitionKeys)
                .set(ruleColumn).equalToWhenPresent(row::getRuleColumn)
                .set(ruleValue).equalToWhenPresent(row::getRuleValue)
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
                .set(updatedTs).equalToWhenPresent(row::getUpdatedTs)
                .set(updatedBy).equalToWhenPresent(row::getUpdatedBy);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.676806569Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default int updateByPrimaryKey(DqRulesAssetMap row) {
        return update(c ->
            c.set(ruleId).equalTo(row::getRuleId)
            .set(databaseName).equalTo(row::getDatabaseName)
            .set(schemaName).equalTo(row::getSchemaName)
            .set(tableName).equalTo(row::getTableName)
            .set(partitionKeys).equalTo(row::getPartitionKeys)
            .set(ruleColumn).equalTo(row::getRuleColumn)
            .set(ruleValue).equalTo(row::getRuleValue)
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
            .set(updatedTs).equalTo(row::getUpdatedTs)
            .set(updatedBy).equalTo(row::getUpdatedBy)
            .where(assetMapId, isEqualTo(row::getAssetMapId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.677184116Z", comments="Source Table: sentinel.dq_rules_asset_map")
    default int updateByPrimaryKeySelective(DqRulesAssetMap row) {
        return update(c ->
            c.set(ruleId).equalToWhenPresent(row::getRuleId)
            .set(databaseName).equalToWhenPresent(row::getDatabaseName)
            .set(schemaName).equalToWhenPresent(row::getSchemaName)
            .set(tableName).equalToWhenPresent(row::getTableName)
            .set(partitionKeys).equalToWhenPresent(row::getPartitionKeys)
            .set(ruleColumn).equalToWhenPresent(row::getRuleColumn)
            .set(ruleValue).equalToWhenPresent(row::getRuleValue)
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
            .set(updatedTs).equalToWhenPresent(row::getUpdatedTs)
            .set(updatedBy).equalToWhenPresent(row::getUpdatedBy)
            .where(assetMapId, isEqualTo(row::getAssetMapId))
        );
    }
}
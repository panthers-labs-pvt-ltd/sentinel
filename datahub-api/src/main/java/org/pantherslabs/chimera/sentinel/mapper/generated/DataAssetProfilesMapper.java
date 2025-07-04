package org.pantherslabs.chimera.sentinel.mapper.generated;

import static org.pantherslabs.chimera.sentinel.mapper.generated.DataAssetProfilesDynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.model.generated.DataAssetProfiles;

@Mapper
public interface DataAssetProfilesMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<DataAssetProfiles>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.921983514Z", comments="Source Table: public.data_asset_profiles")
    BasicColumn[] selectList = BasicColumn.columnList(databaseName, schemaName, tableName, partitionKey, profileText, batchId, reserved5, reserved4, reserved3, reserved2, reserved1, createdBy, createdTs);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.905358877Z", comments="Source Table: public.data_asset_profiles")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="DataAssetProfilesResult", value = {
        @Result(column="database_name", property="databaseName", jdbcType=JdbcType.VARCHAR),
        @Result(column="schema_name", property="schemaName", jdbcType=JdbcType.VARCHAR),
        @Result(column="table_name", property="tableName", jdbcType=JdbcType.VARCHAR),
        @Result(column="partition_key", property="partitionKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="profile_text", property="profileText", jdbcType=JdbcType.OTHER),
        @Result(column="batch_id", property="batchId", jdbcType=JdbcType.INTEGER),
        @Result(column="reserved_5", property="reserved5", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_4", property="reserved4", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_3", property="reserved3", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_2", property="reserved2", jdbcType=JdbcType.VARCHAR),
        @Result(column="reserved_1", property="reserved1", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_by", property="createdBy", jdbcType=JdbcType.VARCHAR),
        @Result(column="created_ts", property="createdTs", jdbcType=JdbcType.TIMESTAMP)
    })
    List<DataAssetProfiles> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.909909587Z", comments="Source Table: public.data_asset_profiles")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("DataAssetProfilesResult")
    Optional<DataAssetProfiles> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.910659589Z", comments="Source Table: public.data_asset_profiles")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, dataAssetProfiles, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.911442291Z", comments="Source Table: public.data_asset_profiles")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, dataAssetProfiles, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.913017094Z", comments="Source Table: public.data_asset_profiles")
    default int insert(DataAssetProfiles row) {
        return MyBatis3Utils.insert(this::insert, row, dataAssetProfiles, c ->
            c.map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKey).toProperty("partitionKey")
            .map(profileText).toProperty("profileText")
            .map(batchId).toProperty("batchId")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.917273804Z", comments="Source Table: public.data_asset_profiles")
    default int insertMultiple(Collection<DataAssetProfiles> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, dataAssetProfiles, c ->
            c.map(databaseName).toProperty("databaseName")
            .map(schemaName).toProperty("schemaName")
            .map(tableName).toProperty("tableName")
            .map(partitionKey).toProperty("partitionKey")
            .map(profileText).toProperty("profileText")
            .map(batchId).toProperty("batchId")
            .map(reserved5).toProperty("reserved5")
            .map(reserved4).toProperty("reserved4")
            .map(reserved3).toProperty("reserved3")
            .map(reserved2).toProperty("reserved2")
            .map(reserved1).toProperty("reserved1")
            .map(createdBy).toProperty("createdBy")
            .map(createdTs).toProperty("createdTs")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.918778207Z", comments="Source Table: public.data_asset_profiles")
    default int insertSelective(DataAssetProfiles row) {
        return MyBatis3Utils.insert(this::insert, row, dataAssetProfiles, c ->
            c.map(databaseName).toPropertyWhenPresent("databaseName", row::getDatabaseName)
            .map(schemaName).toPropertyWhenPresent("schemaName", row::getSchemaName)
            .map(tableName).toPropertyWhenPresent("tableName", row::getTableName)
            .map(partitionKey).toPropertyWhenPresent("partitionKey", row::getPartitionKey)
            .map(profileText).toPropertyWhenPresent("profileText", row::getProfileText)
            .map(batchId).toPropertyWhenPresent("batchId", row::getBatchId)
            .map(reserved5).toPropertyWhenPresent("reserved5", row::getReserved5)
            .map(reserved4).toPropertyWhenPresent("reserved4", row::getReserved4)
            .map(reserved3).toPropertyWhenPresent("reserved3", row::getReserved3)
            .map(reserved2).toPropertyWhenPresent("reserved2", row::getReserved2)
            .map(reserved1).toPropertyWhenPresent("reserved1", row::getReserved1)
            .map(createdBy).toPropertyWhenPresent("createdBy", row::getCreatedBy)
            .map(createdTs).toPropertyWhenPresent("createdTs", row::getCreatedTs)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.923980819Z", comments="Source Table: public.data_asset_profiles")
    default Optional<DataAssetProfiles> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, dataAssetProfiles, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.924897221Z", comments="Source Table: public.data_asset_profiles")
    default List<DataAssetProfiles> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, dataAssetProfiles, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.925981223Z", comments="Source Table: public.data_asset_profiles")
    default List<DataAssetProfiles> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, dataAssetProfiles, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.927130025Z", comments="Source Table: public.data_asset_profiles")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, dataAssetProfiles, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.927904027Z", comments="Source Table: public.data_asset_profiles")
    static UpdateDSL<UpdateModel> updateAllColumns(DataAssetProfiles row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(databaseName).equalTo(row::getDatabaseName)
                .set(schemaName).equalTo(row::getSchemaName)
                .set(tableName).equalTo(row::getTableName)
                .set(partitionKey).equalTo(row::getPartitionKey)
                .set(profileText).equalTo(row::getProfileText)
                .set(batchId).equalTo(row::getBatchId)
                .set(reserved5).equalTo(row::getReserved5)
                .set(reserved4).equalTo(row::getReserved4)
                .set(reserved3).equalTo(row::getReserved3)
                .set(reserved2).equalTo(row::getReserved2)
                .set(reserved1).equalTo(row::getReserved1)
                .set(createdBy).equalTo(row::getCreatedBy)
                .set(createdTs).equalTo(row::getCreatedTs);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.928771329Z", comments="Source Table: public.data_asset_profiles")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(DataAssetProfiles row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(databaseName).equalToWhenPresent(row::getDatabaseName)
                .set(schemaName).equalToWhenPresent(row::getSchemaName)
                .set(tableName).equalToWhenPresent(row::getTableName)
                .set(partitionKey).equalToWhenPresent(row::getPartitionKey)
                .set(profileText).equalToWhenPresent(row::getProfileText)
                .set(batchId).equalToWhenPresent(row::getBatchId)
                .set(reserved5).equalToWhenPresent(row::getReserved5)
                .set(reserved4).equalToWhenPresent(row::getReserved4)
                .set(reserved3).equalToWhenPresent(row::getReserved3)
                .set(reserved2).equalToWhenPresent(row::getReserved2)
                .set(reserved1).equalToWhenPresent(row::getReserved1)
                .set(createdBy).equalToWhenPresent(row::getCreatedBy)
                .set(createdTs).equalToWhenPresent(row::getCreatedTs);
    }
}
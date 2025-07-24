package org.pantherslabs.chimera.sentinel.datahub.api.mapper.generated;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.pantherslabs.chimera.sentinel.datahub.api.mapper.generated.MetadataAspectV2DynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.datahub.api.model.generated.MetadataAspectV2;

@Mapper
public interface MetadataAspectV2Mapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<MetadataAspectV2>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.967039794Z", comments="Source Table: public.metadata_aspect_v2")
    BasicColumn[] selectList = BasicColumn.columnList(urn, aspect, version, metadata, systemmetadata, createdon, createdby, createdfor);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.955949978Z", comments="Source Table: public.metadata_aspect_v2")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="MetadataAspectV2Result", value = {
        @Result(column="urn", property="urn", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="aspect", property="aspect", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="metadata", property="metadata", jdbcType=JdbcType.VARCHAR),
        @Result(column="systemmetadata", property="systemmetadata", jdbcType=JdbcType.VARCHAR),
        @Result(column="createdon", property="createdon", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createdby", property="createdby", jdbcType=JdbcType.VARCHAR),
        @Result(column="createdfor", property="createdfor", jdbcType=JdbcType.VARCHAR)
    })
    List<MetadataAspectV2> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.957842893Z", comments="Source Table: public.metadata_aspect_v2")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("MetadataAspectV2Result")
    Optional<MetadataAspectV2> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.958492579Z", comments="Source Table: public.metadata_aspect_v2")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, metadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.96288024Z", comments="Source Table: public.metadata_aspect_v2")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, metadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.963439428Z", comments="Source Table: public.metadata_aspect_v2")
    default int deleteByPrimaryKey(String urn_, String aspect_, Long version_) {
        return delete(c -> 
            c.where(urn, isEqualTo(urn_))
            .and(aspect, isEqualTo(aspect_))
            .and(version, isEqualTo(version_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.96379993Z", comments="Source Table: public.metadata_aspect_v2")
    default int insert(MetadataAspectV2 row) {
        return MyBatis3Utils.insert(this::insert, row, metadataAspectV2, c ->
            c.map(urn).toProperty("urn")
            .map(aspect).toProperty("aspect")
            .map(version).toProperty("version")
            .map(metadata).toProperty("metadata")
            .map(systemmetadata).toProperty("systemmetadata")
            .map(createdon).toProperty("createdon")
            .map(createdby).toProperty("createdby")
            .map(createdfor).toProperty("createdfor")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.965579909Z", comments="Source Table: public.metadata_aspect_v2")
    default int insertMultiple(Collection<MetadataAspectV2> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, metadataAspectV2, c ->
            c.map(urn).toProperty("urn")
            .map(aspect).toProperty("aspect")
            .map(version).toProperty("version")
            .map(metadata).toProperty("metadata")
            .map(systemmetadata).toProperty("systemmetadata")
            .map(createdon).toProperty("createdon")
            .map(createdby).toProperty("createdby")
            .map(createdfor).toProperty("createdfor")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.966151945Z", comments="Source Table: public.metadata_aspect_v2")
    default int insertSelective(MetadataAspectV2 row) {
        return MyBatis3Utils.insert(this::insert, row, metadataAspectV2, c ->
            c.map(urn).toPropertyWhenPresent("urn", row::getUrn)
            .map(aspect).toPropertyWhenPresent("aspect", row::getAspect)
            .map(version).toPropertyWhenPresent("version", row::getVersion)
            .map(metadata).toPropertyWhenPresent("metadata", row::getMetadata)
            .map(systemmetadata).toPropertyWhenPresent("systemmetadata", row::getSystemmetadata)
            .map(createdon).toPropertyWhenPresent("createdon", row::getCreatedon)
            .map(createdby).toPropertyWhenPresent("createdby", row::getCreatedby)
            .map(createdfor).toPropertyWhenPresent("createdfor", row::getCreatedfor)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.967706797Z", comments="Source Table: public.metadata_aspect_v2")
    default Optional<MetadataAspectV2> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, metadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.968051099Z", comments="Source Table: public.metadata_aspect_v2")
    default List<MetadataAspectV2> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, metadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.968528913Z", comments="Source Table: public.metadata_aspect_v2")
    default List<MetadataAspectV2> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, metadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.96897442Z", comments="Source Table: public.metadata_aspect_v2")
    default Optional<MetadataAspectV2> selectByPrimaryKey(String urn_, String aspect_, Long version_) {
        return selectOne(c ->
            c.where(urn, isEqualTo(urn_))
            .and(aspect, isEqualTo(aspect_))
            .and(version, isEqualTo(version_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.969312856Z", comments="Source Table: public.metadata_aspect_v2")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, metadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.969784898Z", comments="Source Table: public.metadata_aspect_v2")
    static UpdateDSL<UpdateModel> updateAllColumns(MetadataAspectV2 row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(urn).equalTo(row::getUrn)
                .set(aspect).equalTo(row::getAspect)
                .set(version).equalTo(row::getVersion)
                .set(metadata).equalTo(row::getMetadata)
                .set(systemmetadata).equalTo(row::getSystemmetadata)
                .set(createdon).equalTo(row::getCreatedon)
                .set(createdby).equalTo(row::getCreatedby)
                .set(createdfor).equalTo(row::getCreatedfor);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.970252005Z", comments="Source Table: public.metadata_aspect_v2")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(MetadataAspectV2 row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(urn).equalToWhenPresent(row::getUrn)
                .set(aspect).equalToWhenPresent(row::getAspect)
                .set(version).equalToWhenPresent(row::getVersion)
                .set(metadata).equalToWhenPresent(row::getMetadata)
                .set(systemmetadata).equalToWhenPresent(row::getSystemmetadata)
                .set(createdon).equalToWhenPresent(row::getCreatedon)
                .set(createdby).equalToWhenPresent(row::getCreatedby)
                .set(createdfor).equalToWhenPresent(row::getCreatedfor);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.970916402Z", comments="Source Table: public.metadata_aspect_v2")
    default int updateByPrimaryKey(MetadataAspectV2 row) {
        return update(c ->
            c.set(metadata).equalTo(row::getMetadata)
            .set(systemmetadata).equalTo(row::getSystemmetadata)
            .set(createdon).equalTo(row::getCreatedon)
            .set(createdby).equalTo(row::getCreatedby)
            .set(createdfor).equalTo(row::getCreatedfor)
            .where(urn, isEqualTo(row::getUrn))
            .and(aspect, isEqualTo(row::getAspect))
            .and(version, isEqualTo(row::getVersion))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.971370567Z", comments="Source Table: public.metadata_aspect_v2")
    default int updateByPrimaryKeySelective(MetadataAspectV2 row) {
        return update(c ->
            c.set(metadata).equalToWhenPresent(row::getMetadata)
            .set(systemmetadata).equalToWhenPresent(row::getSystemmetadata)
            .set(createdon).equalToWhenPresent(row::getCreatedon)
            .set(createdby).equalToWhenPresent(row::getCreatedby)
            .set(createdfor).equalToWhenPresent(row::getCreatedfor)
            .where(urn, isEqualTo(row::getUrn))
            .and(aspect, isEqualTo(row::getAspect))
            .and(version, isEqualTo(row::getVersion))
        );
    }
}
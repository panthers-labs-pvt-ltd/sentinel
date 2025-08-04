package org.pantherslabs.chimera.sentinel.datahub.mapper.generated;

import static org.pantherslabs.chimera.sentinel.datahub.mapper.generated.LatestMetadataAspectV2DynamicSqlSupport.*;

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
import org.pantherslabs.chimera.sentinel.datahub.model.generated.LatestMetadataAspectV2;

@Mapper
public interface LatestMetadataAspectV2Mapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<LatestMetadataAspectV2>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.609045216Z", comments="Source Table: public.latest_metadata_aspect_v2")
    BasicColumn[] selectList = BasicColumn.columnList(urn, aspect, version, metadata, systemmetadata, createdon, createdby, createdfor);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608469303Z", comments="Source Table: public.latest_metadata_aspect_v2")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="LatestMetadataAspectV2Result", value = {
        @Result(column="urn", property="urn", jdbcType=JdbcType.VARCHAR),
        @Result(column="aspect", property="aspect", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.BIGINT),
        @Result(column="metadata", property="metadata", jdbcType=JdbcType.VARCHAR),
        @Result(column="systemmetadata", property="systemmetadata", jdbcType=JdbcType.VARCHAR),
        @Result(column="createdon", property="createdon", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="createdby", property="createdby", jdbcType=JdbcType.VARCHAR),
        @Result(column="createdfor", property="createdfor", jdbcType=JdbcType.VARCHAR)
    })
    List<LatestMetadataAspectV2> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608560212Z", comments="Source Table: public.latest_metadata_aspect_v2")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("LatestMetadataAspectV2Result")
    Optional<LatestMetadataAspectV2> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608612039Z", comments="Source Table: public.latest_metadata_aspect_v2")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, latestMetadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608658525Z", comments="Source Table: public.latest_metadata_aspect_v2")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, latestMetadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608703698Z", comments="Source Table: public.latest_metadata_aspect_v2")
    default int insert(LatestMetadataAspectV2 row) {
        return MyBatis3Utils.insert(this::insert, row, latestMetadataAspectV2, c ->
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608793576Z", comments="Source Table: public.latest_metadata_aspect_v2")
    default int insertMultiple(Collection<LatestMetadataAspectV2> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, latestMetadataAspectV2, c ->
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608873707Z", comments="Source Table: public.latest_metadata_aspect_v2")
    default int insertSelective(LatestMetadataAspectV2 row) {
        return MyBatis3Utils.insert(this::insert, row, latestMetadataAspectV2, c ->
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

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.609096293Z", comments="Source Table: public.latest_metadata_aspect_v2")
    default Optional<LatestMetadataAspectV2> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, latestMetadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.609156837Z", comments="Source Table: public.latest_metadata_aspect_v2")
    default List<LatestMetadataAspectV2> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, latestMetadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.609231626Z", comments="Source Table: public.latest_metadata_aspect_v2")
    default List<LatestMetadataAspectV2> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, latestMetadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.609325627Z", comments="Source Table: public.latest_metadata_aspect_v2")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, latestMetadataAspectV2, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.609391325Z", comments="Source Table: public.latest_metadata_aspect_v2")
    static UpdateDSL<UpdateModel> updateAllColumns(LatestMetadataAspectV2 row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(urn).equalTo(row::getUrn)
                .set(aspect).equalTo(row::getAspect)
                .set(version).equalTo(row::getVersion)
                .set(metadata).equalTo(row::getMetadata)
                .set(systemmetadata).equalTo(row::getSystemmetadata)
                .set(createdon).equalTo(row::getCreatedon)
                .set(createdby).equalTo(row::getCreatedby)
                .set(createdfor).equalTo(row::getCreatedfor);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.609523003Z", comments="Source Table: public.latest_metadata_aspect_v2")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(LatestMetadataAspectV2 row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(urn).equalToWhenPresent(row::getUrn)
                .set(aspect).equalToWhenPresent(row::getAspect)
                .set(version).equalToWhenPresent(row::getVersion)
                .set(metadata).equalToWhenPresent(row::getMetadata)
                .set(systemmetadata).equalToWhenPresent(row::getSystemmetadata)
                .set(createdon).equalToWhenPresent(row::getCreatedon)
                .set(createdby).equalToWhenPresent(row::getCreatedby)
                .set(createdfor).equalToWhenPresent(row::getCreatedfor);
    }
}
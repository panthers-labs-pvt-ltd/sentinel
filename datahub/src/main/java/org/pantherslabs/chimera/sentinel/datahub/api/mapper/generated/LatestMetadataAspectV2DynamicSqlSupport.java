package org.pantherslabs.chimera.sentinel.datahub.api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class LatestMetadataAspectV2DynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.975226134Z", comments="Source Table: public.latest_metadata_aspect_v2")
    public static final LatestMetadataAspectV2 latestMetadataAspectV2 = new LatestMetadataAspectV2();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.975371564Z", comments="Source field: public.latest_metadata_aspect_v2.urn")
    public static final SqlColumn<String> urn = latestMetadataAspectV2.urn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.9754872Z", comments="Source field: public.latest_metadata_aspect_v2.aspect")
    public static final SqlColumn<String> aspect = latestMetadataAspectV2.aspect;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.975616243Z", comments="Source field: public.latest_metadata_aspect_v2.version")
    public static final SqlColumn<Long> version = latestMetadataAspectV2.version;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.975668009Z", comments="Source field: public.latest_metadata_aspect_v2.metadata")
    public static final SqlColumn<String> metadata = latestMetadataAspectV2.metadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.975714748Z", comments="Source field: public.latest_metadata_aspect_v2.systemmetadata")
    public static final SqlColumn<String> systemmetadata = latestMetadataAspectV2.systemmetadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.975762325Z", comments="Source field: public.latest_metadata_aspect_v2.createdon")
    public static final SqlColumn<Date> createdon = latestMetadataAspectV2.createdon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.975805805Z", comments="Source field: public.latest_metadata_aspect_v2.createdby")
    public static final SqlColumn<String> createdby = latestMetadataAspectV2.createdby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.975964828Z", comments="Source field: public.latest_metadata_aspect_v2.createdfor")
    public static final SqlColumn<String> createdfor = latestMetadataAspectV2.createdfor;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.975313932Z", comments="Source Table: public.latest_metadata_aspect_v2")
    public static final class LatestMetadataAspectV2 extends AliasableSqlTable<LatestMetadataAspectV2> {
        public final SqlColumn<String> urn = column("urn", JDBCType.VARCHAR);

        public final SqlColumn<String> aspect = column("aspect", JDBCType.VARCHAR);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public final SqlColumn<String> metadata = column("metadata", JDBCType.VARCHAR);

        public final SqlColumn<String> systemmetadata = column("systemmetadata", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdon = column("createdon", JDBCType.TIMESTAMP);

        public final SqlColumn<String> createdby = column("createdby", JDBCType.VARCHAR);

        public final SqlColumn<String> createdfor = column("createdfor", JDBCType.VARCHAR);

        public LatestMetadataAspectV2() {
            super("\"public\".\"latest_metadata_aspect_v2\"", LatestMetadataAspectV2::new);
        }
    }
}
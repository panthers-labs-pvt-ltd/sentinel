package org.pantherslabs.chimera.sentinel.datahub.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class LatestMetadataAspectV2DynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.607942312Z", comments="Source Table: public.latest_metadata_aspect_v2")
    public static final LatestMetadataAspectV2 latestMetadataAspectV2 = new LatestMetadataAspectV2();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608088235Z", comments="Source field: public.latest_metadata_aspect_v2.urn")
    public static final SqlColumn<String> urn = latestMetadataAspectV2.urn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608135658Z", comments="Source field: public.latest_metadata_aspect_v2.aspect")
    public static final SqlColumn<String> aspect = latestMetadataAspectV2.aspect;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608191515Z", comments="Source field: public.latest_metadata_aspect_v2.version")
    public static final SqlColumn<Long> version = latestMetadataAspectV2.version;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.60824681Z", comments="Source field: public.latest_metadata_aspect_v2.metadata")
    public static final SqlColumn<String> metadata = latestMetadataAspectV2.metadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608288328Z", comments="Source field: public.latest_metadata_aspect_v2.systemmetadata")
    public static final SqlColumn<String> systemmetadata = latestMetadataAspectV2.systemmetadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.60833219Z", comments="Source field: public.latest_metadata_aspect_v2.createdon")
    public static final SqlColumn<Date> createdon = latestMetadataAspectV2.createdon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608374364Z", comments="Source field: public.latest_metadata_aspect_v2.createdby")
    public static final SqlColumn<String> createdby = latestMetadataAspectV2.createdby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608416444Z", comments="Source field: public.latest_metadata_aspect_v2.createdfor")
    public static final SqlColumn<String> createdfor = latestMetadataAspectV2.createdfor;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-08-04T14:34:09.608025817Z", comments="Source Table: public.latest_metadata_aspect_v2")
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
package org.pantherslabs.chimera.sentinel.datahub.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class MetadataAspectV2DynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.95410827Z", comments="Source Table: public.metadata_aspect_v2")
    public static final MetadataAspectV2 metadataAspectV2 = new MetadataAspectV2();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.954392798Z", comments="Source field: public.metadata_aspect_v2.urn")
    public static final SqlColumn<String> urn = metadataAspectV2.urn;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.954881413Z", comments="Source field: public.metadata_aspect_v2.aspect")
    public static final SqlColumn<String> aspect = metadataAspectV2.aspect;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.954990997Z", comments="Source field: public.metadata_aspect_v2.version")
    public static final SqlColumn<Long> version = metadataAspectV2.version;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.955062595Z", comments="Source field: public.metadata_aspect_v2.metadata")
    public static final SqlColumn<String> metadata = metadataAspectV2.metadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.955128699Z", comments="Source field: public.metadata_aspect_v2.systemmetadata")
    public static final SqlColumn<String> systemmetadata = metadataAspectV2.systemmetadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.955199273Z", comments="Source field: public.metadata_aspect_v2.createdon")
    public static final SqlColumn<Date> createdon = metadataAspectV2.createdon;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.955297685Z", comments="Source field: public.metadata_aspect_v2.createdby")
    public static final SqlColumn<String> createdby = metadataAspectV2.createdby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.955366303Z", comments="Source field: public.metadata_aspect_v2.createdfor")
    public static final SqlColumn<String> createdfor = metadataAspectV2.createdfor;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-23T14:39:30.954274741Z", comments="Source Table: public.metadata_aspect_v2")
    public static final class MetadataAspectV2 extends AliasableSqlTable<MetadataAspectV2> {
        public final SqlColumn<String> urn = column("urn", JDBCType.VARCHAR);

        public final SqlColumn<String> aspect = column("aspect", JDBCType.VARCHAR);

        public final SqlColumn<Long> version = column("version", JDBCType.BIGINT);

        public final SqlColumn<String> metadata = column("metadata", JDBCType.VARCHAR);

        public final SqlColumn<String> systemmetadata = column("systemmetadata", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdon = column("createdon", JDBCType.TIMESTAMP);

        public final SqlColumn<String> createdby = column("createdby", JDBCType.VARCHAR);

        public final SqlColumn<String> createdfor = column("createdfor", JDBCType.VARCHAR);

        public MetadataAspectV2() {
            super("\"public\".\"metadata_aspect_v2\"", MetadataAspectV2::new);
        }
    }
}
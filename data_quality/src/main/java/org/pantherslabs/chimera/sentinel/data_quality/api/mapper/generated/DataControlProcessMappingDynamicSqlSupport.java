package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataControlProcessMappingDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845925984Z", comments="Source Table: sentinel.data_control_process_mapping")
    public static final DataControlProcessMapping dataControlProcessMapping = new DataControlProcessMapping();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845986688Z", comments="Source field: sentinel.data_control_process_mapping.mapping_id")
    public static final SqlColumn<String> mappingId = dataControlProcessMapping.mappingId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846010089Z", comments="Source field: sentinel.data_control_process_mapping.process_id")
    public static final SqlColumn<String> processId = dataControlProcessMapping.processId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.84603789Z", comments="Source field: sentinel.data_control_process_mapping.control_id")
    public static final SqlColumn<String> controlId = dataControlProcessMapping.controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846059392Z", comments="Source field: sentinel.data_control_process_mapping.check_lvl")
    public static final SqlColumn<String> checkLvl = dataControlProcessMapping.checkLvl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846082093Z", comments="Source field: sentinel.data_control_process_mapping.effective_from")
    public static final SqlColumn<Date> effectiveFrom = dataControlProcessMapping.effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846104394Z", comments="Source field: sentinel.data_control_process_mapping.expiry_date")
    public static final SqlColumn<Date> expiryDate = dataControlProcessMapping.expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846125395Z", comments="Source field: sentinel.data_control_process_mapping.active_flg")
    public static final SqlColumn<String> activeFlg = dataControlProcessMapping.activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846146297Z", comments="Source field: sentinel.data_control_process_mapping.reserved_5")
    public static final SqlColumn<String> reserved5 = dataControlProcessMapping.reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846167098Z", comments="Source field: sentinel.data_control_process_mapping.reserved_4")
    public static final SqlColumn<String> reserved4 = dataControlProcessMapping.reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846187699Z", comments="Source field: sentinel.data_control_process_mapping.reserved_3")
    public static final SqlColumn<String> reserved3 = dataControlProcessMapping.reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.8462079Z", comments="Source field: sentinel.data_control_process_mapping.reserved_2")
    public static final SqlColumn<String> reserved2 = dataControlProcessMapping.reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846228901Z", comments="Source field: sentinel.data_control_process_mapping.reserved_1")
    public static final SqlColumn<String> reserved1 = dataControlProcessMapping.reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846250902Z", comments="Source field: sentinel.data_control_process_mapping.created_by")
    public static final SqlColumn<String> createdBy = dataControlProcessMapping.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846281004Z", comments="Source field: sentinel.data_control_process_mapping.created_ts")
    public static final SqlColumn<Date> createdTs = dataControlProcessMapping.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846352708Z", comments="Source field: sentinel.data_control_process_mapping.updated_by")
    public static final SqlColumn<String> updatedBy = dataControlProcessMapping.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846610123Z", comments="Source field: sentinel.data_control_process_mapping.updated_ts")
    public static final SqlColumn<Date> updatedTs = dataControlProcessMapping.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.846650625Z", comments="Source field: sentinel.data_control_process_mapping.ref_metadata")
    public static final SqlColumn<String> refMetadata = dataControlProcessMapping.refMetadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.845957186Z", comments="Source Table: sentinel.data_control_process_mapping")
    public static final class DataControlProcessMapping extends AliasableSqlTable<DataControlProcessMapping> {
        public final SqlColumn<String> mappingId = column("mapping_id", JDBCType.VARCHAR);

        public final SqlColumn<String> processId = column("process_id", JDBCType.VARCHAR);

        public final SqlColumn<String> controlId = column("control_id", JDBCType.VARCHAR);

        public final SqlColumn<String> checkLvl = column("check_lvl", JDBCType.VARCHAR);

        public final SqlColumn<Date> effectiveFrom = column("effective_from", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> expiryDate = column("expiry_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> activeFlg = column("active_flg", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved5 = column("reserved_5", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved4 = column("reserved_4", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved3 = column("reserved_3", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved2 = column("reserved_2", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved1 = column("reserved_1", JDBCType.VARCHAR);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTs = column("created_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updatedBy = column("updated_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> updatedTs = column("updated_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> refMetadata = column("ref_metadata", JDBCType.VARCHAR);

        public DataControlProcessMapping() {
            super("\"sentinel\".\"data_control_process_mapping\"", DataControlProcessMapping::new);
        }
    }
}
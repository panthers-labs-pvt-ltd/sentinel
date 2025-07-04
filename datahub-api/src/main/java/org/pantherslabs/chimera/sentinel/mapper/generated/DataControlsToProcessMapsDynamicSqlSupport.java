package org.pantherslabs.chimera.sentinel.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataControlsToProcessMapsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.968631117Z", comments="Source Table: public.data_controls_to_process_maps")
    public static final DataControlsToProcessMaps dataControlsToProcessMaps = new DataControlsToProcessMaps();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.968992418Z", comments="Source field: public.data_controls_to_process_maps.control_id")
    public static final SqlColumn<Integer> controlId = dataControlsToProcessMaps.controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.969129418Z", comments="Source field: public.data_controls_to_process_maps.process_id")
    public static final SqlColumn<Integer> processId = dataControlsToProcessMaps.processId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.969244018Z", comments="Source field: public.data_controls_to_process_maps.tbd_ref_metadata")
    public static final SqlColumn<String> tbdRefMetadata = dataControlsToProcessMaps.tbdRefMetadata;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.969425119Z", comments="Source field: public.data_controls_to_process_maps.tbd_check_lvl")
    public static final SqlColumn<String> tbdCheckLvl = dataControlsToProcessMaps.tbdCheckLvl;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.969532319Z", comments="Source field: public.data_controls_to_process_maps.active_flg")
    public static final SqlColumn<String> activeFlg = dataControlsToProcessMaps.activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.969636119Z", comments="Source field: public.data_controls_to_process_maps.reserved_5")
    public static final SqlColumn<String> reserved5 = dataControlsToProcessMaps.reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.96977902Z", comments="Source field: public.data_controls_to_process_maps.reserved_4")
    public static final SqlColumn<String> reserved4 = dataControlsToProcessMaps.reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.96990812Z", comments="Source field: public.data_controls_to_process_maps.reserved_3")
    public static final SqlColumn<String> reserved3 = dataControlsToProcessMaps.reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.97001972Z", comments="Source field: public.data_controls_to_process_maps.reserved_2")
    public static final SqlColumn<String> reserved2 = dataControlsToProcessMaps.reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.97012202Z", comments="Source field: public.data_controls_to_process_maps.reserved_1")
    public static final SqlColumn<String> reserved1 = dataControlsToProcessMaps.reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.970239021Z", comments="Source field: public.data_controls_to_process_maps.created_by")
    public static final SqlColumn<String> createdBy = dataControlsToProcessMaps.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.970353621Z", comments="Source field: public.data_controls_to_process_maps.created_ts")
    public static final SqlColumn<Date> createdTs = dataControlsToProcessMaps.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.970507221Z", comments="Source field: public.data_controls_to_process_maps.updated_by")
    public static final SqlColumn<String> updatedBy = dataControlsToProcessMaps.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.970618621Z", comments="Source field: public.data_controls_to_process_maps.updated_ts")
    public static final SqlColumn<Date> updatedTs = dataControlsToProcessMaps.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-04T17:07:40.968833517Z", comments="Source Table: public.data_controls_to_process_maps")
    public static final class DataControlsToProcessMaps extends AliasableSqlTable<DataControlsToProcessMaps> {
        public final SqlColumn<Integer> controlId = column("control_id", JDBCType.INTEGER);

        public final SqlColumn<Integer> processId = column("process_id", JDBCType.INTEGER);

        public final SqlColumn<String> tbdRefMetadata = column("tbd_ref_metadata", JDBCType.VARCHAR);

        public final SqlColumn<String> tbdCheckLvl = column("tbd_check_lvl", JDBCType.VARCHAR);

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

        public DataControlsToProcessMaps() {
            super("\"public\".\"data_controls_to_process_maps\"", DataControlsToProcessMaps::new);
        }
    }
}
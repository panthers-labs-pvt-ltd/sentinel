package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataControlsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695347178Z", comments="Source Table: sentinel.data_controls")
    public static final DataControls dataControls = new DataControls();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695444705Z", comments="Source field: sentinel.data_controls.control_id")
    public static final SqlColumn<String> controlId = dataControls.controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695492643Z", comments="Source field: sentinel.data_controls.control_name")
    public static final SqlColumn<String> controlName = dataControls.controlName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695520416Z", comments="Source field: sentinel.data_controls.control_short_desc")
    public static final SqlColumn<String> controlShortDesc = dataControls.controlShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695547364Z", comments="Source field: sentinel.data_controls.control_long_desc")
    public static final SqlColumn<String> controlLongDesc = dataControls.controlLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695573762Z", comments="Source field: sentinel.data_controls.active_flg")
    public static final SqlColumn<String> activeFlg = dataControls.activeFlg;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695601352Z", comments="Source field: sentinel.data_controls.effective_from")
    public static final SqlColumn<Date> effectiveFrom = dataControls.effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695628208Z", comments="Source field: sentinel.data_controls.expiry_date")
    public static final SqlColumn<Date> expiryDate = dataControls.expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695653506Z", comments="Source field: sentinel.data_controls.reserved_5")
    public static final SqlColumn<String> reserved5 = dataControls.reserved5;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695679263Z", comments="Source field: sentinel.data_controls.reserved_4")
    public static final SqlColumn<String> reserved4 = dataControls.reserved4;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695704836Z", comments="Source field: sentinel.data_controls.reserved_3")
    public static final SqlColumn<String> reserved3 = dataControls.reserved3;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695730775Z", comments="Source field: sentinel.data_controls.reserved_2")
    public static final SqlColumn<String> reserved2 = dataControls.reserved2;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695757998Z", comments="Source field: sentinel.data_controls.reserved_1")
    public static final SqlColumn<String> reserved1 = dataControls.reserved1;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.69578568Z", comments="Source field: sentinel.data_controls.created_by")
    public static final SqlColumn<String> createdBy = dataControls.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695820969Z", comments="Source field: sentinel.data_controls.created_ts")
    public static final SqlColumn<Date> createdTs = dataControls.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695846267Z", comments="Source field: sentinel.data_controls.updated_by")
    public static final SqlColumn<String> updatedBy = dataControls.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695873582Z", comments="Source field: sentinel.data_controls.updated_ts")
    public static final SqlColumn<Date> updatedTs = dataControls.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-12T12:20:25.695395575Z", comments="Source Table: sentinel.data_controls")
    public static final class DataControls extends AliasableSqlTable<DataControls> {
        public final SqlColumn<String> controlId = column("control_id", JDBCType.VARCHAR);

        public final SqlColumn<String> controlName = column("control_name", JDBCType.VARCHAR);

        public final SqlColumn<String> controlShortDesc = column("control_short_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> controlLongDesc = column("control_long_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> activeFlg = column("active_flg", JDBCType.VARCHAR);

        public final SqlColumn<Date> effectiveFrom = column("effective_from", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> expiryDate = column("expiry_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> reserved5 = column("reserved_5", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved4 = column("reserved_4", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved3 = column("reserved_3", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved2 = column("reserved_2", JDBCType.VARCHAR);

        public final SqlColumn<String> reserved1 = column("reserved_1", JDBCType.VARCHAR);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTs = column("created_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updatedBy = column("updated_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> updatedTs = column("updated_ts", JDBCType.TIMESTAMP);

        public DataControls() {
            super("\"sentinel\".\"data_controls\"", DataControls::new);
        }
    }
}
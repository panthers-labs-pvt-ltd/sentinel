package org.pantherslabs.chimera.sentinel.data_quality.api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DataControlDimensionsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.831808691Z", comments="Source Table: sentinel.data_control_dimensions")
    public static final DataControlDimensions dataControlDimensions = new DataControlDimensions();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.831929698Z", comments="Source field: sentinel.data_control_dimensions.dimension_id")
    public static final SqlColumn<String> dimensionId = dataControlDimensions.dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.8319699Z", comments="Source field: sentinel.data_control_dimensions.control_id")
    public static final SqlColumn<String> controlId = dataControlDimensions.controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.832999158Z", comments="Source field: sentinel.data_control_dimensions.dimension_name")
    public static final SqlColumn<String> dimensionName = dataControlDimensions.dimensionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83304076Z", comments="Source field: sentinel.data_control_dimensions.dimension_short_desc")
    public static final SqlColumn<String> dimensionShortDesc = dataControlDimensions.dimensionShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833135066Z", comments="Source field: sentinel.data_control_dimensions.dimension_long_desc")
    public static final SqlColumn<String> dimensionLongDesc = dataControlDimensions.dimensionLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833188169Z", comments="Source field: sentinel.data_control_dimensions.calculated_field")
    public static final SqlColumn<Boolean> calculatedField = dataControlDimensions.calculatedField;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833221071Z", comments="Source field: sentinel.data_control_dimensions.calculation_function")
    public static final SqlColumn<String> calculationFunction = dataControlDimensions.calculationFunction;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833255072Z", comments="Source field: sentinel.data_control_dimensions.effective_from")
    public static final SqlColumn<Date> effectiveFrom = dataControlDimensions.effectiveFrom;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833288474Z", comments="Source field: sentinel.data_control_dimensions.expiry_date")
    public static final SqlColumn<Date> expiryDate = dataControlDimensions.expiryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833320076Z", comments="Source field: sentinel.data_control_dimensions.created_by")
    public static final SqlColumn<String> createdBy = dataControlDimensions.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833352678Z", comments="Source field: sentinel.data_control_dimensions.created_ts")
    public static final SqlColumn<Date> createdTs = dataControlDimensions.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.83338368Z", comments="Source field: sentinel.data_control_dimensions.updated_by")
    public static final SqlColumn<String> updatedBy = dataControlDimensions.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.833418482Z", comments="Source field: sentinel.data_control_dimensions.updated_ts")
    public static final SqlColumn<Date> updatedTs = dataControlDimensions.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-13T04:34:35.831855494Z", comments="Source Table: sentinel.data_control_dimensions")
    public static final class DataControlDimensions extends AliasableSqlTable<DataControlDimensions> {
        public final SqlColumn<String> dimensionId = column("dimension_id", JDBCType.VARCHAR);

        public final SqlColumn<String> controlId = column("control_id", JDBCType.VARCHAR);

        public final SqlColumn<String> dimensionName = column("dimension_name", JDBCType.VARCHAR);

        public final SqlColumn<String> dimensionShortDesc = column("dimension_short_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> dimensionLongDesc = column("dimension_long_desc", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> calculatedField = column("calculated_field", JDBCType.BIT);

        public final SqlColumn<String> calculationFunction = column("calculation_function", JDBCType.VARCHAR);

        public final SqlColumn<Date> effectiveFrom = column("effective_from", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> expiryDate = column("expiry_date", JDBCType.TIMESTAMP);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTs = column("created_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updatedBy = column("updated_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> updatedTs = column("updated_ts", JDBCType.TIMESTAMP);

        public DataControlDimensions() {
            super("\"sentinel\".\"data_control_dimensions\"", DataControlDimensions::new);
        }
    }
}
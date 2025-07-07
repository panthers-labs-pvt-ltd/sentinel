package org.pantherslabs.chimera.sentinel.data_api.mapper.generated;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class DqDimensionsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41726419Z", comments="Source Table: public.dq_dimensions")
    public static final DqDimensions dqDimensions = new DqDimensions();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417331542Z", comments="Source field: public.dq_dimensions.dimension_id")
    public static final SqlColumn<Short> dimensionId = dqDimensions.dimensionId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417358047Z", comments="Source field: public.dq_dimensions.dimension_name")
    public static final SqlColumn<String> dimensionName = dqDimensions.dimensionName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417382373Z", comments="Source field: public.dq_dimensions.dimension_short_desc")
    public static final SqlColumn<String> dimensionShortDesc = dqDimensions.dimensionShortDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417406155Z", comments="Source field: public.dq_dimensions.dimension_long_desc")
    public static final SqlColumn<String> dimensionLongDesc = dqDimensions.dimensionLongDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417430844Z", comments="Source field: public.dq_dimensions.calculated_field")
    public static final SqlColumn<Boolean> calculatedField = dqDimensions.calculatedField;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417466063Z", comments="Source field: public.dq_dimensions.calculation_function")
    public static final SqlColumn<String> calculationFunction = dqDimensions.calculationFunction;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417514081Z", comments="Source field: public.dq_dimensions.control_id")
    public static final SqlColumn<Short> controlId = dqDimensions.controlId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417539315Z", comments="Source field: public.dq_dimensions.created_by")
    public static final SqlColumn<String> createdBy = dqDimensions.createdBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.41758579Z", comments="Source field: public.dq_dimensions.created_ts")
    public static final SqlColumn<Date> createdTs = dqDimensions.createdTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417610661Z", comments="Source field: public.dq_dimensions.updated_by")
    public static final SqlColumn<String> updatedBy = dqDimensions.updatedBy;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417635713Z", comments="Source field: public.dq_dimensions.updated_ts")
    public static final SqlColumn<Date> updatedTs = dqDimensions.updatedTs;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-07-07T05:59:17.417297594Z", comments="Source Table: public.dq_dimensions")
    public static final class DqDimensions extends AliasableSqlTable<DqDimensions> {
        public final SqlColumn<Short> dimensionId = column("dimension_id", JDBCType.SMALLINT);

        public final SqlColumn<String> dimensionName = column("dimension_name", JDBCType.VARCHAR);

        public final SqlColumn<String> dimensionShortDesc = column("dimension_short_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> dimensionLongDesc = column("dimension_long_desc", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> calculatedField = column("calculated_field", JDBCType.BIT);

        public final SqlColumn<String> calculationFunction = column("calculation_function", JDBCType.VARCHAR);

        public final SqlColumn<Short> controlId = column("control_id", JDBCType.SMALLINT);

        public final SqlColumn<String> createdBy = column("created_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> createdTs = column("created_ts", JDBCType.TIMESTAMP);

        public final SqlColumn<String> updatedBy = column("updated_by", JDBCType.VARCHAR);

        public final SqlColumn<Date> updatedTs = column("updated_ts", JDBCType.TIMESTAMP);

        public DqDimensions() {
            super("\"public\".\"dq_dimensions\"", DqDimensions::new);
        }
    }
}
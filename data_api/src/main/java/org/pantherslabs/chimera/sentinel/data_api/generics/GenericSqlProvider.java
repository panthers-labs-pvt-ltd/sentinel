package org.pantherslabs.chimera.sentinel.data_api.generics;

import java.util.List;
import java.util.Map;


public class GenericSqlProvider {

    public String buildQuery(Map<String, Object> params) {
        String table = (String) params.get("table");
        @SuppressWarnings("unchecked")
        List<FilterCondition> filters = (List<FilterCondition>) params.get("filters");

        StringBuilder sql = new StringBuilder("SELECT * FROM ").append(table).append(" WHERE 1=1 ");

        int index = 0;
        for (FilterCondition filter : filters) {
            String paramName = "filters[" + index + "].value";

            sql.append(" AND ").append(filter.getField()).append(" ");

            switch (filter.getOperator().toLowerCase()) {
                case "in":
                    sql.append("IN (")
                            .append("#{").append(paramName).append("}")
                            .append(")");
                    break;
                case "like":
                    sql.append("LIKE CONCAT('%', #{").append(paramName).append("}, '%')");
                    break;
                default:
                    sql.append(filter.getOperator()).append(" #{").append(paramName).append("}");
            }
            index++;
        }
        return sql.toString();
    }
}

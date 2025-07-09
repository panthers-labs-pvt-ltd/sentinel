package org.pantherslabs.chimera.sentinel.data_api.generics;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

@Mapper
public interface GenericMapper {

    @SelectProvider(type = GenericSqlProvider.class, method = "buildQuery")
    List<Map<String, Object>> executeDynamicFilterQuery(
            @Param("table") String table,
            @Param("filters") List<FilterCondition> filters
    );
}
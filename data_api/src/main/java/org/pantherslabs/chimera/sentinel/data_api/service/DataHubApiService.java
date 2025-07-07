package org.pantherslabs.chimera.sentinel.data_api.service;

import org.pantherslabs.chimera.sentinel.data_api.mapper.generated.DqRulesToDataAssetMapDynamicSqlSupport;
import org.pantherslabs.chimera.sentinel.data_api.mapper.generated.DqRulesToDataAssetMapMapper;
import org.pantherslabs.chimera.sentinel.data_api.model.generated.DqRulesToDataAssetMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class DataHubApiService {
    @Autowired
    private DqRulesToDataAssetMapMapper dataAssetMapMapper;

    public DqRulesToDataAssetMap getDataAssetMap(String tableName) {
        return dataAssetMapMapper.selectOne(c ->
                c.where(DqRulesToDataAssetMapDynamicSqlSupport.tableName, isEqualTo(tableName))
        ).orElse(null); // or throw an exception if not found
    }
}

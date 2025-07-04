package org.pantherslabs.chimera.sentinel.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.pantherslabs.chimera.sentinel.datahub.pipeline.ManagePipeline;
import org.pantherslabs.chimera.sentinel.dto.DataAssetMap;
import org.pantherslabs.chimera.sentinel.dto.DataPipeline;
import org.pantherslabs.chimera.sentinel.model.generated.DqRulesToDataAssetMap;
import org.pantherslabs.chimera.sentinel.service.DataHubApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/datahub/api")
public class DataHubApiController {

    @Autowired
    private ObjectMapper yamlObjectMapper;

    @Autowired
    private DataHubApiService dataHubApiService;

    @PostMapping(value = "/yaml", consumes = "application/x-yaml", produces = "application/json")
    public ResponseEntity<String> handleYaml(@RequestBody DataPipeline dataPipeline) throws Exception {
        String yamlString= yamlObjectMapper.writeValueAsString(dataPipeline);
        ManagePipeline.createDataPipeline(yamlString);
        return new ResponseEntity<>("DataPipeline Created", HttpStatus.CREATED);
    }

    @PostMapping(value = "/filter/tableName", consumes = "application/json", produces = "application/json")
    public ResponseEntity<DqRulesToDataAssetMap> filterByTableName(@RequestBody DataAssetMap dataAssetMap) throws Exception {
        DqRulesToDataAssetMap result = dataHubApiService.getDataAssetMap(dataAssetMap.getTableName());
        return ResponseEntity.ok(result);
    }
}

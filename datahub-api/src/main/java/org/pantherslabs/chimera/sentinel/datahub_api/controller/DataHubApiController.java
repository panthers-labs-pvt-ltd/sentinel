package org.pantherslabs.chimera.sentinel.datahub_api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.pantherslabs.chimera.sentinel.datahub.pipeline.ManagePipeline;
import org.pantherslabs.chimera.unisca.pipeline_metadata_api.dto.DataPipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chimera/test/api")
public class DataHubApiController {

    @Autowired
    private ObjectMapper yamlObjectMapper;

    @PostMapping(value = "/yaml", consumes = "application/x-yaml", produces = "application/json")
    public ResponseEntity<String> handleYaml(@RequestBody DataPipeline dataPipeline) throws Exception {
        String yamlString= yamlObjectMapper.writeValueAsString(dataPipeline);
        ManagePipeline.createDataPipeline(yamlString);
        return new ResponseEntity<>("DataPipeline Created", HttpStatus.CREATED);
    }
}

package org.pantherslabs.chimera.sentinel.datahub.pipeline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagePipelineAPI {

    @Test
    void createDataPipeline() throws Exception {
        ManagePipeline.createDataPipeline("/mnt/f/wsl_apps/packages/sentinel/datahub/src/test/resources/ManagePipeline_2.yaml");

    }

    @Test
    void createPipelineStages() {
    }
}
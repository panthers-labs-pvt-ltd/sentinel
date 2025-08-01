package org.pantherslabs.chimera.sentinel.datahub.service;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataHubIngestionTest {

    @Test
    void createIngestionTest() throws Exception {
        // Recipe YAML
        String recipeYaml = """
                source:
                    type: postgres
                    config:
                        host_port: 'localhost:5432'
                        database: datahub
                        username: postgres
                        include_tables: true
                        include_views: true
                        profiling:
                            enabled: true
                            profile_table_level_only: true
                        stateful_ingestion:
                            enabled: true
                        password: Abnamro1!
                        schema_pattern:
                            allow:
                                - public
                        table_pattern:
                            allow:
                                - metadata_aspect_v2
        """;
        Map<String, String> appProps = Map.of(
                "memory", "10GB",
                "description", "Testing");

        DataHubIngestion.createIngestion("TestIngestion", recipeYaml,"default","2.1",appProps);
    }
}
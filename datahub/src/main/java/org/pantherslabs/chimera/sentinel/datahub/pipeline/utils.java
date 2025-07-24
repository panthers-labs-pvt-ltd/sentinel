package org.pantherslabs.chimera.sentinel.datahub.pipeline;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.pantherslabs.chimera.sentinel.datahub.modal.Pipeline;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

import java.io.*;

public class utils {

    public static Pipeline getPipelineInfo(String inFilePath) throws IOException {
        ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(ManagePipeline.class);
        File file = new File(inFilePath);
        String InputFormat =  file.getAbsolutePath().toLowerCase();
        String SchemaFormat;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        if (InputFormat.endsWith(".yaml") || InputFormat.endsWith(".yml"))
            SchemaFormat="YAML";
        else if (InputFormat.endsWith(".json"))
            SchemaFormat="JSON";
        else throw new RuntimeException("Invalid Format of Dataset Definition");

        Pipeline pipeline;
        try (InputStream inputStream = new FileInputStream(inFilePath))        {
        switch (SchemaFormat.toUpperCase()) {
            case "JSON":
                objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);
                try {
                    pipeline = objectMapper.readValue(inputStream, Pipeline.class);
                } catch (IOException e) {
                    DatahubLogger.logError("Error While Processing Json Schema " + e.getMessage());
                    return null;
                }
                break;
            case "YML":
            case "YAML":
                ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
                try {
                    pipeline =  yamlMapper.readValue(inputStream, Pipeline.class);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                System.out.println("Unsupported format: " + SchemaFormat);
                throw new IllegalArgumentException("Invalid format provided: " + SchemaFormat);
        }
        }
        return  pipeline;
    }
}

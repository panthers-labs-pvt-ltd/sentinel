/*
package org.pantherslabs.chimera.sentinel.data_quality;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import com.fasterxml.jackson.core.type.TypeReference;
import org.apache.spark.sql.SparkSession;
import org.pantherslabs.chimera.sentinel.data_quality.api.model.generated.DataQualityVw;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.pantherslabs.chimera.unisca.execution_engine.OptimizedSparkSession;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.consumer.ApiConsumer;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ResponseWrapper;
import java.io.IOException;
import java.util.List;

public class DataQualityManager {
    private final ChimeraLogger Logger =  ChimeraLoggerFactory.getLogger(DataQualityManager.class);


    String filterApiUrl = "http://192.168.100.22:9001/api/data-quality/filter";
    ApiConsumer consumer = new ApiConsumer();

     private Dataset<Row> getDataQualityRules(SparkSession spark,String processType, String databaseName, String tableName) throws IOException, InterruptedException {
        Logger.logInfo(String.format("Fetching %s Data Quality Rules for %s.%s", processType,databaseName, tableName));

        String filter = String.format("""
                {
                  "table": "data_quality_vw",
                  "filters": [
                    { "field": "database_name", "operator": "=", "value": ["%s"] },
                    { "field": "table_name", "operator": "=", "value": ["%s"] },
                    { "field": "process_name", "operator": "=", "value": ["%s"] }
                  ]
                }""",databaseName,tableName,processType);

        Dataset<Row> rulesDf = spark.emptyDataFrame();

        ResponseWrapper<List<DataQualityVw>, ErrorResponse> response = consumer.post(filterApiUrl,
                filter, new TypeReference<List<DataQualityVw>>() {},new TypeReference<ErrorResponse>() {});

        if (response.isSuccess()) {
            Logger.logInfo("API Response Received ...");
            List<DataQualityVw> rulesList = response.getSuccessBody();
            if (rulesList != null && !rulesList.isEmpty()) {
                rulesDf = spark.createDataFrame(rulesList, DataQualityVw.class);
            }
        } else {
            ErrorResponse error = response.getFailureBody();
            Logger.logInfo("API Response Received With Error..." + error.getErrorMessage());
            Logger.logError(String.format(
                    "Type: %s | Message: %s | Code: %s | ErrorTimestamp: %s | RequestURI: %s",
                    error.getErrorType(),
                    error.getErrorMessage(),
                    error.getErrorCode(),
                    error.getErrorTimestamp(),
                    error.getErrorRequestURI()
            ));
     }
        rulesDf.show();
        return rulesDf;
    }

    public void executeDataQuality(String databaseName,String  tableName) throws IOException, InterruptedException {
        OptimizedSparkSession spark = OptimizedSparkSession.get("DataQualityManager","test");
        Dataset<Row>  DQRules = getDataQualityRules(spark,"CoarseDQService",databaseName,tableName);

    }
}
*/

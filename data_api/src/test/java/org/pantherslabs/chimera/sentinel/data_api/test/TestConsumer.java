package org.pantherslabs.chimera.sentinel.data_api.test;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import org.testng.annotations.Test;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ResponseWrapper;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.consumer.ApiConsumer;
import org.pantherslabs.chimera.sentinel.data_api.model.generated.DataControls;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.ErrorResponse;
import java.io.IOException;
import java.util.List;

public class TestConsumer {
    ApiConsumer consumer = new ApiConsumer();

    @Test
    public void GetControl() throws IOException, InterruptedException {
        DataControls dataSource = consumer.get("http://localhost:9001/api/data-controls/1", new TypeReference<DataControls>() {});
        System.out.println(dataSource);
    }

    @Test
    public void GetControlWithInput() throws IOException, InterruptedException {
        String filter = """
                {
                  "table": "data_controls",
                  "filters": [
                    { "field": "active_flg", "operator": "=", "value": ["N"] },
                    { "field": "control_Name", "operator": "like", "value": ["a"] },
                    { "field": "control_id", "operator": ">", "value": [6] }
                  ]
                }""";
        ResponseWrapper<List<DataControls>, ErrorResponse> response = consumer.post("http://localhost:9001/api/data-controls/filter",
                filter, new TypeReference<List<DataControls>>() {},new TypeReference<ErrorResponse>() {});
        if (response.isSuccess()) {
            List<DataControls> data = response.getSuccessBody();
            data.forEach(System.out::println);

        } else {
            ErrorResponse error = response.getFailureBody();
            System.err.println("API Error:");
            System.err.println("Type: " + error.getErrorType());
            System.err.println("Message: " + error.getErrorMessage());
            System.err.println("Code: " + error.getErrorCode());
            System.err.println("ErrorTimestamp: " + error.getErrorTimestamp());
            System.err.println("RequestURI: " + error.getErrorRequestURI());


        }
    }


}

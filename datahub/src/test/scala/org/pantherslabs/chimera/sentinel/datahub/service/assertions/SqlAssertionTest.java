package org.pantherslabs.chimera.sentinel.datahub.service.assertions;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.*;
class SqlAssertionTest {
    SqlAssertion sqlAssertion = new SqlAssertion();
    @Test
    void createSqlAssertion() throws Exception {
        String dataPlatform="postgres";
        String datasetName="sentinel.public.data_control_dimensions";
        String fabricType="PROD";
        String businessDate="data_management_goods_classification_20250713045221";
        sqlAssertion.create(dataPlatform,datasetName,fabricType, businessDate);
    }
    @Test
    void runSqlAssertion() throws Exception {
        String dataPlatform="postgres";
        String datasetName="sentinel.public.data_control_dimensions";
        String fabricType="PROD";
        String businessDate="data_management_goods_classification_20250713045221";
        sqlAssertion.run(dataPlatform,datasetName,fabricType, "www.google.com", businessDate);
    }
}
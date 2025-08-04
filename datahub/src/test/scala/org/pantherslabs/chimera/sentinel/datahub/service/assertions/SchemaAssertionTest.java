package org.pantherslabs.chimera.sentinel.datahub.service.assertions;

import org.junit.jupiter.api.Test;
import org.pantherslabs.chimera.sentinel.datahub.dto.Field;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SchemaAssertionTest {
    SchemaAssertion assertion = new SchemaAssertion();
    String dataPlatform="postgres";
    String datasetName="sentinel.public.data_control_dimensions";
    String fabricType="PROD";
    String schemaName="public";
    String sqlDDL="Create table sentinel.public.data_control_dimensions(sno String) ";
    List<Field> schemaList = new ArrayList<>();
    String schemaDesc="Schema for Dataset data_control_dimensions";

    @Test
    void createAssertion() {
        try {
            schemaList.add(new Field("id", "String",true));
            schemaList.add(new Field("age", "Integer",true));
            schemaList.add(new Field("created_at", "Timestamp",true));

            assertion.create(dataPlatform,datasetName,fabricType,schemaName,sqlDDL,schemaList,schemaDesc);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void runAssertion() {
        schemaList.add(new Field("id", "String",true));
        schemaList.add(new Field("age", "Integer",true));
        schemaList.add(new Field("created_at", "Timestamp",true));
        try {
            assertion.run(dataPlatform,datasetName,fabricType,null,schemaList);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
package org.pantherslabs.chimera.sentinel.datahub.service.assertions;

import com.linkedin.assertion.*;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringMap;

import java.time.Instant;

public class CustomAssertions {


    public void customSchemaAssertion(String datasetUrnStr, long expectedMinRowCount, long actualRowCount) throws Exception {

        Urn assertionUrn = Urn.createFromString("urn:li:assertion:version-gt-zero");
        Urn datasetUrn = Urn.createFromString("urn:li:dataset:(urn:li:dataPlatform:postgres,datahub.public.metadata_aspect_v2,PROD)");
        long currentTime = Instant.now().toEpochMilli();

        CustomAssertionInfo schemaAssertion = new CustomAssertionInfo();
        schemaAssertion.setEntity(datasetUrn);
        schemaAssertion.setField(Urn.createFromString("email"));
        schemaAssertion.setLogic("email IS NOT NULL");
        schemaAssertion.setType("NOT_NULL");

        StringMap nativeResult = new StringMap();
        nativeResult.putIfAbsent("A","B");

        AssertionRunEvent assertionRunEvent = new AssertionRunEvent()
                .setAssertionUrn(assertionUrn)
                .setTimestampMillis(currentTime)
                .setStatus(AssertionRunStatus.COMPLETE)
                .setResult(new AssertionResult()
                        .setType(AssertionResultType.SUCCESS)
                        .setExternalUrl("https://your-monitor.com/assertion/version-gt-zero")
                        .setRowCount(0)
                        .setUnexpectedCount(0)
                        .setActualAggValue(0.0F)
                        .setError(new AssertionResultError().setType(AssertionResultErrorType.CUSTOM_SQL_ERROR))
                        .setNativeResults(nativeResult)
                        .setMissingCount(0L));

            }
}

package org.pantherslabs.chimera.sentinel.datahub.service;

import com.linkedin.common.urn.DataPlatformUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringMap;
import com.linkedin.ingestion.*;
import com.linkedin.mxe.MetadataChangeProposal;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.linkedin.data.template.SetMode.REMOVE_IF_NULL;
import static com.linkedin.ingestion.DataHubIngestionSourceSourceType.SYSTEM;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.INGESTION_INFO_ASPECT_NAME;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;

public class DataHubIngestion {
    static List<MetadataChangeProposal> proposals = new ArrayList<>();
    public static void createIngestion(String name,String recipe, String executorId, String version,
                                       Map<String,String> extraArgs) throws Exception {
        DataHubIngestionSourceSource source = new DataHubIngestionSourceSource()
                .setType(SYSTEM);
        Urn sourceUrn = Urn.createFromString("urn:li:dataHubIngestionSource:" + name);


        StringMap ExtraArgs = new StringMap();
        ExtraArgs.putAll(extraArgs);


        DataHubIngestionSourceConfig dsc = new DataHubIngestionSourceConfig()
                .setExecutorId(executorId, REMOVE_IF_NULL)
                .setRecipe(recipe, REMOVE_IF_NULL)
                .setVersion(version)
                .setExtraArgs(ExtraArgs);

        DataHubIngestionSourceSchedule runSchedule = new DataHubIngestionSourceSchedule();
        runSchedule.setInterval("@daily");
        runSchedule.setTimezone("Asia/Kolkata");

        DataHubIngestionSourceInfo ds = new DataHubIngestionSourceInfo()
                .setName(name)
                .setSource(source)
                .setPlatform(new DataPlatformUrn("postgres"))
                .setConfig(dsc)
                .setSchedule(runSchedule)
                .setType("postgres");


        proposals.add(buildProposal(sourceUrn, INGESTION_INFO_ASPECT_NAME, ds, "UPSERT"));
        EmitResult result = emitEvent(proposals);
        System.out.println(result.getErrorDetails());

    }
}








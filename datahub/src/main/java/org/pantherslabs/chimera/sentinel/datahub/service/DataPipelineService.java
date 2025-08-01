package org.pantherslabs.chimera.sentinel.datahub.service;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.linkedin.common.*;
import com.linkedin.common.GlobalTags;
import com.linkedin.common.url.Url;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.DataFlowUrn;
import com.linkedin.common.urn.DataJobUrn;
import com.linkedin.common.urn.DatasetUrn;
import com.linkedin.common.urn.GlossaryTermUrn;
import com.linkedin.data.template.StringMap;
import com.linkedin.datajob.DataFlowInfo;
import com.linkedin.datajob.DataJobInfo;
import com.linkedin.datajob.DataJobInputOutput;
import com.linkedin.datajob.JobStatus;
import com.linkedin.mxe.MetadataChangeProposal;
import org.pantherslabs.chimera.sentinel.datahub.dto.*;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter.emitEvent;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.buildProposal;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.getOrElse;

public class DataPipelineService {
    static ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(DataPipelineService.class);
    static String LoggerTag = "[DataHub- Create Pipeline] -";
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result = null;


    private static Pipeline getPipelineConfig(String pipelineMetadata, String schemaFormat) {
        try {
            return switch (schemaFormat.toUpperCase()) {
                case "JSON" -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE);
                    yield objectMapper.readValue(pipelineMetadata, Pipeline.class);
                }
                case "YML", "YAML" -> {
                    ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
                    yield yamlMapper.readValue(pipelineMetadata, Pipeline.class);
                }
                default -> throw new IllegalArgumentException("❌ Unsupported format: " + schemaFormat);
            };
        } catch (IOException e) {
            throw new IllegalArgumentException("❌ Failed to parse " + schemaFormat.toUpperCase() + " input: " + e.getMessage(), e);
        }
    }

    public EmitResult createDataPipeline(String pipelineMetadata, String schemaFormat) throws Exception {
        Pipeline dataPipeline = getPipelineConfig(pipelineMetadata, schemaFormat);

        if (dataPipeline != null) {
            String platform = dataPipeline.getProcessingEngine();
            String flowName = dataPipeline.getPipelineName();
            String cluster = dataPipeline.getFabricType();
            String domain = dataPipeline.getDomainName();

            DataFlowUrn dataFlowUrn = new DataFlowUrn(platform, flowName, cluster);
            CorpuserUrn userUrn = new CorpuserUrn(DATAHUB_ACTOR);

            TimeStamp createdStamp = new TimeStamp()
                    .setActor(new CorpuserUrn(userUrn.getUsernameEntity()))
                    .setTime(Instant.now().toEpochMilli());

            Map<String, String> customProperties = new HashMap<>();
            dataPipeline.getProperties().forEach(p -> customProperties.put(p.getName(), p.getValue()));
            StringMap MapCustomProperties = new StringMap();
            MapCustomProperties.putAll(customProperties);
            FabricType env = FabricType.valueOf(dataPipeline.getFabricType());

            DataFlowInfo dataFlowInfo = new DataFlowInfo()
                    .setName(flowName)
                    .setCreated(createdStamp)
                    .setDescription(dataPipeline.getPipelineDescription())
                    .setCustomProperties(MapCustomProperties)
                    .setEnv(env)
                    .setExternalUrl(new Url(dataPipeline.getUri()))
                    .setProject(domain);

              proposals.add(buildProposal(dataFlowUrn,DATA_FLOW_INFO_ASPECT_NAME,dataFlowInfo,ACTION_TYPE));

            DatahubLogger.logInfo(LoggerTag + " Pipeline Data Flow ");

            GlobalTags globalTags = setGlobalTags(dataPipeline.getTags());
            proposals.add(buildProposal(dataFlowUrn,GLOBAL_TAGS_ASPECT_NAME,globalTags,ACTION_TYPE));
            DatahubLogger.logInfo(LoggerTag + " Pipeline Global Tags ");

            DomainHierarchyService manageDomain = new DomainHierarchyService();
            Domains domains = new Domains(dataPipeline.getDomainName());
            manageDomain.createDomainHierarchy(domains,ACTION_TYPE);

            Map<String, String> ownersMap = new HashMap<>();
            for (Owners owner : dataPipeline.getOwners()) {
                ownersMap.put(owner.getName(), owner.getType());
            }

            Map<String, List<String>> ownersInfo = new HashMap<>();
            for (Map.Entry<String, String> entry : ownersMap.entrySet()) {
                String ownerName = entry.getKey();
                String ownerType = entry.getValue();

                // Add the ownerName to the list under the corresponding ownerType
                ownersInfo.computeIfAbsent(ownerType, k -> new ArrayList<>()).add(ownerName);
            }
            OwnershipService.createOwners(dataFlowUrn, DATA_FLOW_ENTITY_NAME,ownersInfo, ACTION_TYPE);

            if (dataPipeline.getGlossaryTerm() != null && !dataPipeline.getGlossaryTerm().isEmpty()) {
                GlossaryTerms glossaryTerms = setGlossaryTerms(dataPipeline.getGlossaryTerm(), userUrn.getUsernameEntity());

                proposals.add(buildProposal(dataFlowUrn,GLOSSARY_TERMS_ASPECT_NAME,glossaryTerms,ACTION_TYPE));
                DatahubLogger.logInfo(LoggerTag + " Glossary Term Data Flow ");


                AuditStamp lastModified = new AuditStamp()
                        .setTime(Instant.now().toEpochMilli())
                        .setActor(new CorpuserUrn(userUrn.getUsernameEntity()));

                InstitutionalMemory institutionalMemory = new InstitutionalMemory().setElements(
                        new InstitutionalMemoryMetadataArray(new InstitutionalMemoryMetadata()
                                .setDescription(dataPipeline.getPipelineDescription())
                                .setCreateStamp(lastModified)
                                .setUrl(new Url(dataPipeline.getUri()))));
                proposals.add(buildProposal(dataFlowUrn,INSTITUTIONAL_MEMORY_ASPECT_NAME,institutionalMemory,ACTION_TYPE));

                DatahubLogger.logInfo(LoggerTag + " InstitutionalMemory Data Flow ");

                //new DataProductService().addAssetToDataProduct(dataPipeline.getDataProductName(), dataFlowUrn.toString());
                Status isActive = new Status().setRemoved(dataPipeline.isInActiveFlag());
                proposals.add(buildProposal(dataFlowUrn,STATUS_ASPECT_NAME,isActive,ACTION_TYPE));

                DatahubLogger.logInfo(LoggerTag + " Status Data Flow " );

                result = createPipelineStages(dataPipeline, String.valueOf(dataFlowUrn), flowName);

            }
        }
        return  result;
    }

    public static GlobalTags setGlobalTags(List<Tag> datasetTags) throws IOException, ExecutionException, InterruptedException {
        TagAssociationArray tagAssociationArray = new TagAssociationArray();

        // Iterate over the datasetTags list
        for (Tag datasetTag : datasetTags) {
            String tagName = datasetTag.getName();
            String value = datasetTag.getValue();

            com.linkedin.common.urn.TagUrn tagUrn = new com.linkedin.common.urn.TagUrn(tagName);
            TagAssociation tagAssociation = new TagAssociation().setTag(tagUrn).setContext(value);
            tagAssociationArray.add(tagAssociation);
            //ManageTags.createTags(tagName,value);
        }
        return new GlobalTags().setTags(tagAssociationArray);
    }

    public static GlossaryTerms setGlossaryTerms(List<GlossaryTerm> glossaryTerms, String userName)  {
        // Create the audit stamp
        AuditStamp createdStamp = new AuditStamp()
                .setActor(new CorpuserUrn(userName))
                .setTime(Instant.now().toEpochMilli());

        // Create the glossary term association array
        GlossaryTermAssociationArray glossaryTermAssociationArray = new GlossaryTermAssociationArray();

        // Iterate through the glossary terms list
        for (GlossaryTerm glossaryTerm : glossaryTerms) {
            String glossaryTermName = glossaryTerm.getGlossaryTermName();
            String documentations = glossaryTerm.getDocumentations();

            if (glossaryTermName != null && !glossaryTermName.isEmpty()) {

                GlossaryTermAssociation termAssociation = new GlossaryTermAssociation()
                        .setUrn(new GlossaryTermUrn(glossaryTermName))
                        .setContext(documentations)
                        .setActor(new CorpuserUrn(userName));
                glossaryTermAssociationArray.add(termAssociation);
            }
        }

        // Create the GlossaryTerms object and set properties
        GlossaryTerms glossaryTermObject = new GlossaryTerms();
        glossaryTermObject.setTerms(glossaryTermAssociationArray)
                .setAuditStamp(createdStamp);


        return glossaryTermObject;
    }
    public  EmitResult createPipelineStages(Pipeline dataPipeline,String pipelineUrn, String PipelineName ) throws
            Exception {
        DataFlowUrn pipelineUr = DataFlowUrn.createFromString(pipelineUrn);
        List<JobStages> stages = dataPipeline.getStages();
        for (JobStages stageInfo : stages) {
            DataJobInfo dataJobInfo = new DataJobInfo();
            DataJobUrn dataJobUrn = new DataJobUrn(DataFlowUrn.createFromString(pipelineUrn),stageInfo.getStageName());

            DataJobInfo.Type JobType =  new DataJobInfo.Type();
            JobType.setString(stageInfo.getStageType());

            Map<String, String> customProperties = new HashMap<>();
            stageInfo.getProperties().forEach(p -> customProperties.put(p.getName(), p.getValue()));
            StringMap MapCustomProperties = new StringMap();
            MapCustomProperties.putAll(customProperties);

            String stageName = PipelineName + "( " + stageInfo.getStageName() + " )";
            dataJobInfo
                    .setDescription(stageInfo.getStageDescription())
                    .setEnv(FabricType.DEV)
                    .setName(stageName)
                    .setFlowUrn(pipelineUr)
                    .setExternalUrl(new Url(stageInfo.getStageUrl()))
                    .setType(JobType)
                    .setStatus(JobStatus.UNKNOWN)
                    .setCustomProperties(MapCustomProperties);

            proposals.add(buildProposal(dataJobUrn,DATA_JOB_INFO_ASPECT_NAME,dataJobInfo,ACTION_TYPE));

            DatahubLogger.logInfo(LoggerTag + " Data Job Info  dataJobInfoRetVal");

            DataJobInputOutput dataJobInputOutput = new DataJobInputOutput();
            DatasetUrnArray datasetUrnArray = new DatasetUrnArray();
            DatasetUrnArray outputDatasetUrnArray = new DatasetUrnArray();
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
            List<Dataset> outputDataset = stageInfo.getOutputDataset();
            List<Dataset> inputDataset = stageInfo.getInputDataset();
            String inDatasetJson;
            if (inputDataset != null && !inputDataset.isEmpty())
            {
                for (Dataset in : inputDataset) {
                    try {
                        String DatasetPlatform = getOrElse(in.getDatasetPlatformName(), dataPipeline.getProcessingEngine());
                        String DatasetName = getOrElse(in.getName(), "Invalid");
                        String Fabric = getOrElse(in.getFabricType(), dataPipeline.getFabricType());

                        String datasetURN = String.format("urn:li:dataset:(urn:li:dataPlatform:%s,%s,%s)",
                                DatasetPlatform, DatasetName, Fabric);
                        //TODO Recheck what needs to be added
                        /*if (!searchAssets.get(datasetURN, DATASET_KEY_ASPECT_NAME)) {
                            inDatasetJson = objectMapper.writeValueAsString(in);
                            ManageDatasets.createDataset(inDatasetJson, SYSTEM_USER);
                        }*/
                        datasetUrnArray.add(DatasetUrn.createFromString(datasetURN));
                    } catch (Exception e) {
                        DatahubLogger.logError("Error While adding Input Datasets",e);
                        throw new RuntimeException(e);
                    }
                }
                dataJobInputOutput.setInputDatasets(datasetUrnArray);
            }
            if (outputDataset != null && !outputDataset.isEmpty())
            {
                //outputDataset.forEach(out ->
                for (Dataset out : outputDataset){
                    try {
                        String DatasetPlatform=getOrElse(out.getDatasetPlatformName(),dataPipeline.getProcessingEngine());
                        String DatasetName=getOrElse(out.getName(),"Invalid");
                        String Fabric=getOrElse(out.getFabricType(),dataPipeline.getFabricType());

                        String datasetURN= String.format("urn:li:dataset:(urn:li:dataPlatform:%s,%s,%s)",
                                DatasetPlatform,DatasetName, Fabric);
                        //TODO  Check what needs
              /*          if (!searchAssets.get(datasetURN, DATASET_KEY_ASPECT_NAME)) {
                            inDatasetJson = objectMapper.writeValueAsString(out);
                            ManageDatasets.createDataset(inDatasetJson, SYSTEM_USER);
                        }*/
                        outputDatasetUrnArray.add(DatasetUrn.createFromString(datasetURN));
                    } catch (Exception e) {
                        DatahubLogger.logError("Error While adding Output Datasets",e);
                        throw new RuntimeException(e);
                    }
                }
                dataJobInputOutput.setOutputDatasets(outputDatasetUrnArray);
            }
            else
            {
                dataJobInputOutput.setOutputDatasets(datasetUrnArray);
            }


            dataJobInputOutput.setInputDatasets(datasetUrnArray); // Provide dataset URNs here
            dataJobInputOutput.setOutputDatasets(outputDatasetUrnArray); // Provide dataset URNs here
            proposals.add(buildProposal(dataJobUrn,DATA_JOB_INPUT_OUTPUT_ASPECT_NAME,dataJobInputOutput,ACTION_TYPE));
            result = emitEvent(proposals);
            DatahubLogger.logInfo("Data Job Return " );
        }
        return result;
    }
}

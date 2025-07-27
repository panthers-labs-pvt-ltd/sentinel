package org.pantherslabs.chimera.sentinel.datahub.api.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.linkedin.common.*;
import com.linkedin.common.url.Url;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.DataPlatformUrn;
import com.linkedin.common.urn.DatasetUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.common.urn.UrnUtils;
import com.linkedin.data.ByteString;
import com.linkedin.data.template.StringArray;
import com.linkedin.data.template.StringMap;
import com.linkedin.dataset.DatasetProperties;
import com.linkedin.dataset.EditableDatasetProperties;
import com.linkedin.mxe.GenericAspect;
import com.linkedin.mxe.MetadataChangeProposal;
import com.linkedin.query.*;
import com.linkedin.schema.*;
import org.pantherslabs.chimera.sentinel.datahub.dataproduct.ManageDataProduct;
import org.pantherslabs.chimera.sentinel.datahub.domain.ManageDomain;
import org.pantherslabs.chimera.sentinel.datahub.emitter.TransactionalDataHubEmitter;
import org.pantherslabs.chimera.sentinel.datahub.modal.*;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.common.genericUtils.serializeAspect;
import static org.pantherslabs.chimera.sentinel.datahub.datasets.schema.*;
import static org.pantherslabs.chimera.sentinel.datahub.ownership.ManageOwners.addOwners;
import static org.pantherslabs.chimera.sentinel.datahub.users.SecretService.buildProposal;

@Service
public class ManageDatasets {
    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(org.pantherslabs.chimera.sentinel.datahub.datasets.ManageDatasets.class);
    List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result = null;

    public EmitResult createDataset(String DatasetDefinition, String inFormat, String actionType){
        DatahubLogger.logInfo("Creating Datasets Initializing .....");
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            DatahubLogger.logInfo("Processing Dataset Creation Response ");
            Dataset datasetsInfo = getDatasetInformation(DatasetDefinition, inFormat);
            DatahubLogger.logInfo("Validating Dataset Response ..");
            validateDataset(datasetsInfo);

            String fabricType = String.valueOf(FabricType.valueOf(datasetsInfo.getFabricType()));
            DatasetUrn datasetUrn = UrnUtils.toDatasetUrn(datasetsInfo.getDatasetPlatformName(),
                    datasetsInfo.getName(), fabricType);

            CorpuserUrn userUrn = new CorpuserUrn(SYSTEM_ACTOR);

            AuditStamp createdStamp = new AuditStamp()
                    .setActor(new CorpuserUrn(DATAHUB_ACTOR))
                    .setTime(Instant.now().toEpochMilli());
//======================Testing for Query
            QueryStatement QS = new QueryStatement()
                    .setLanguage(QueryLanguage.SQL)
                    .setValue("SELECT * from DUAL");
            QuerySubject QSS = new QuerySubject().setEntity(datasetUrn);


            QueryProperties QP=new QueryProperties()
                    .setStatement(QS)
                    .setSource(QuerySource.SYSTEM)
                    .setCreated(createdStamp)
                    .setDescription("========")
                    .setName("MYNAME")
                    .setOrigin(datasetUrn)
                    .setLastModified(createdStamp);
            //proposals.add(buildProposal(datasetUrn,"queryProperties",QP,actionType));
            //proposals.add(buildProposal(datasetUrn,"querySubjects",QSS,actionType));
//======================Testing for Query

            SchemaFieldArray schemaFieldArray = new SchemaFieldArray();

            EditableSchemaFieldInfoArray editableSchemaFieldInfoArray = new EditableSchemaFieldInfoArray();
            EditableSchemaMetadata editableSchemaMetadata = new EditableSchemaMetadata()
                    .setEditableSchemaFieldInfo(editableSchemaFieldInfoArray);

            List<Field> SchemaLists = datasetsInfo.getFields();
            StringArray primaryKeys = new StringArray();
            ForeignKeyConstraintArray foreignKeyConstraintArray = new ForeignKeyConstraintArray();

            for (Field schema : SchemaLists) {
                SchemaField schemaField = new SchemaField();
                schemaField.setFieldPath(schema.getFieldCanonicalName());
                schemaField.setLabel(schema.getDisplayName());
                schemaField.setIsPartitioningKey(schema.isPartitionKey());
                schemaField.setIsPartOfKey(schema.isPrimaryKey());
                schemaField.setNullable(schema.isNullable());
                schemaField.setType(NativeTypeToSchemaType(schema.getType()));
                schemaField.setNativeDataType(schema.getType());
                schemaField.setDescription(schema.getDescription());
                schemaField.setLastModified(createdStamp);

                EditableSchemaFieldInfo editableSchemaFieldInfo = new EditableSchemaFieldInfo();
                editableSchemaFieldInfo.setFieldPath(schema.getFieldCanonicalName());

                if (schema.isPrimaryKey()) {
                    primaryKeys.add(schema.getName());
                }

                if (schema.getTags() != null && !schema.getTags().isEmpty()) {
                    editableSchemaFieldInfo.setGlobalTags(setGlobalTags(schema.getTags()));
                }
                if (schema.getGlossaryTerm() != null && !schema.getGlossaryTerm().isEmpty()) {
                    editableSchemaFieldInfo.setGlossaryTerms(setGlossaryTerms(schema.getGlossaryTerm(),
                            userUrn.getUsernameEntity()));
                }
                schemaFieldArray.add(schemaField);
                editableSchemaFieldInfoArray.add(editableSchemaFieldInfo);

                UrnArray ForeignFieldsUrnArray = new UrnArray();
                UrnArray SourceFieldsUrnArray = new UrnArray();
                SourceFieldsUrnArray.add(datasetUrn);

                if (schema.getForeignKey() != null && !schema.getForeignKey().isEmpty()) {
                    for (ForeignKey fk : schema.getForeignKey()) {
                        ForeignFieldsUrnArray.add(UrnUtils.toDatasetUrn(fk.getDatasetPlatform(), fk.getDatasetName(),
                                fk.getOrigin()));

                        ForeignKeyConstraint foreignKeyConstraint = new ForeignKeyConstraint()
                                .setForeignDataset(UrnUtils.toDatasetUrn(fk.getDatasetPlatform(), fk.getDatasetName(),
                                        fk.getOrigin()))
                                .setForeignFields(ForeignFieldsUrnArray)
                                .setSourceFields(SourceFieldsUrnArray)
                                .setName(fk.getForeignKeyName());
                        foreignKeyConstraintArray.add(foreignKeyConstraint);
                    }
                }
            }
            SchemaMetadata schemaMetadata =
                    new SchemaMetadata()
                            .setSchemaName(datasetsInfo.getName())
                            .setPlatform(new DataPlatformUrn(datasetsInfo.getDatasetPlatformName()))
                            .setVersion(0L)
                            .setHash("")
                            .setFields(schemaFieldArray)
                            .setPlatformSchema(
                                    SchemaMetadata.PlatformSchema.create(
                                            new OtherSchema().setRawSchema(objectMapper.writeValueAsString(datasetsInfo.getFields()))))
                            .setCreated(createdStamp)
                            .setLastModified(createdStamp)
                            .setDataset(datasetUrn)
                            .setPrimaryKeys(primaryKeys)
                            .setForeignKeys(foreignKeyConstraintArray)
                            .setCluster("Unknown");

            proposals.add(buildProposal(datasetUrn,SCHEMA_METADATA_ASPECT_NAME,schemaMetadata,actionType));
            proposals.add(buildProposal(datasetUrn,EDITABLE_SCHEMA_METADATA_ASPECT_NAME,editableSchemaMetadata,actionType));


            EditableDatasetProperties editableDatasetProperties = new EditableDatasetProperties()
                    .setDescription(datasetsInfo.getDescription())
                    .setLastModified(createdStamp)
                    .setCreated(createdStamp)
                    .setName(datasetsInfo.getQualifiedName());
            proposals.add(buildProposal(datasetUrn,EDITABLE_DATASET_PROPERTIES_ASPECT_NAME,editableDatasetProperties,actionType));

            List<Property> propertyList = datasetsInfo.getProperties();
            Map<String, String> propertyMap = propertyList.stream()
                    .collect(Collectors.toMap(Property::getName, Property::getValue));

            StringMap MapCustomProperties = new StringMap();
            MapCustomProperties.putAll(propertyMap);

            DatasetProperties datasetProperties = new DatasetProperties()
                    .setName(datasetsInfo.getDisplayName())
                    .setCustomProperties(MapCustomProperties).
                    setDescription(datasetsInfo.getDescription())
                    .setQualifiedName(datasetsInfo.getQualifiedName())
                    .setExternalUrl(new com.linkedin.common.url.Url(datasetsInfo.getUri()));
            proposals.add(buildProposal(datasetUrn,DATASET_PROPERTIES_ASPECT_NAME,datasetProperties,actionType));

            GlobalTags globalTags = setGlobalTags(datasetsInfo.getTags());
            proposals.add(buildProposal(datasetUrn,GLOBAL_TAGS_ASPECT_NAME,globalTags,actionType));
            DatahubLogger.logInfo("DatasetGlobal Tags Metadata For Dataset Creation");

            //TODO
            ManageDomain manageDomain = new ManageDomain();
            manageDomain.addDomain(datasetsInfo.getDomain(), datasetUrn.toString(), DATASET_ENTITY_NAME);
            DatahubLogger.logInfo("Domain Name Mapping For Dataset Creation Completed");

            //TODO
            Map<String, String> ownersMap = new HashMap<>();
            for (Owners owner : datasetsInfo.getOwners()) {
                ownersMap.put(owner.getName(), owner.getType());
            }
            addOwners(datasetUrn, DATASET_ENTITY_NAME, OWNERSHIP_ASPECT_NAME, ACTION_TYPE, ownersMap);
            DatahubLogger.logInfo("Ownership Mapping For Dataset Creation Completed");

            if (datasetsInfo.getGlossaryTerm() != null && !datasetsInfo.getGlossaryTerm().isEmpty()) {
                GlossaryTerms glossaryTerms = setGlossaryTerms(datasetsInfo.getGlossaryTerm(), userUrn.getUsernameEntity());
                proposals.add(buildProposal(datasetUrn,GLOSSARY_TERMS_ASPECT_NAME,glossaryTerms,actionType));
                DatahubLogger.logInfo("Glossary Mapping For Dataset Creation Completed ");

                InstitutionalMemory institutionalMemory = new InstitutionalMemory().setElements(
                        new InstitutionalMemoryMetadataArray(new InstitutionalMemoryMetadata()
                                .setDescription(datasetsInfo.getDescription())
                                .setCreateStamp(createdStamp)
                                .setUrl(new Url(datasetsInfo.getUri()))));
                proposals.add(buildProposal(datasetUrn,INSTITUTIONAL_MEMORY_ASPECT_NAME,institutionalMemory,actionType));

                DatahubLogger.logInfo("InstitutionalMemory Mapping For Dataset Creation Completed ");

                new ManageDataProduct().addAssetToDataProduct(datasetsInfo.getDataProductName(), datasetUrn.toString());
                DatahubLogger.logInfo("Data Product Mapping For Dataset Creation Completed ");
            }

            // 7. Emit proposal
            TransactionalDataHubEmitter txEmitter = new TransactionalDataHubEmitter();
            result= txEmitter.emitWithRollback(proposals);
        }
        catch (Exception e) {
            System.err.println("Terminating due to dataset schema error: " + e.getMessage());
            result = new EmitResult(false, new ErrorDetails(404,"VALIDATION_FAILED" +  e.getMessage()));
        }
        DatahubLogger.logInfo("Dataset Created");
        return result;
    }

    private Dataset getDatasetInformation(String datasetMetadata, String schemaFormat) {
        try {
            return switch (schemaFormat.toUpperCase()) {
                case "JSON" -> {
                    ObjectMapper objectMapper = new ObjectMapper();
                    yield objectMapper.readValue(datasetMetadata, Dataset.class);
                }
                case "YML", "YAML" -> {
                    ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
                    yield yamlMapper.readValue(datasetMetadata, Dataset.class);
                }
                default -> throw new IllegalArgumentException("❌ Unsupported format: " + schemaFormat);
            };
        } catch (IOException e) {
            throw new IllegalArgumentException("❌ Failed to parse " + schemaFormat.toUpperCase() + " input: " + e.getMessage(), e);
        }
    }

    /**
     * Basic validation logic.
     */
    private void validateDataset(Dataset dataset) {
        if (dataset.getDataProductName() == null || dataset.getDataProductName().isEmpty()) {
            throw new IllegalArgumentException("Data Product Name is required.");
        }

        if (dataset.getName() == null || dataset.getName().isEmpty()) {
            throw new IllegalArgumentException("Dataset name is required.");
        }

        if (dataset.getFabricType() == null || dataset.getFabricType().isEmpty()) {
            throw new IllegalArgumentException("Fabric type is required.");
        }

        if (!isValid(dataset.getFabricType())) {
            throw new IllegalArgumentException("❌ Invalid fabricType: " + dataset.getFabricType() +
                    ". Allowed values: " + Arrays.toString(FabricType.values()));
        }
        if (dataset.getDatasetPlatformName() == null || dataset.getDatasetPlatformName().isEmpty()) {
            throw new IllegalArgumentException("Dataset platform name is required.");
        }
    }

    public boolean isValid(String value) {
        for (FabricType type : FabricType.values()) {
            if (type.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}

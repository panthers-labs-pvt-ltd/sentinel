package org.pantherslabs.chimera.sentinel.datahub.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataQualityVw {
    private Long rowNum;
    private String processName;
    private String controlName;
    private String dimensionName;
    private String ruleName;
    private String ruleColumn;
    private String ruleValue;
    private String databaseName;
    private String schemaName;
    private String tableName;
    private String partitionKeys;
    private String checkLevel;
    }

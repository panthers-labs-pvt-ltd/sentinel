package org.pantherslabs.chimera.sentinel.data_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataAssetMap {
    private String tableName;
    private String dataBaseName;
}

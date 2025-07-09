package org.pantherslabs.chimera.sentinel.data_api.dto;

import lombok.Getter;
import lombok.Setter;
import org.pantherslabs.chimera.sentinel.data_api.generics.FilterCondition;
import java.util.List;
@Getter
@Setter
public class FilterRequest {
    private String table;
    private List<FilterCondition> filters;

}

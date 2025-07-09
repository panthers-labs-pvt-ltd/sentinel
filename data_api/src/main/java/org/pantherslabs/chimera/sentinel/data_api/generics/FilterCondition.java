package org.pantherslabs.chimera.sentinel.data_api.generics;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FilterCondition {

    // Getter and Setter for field
    private String field;
    // Getter and Setter for operator
    private String operator;
    // Getter and Setter for value
    private Object value;

    // Default constructor
    public FilterCondition() {
    }

    // Parameterized constructor
    public FilterCondition(String field, String operator, Object value) {
        this.field = field;
        this.operator = operator;
        this.value = value;
    }

}

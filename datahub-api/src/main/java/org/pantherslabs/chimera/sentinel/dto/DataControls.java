package org.pantherslabs.chimera.sentinel.dto;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataControls {
    private Short controlId;
    private String controlName;
    private String controlShortDesc;
    private String controlLongDesc;
    private String activeFlg;
    private String reserved5;
    private String reserved4;
    private String reserved3;
    private String reserved2;
    private String reserved1;
    private String createdBy;
    private Date createdTs;
    private String updatedBy;
    private Date updatedTs;
}

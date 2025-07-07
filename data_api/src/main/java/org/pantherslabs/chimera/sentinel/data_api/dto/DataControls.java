package org.pantherslabs.chimera.sentinel.data_api.dto;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DataControls {
    private Short controlId;
    @NotNull
    private String controlName;
    @NotNull
    private String controlShortDesc;
    @NotNull
    private String controlLongDesc;
    @NotNull
    private String activeFlg;
    private String reserved5;
    private String reserved4;
    private String reserved3;
    private String reserved2;
    private String reserved1;
    @NotNull
    private String createdBy;
    @NotNull
    private Date createdTs;
    private String updatedBy;
    private Date updatedTs;
}

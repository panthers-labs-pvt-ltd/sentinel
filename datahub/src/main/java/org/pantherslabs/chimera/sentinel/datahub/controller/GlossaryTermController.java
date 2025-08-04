package org.pantherslabs.chimera.sentinel.datahub.controller;

import org.pantherslabs.chimera.sentinel.datahub.dto.GlossaryTerm;
import org.pantherslabs.chimera.sentinel.datahub.service.GlossaryTermService;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/glossary")
public class GlossaryTermController {

    @Autowired
    private GlossaryTermService glossaryTermService;

    /**
     *
     * @param request
     * {
     *   "entityUrn": "urn:li:dataset:(urn:li:dataPlatform:hive,example.dataset,PROD)",
     *   "tagNames": {
     *     "tag1": "description1",
     *     "tag2": "description2"
     *   },
     *   "actionType": "ADD"
     * }
     * @return emit result
     */
     @PostMapping("/add")
    public ResponseEntity<?> createGlossaryTerms(@RequestBody List<GlossaryTerm> request) {

        EmitResult result = null;
        try {
            result = glossaryTermService.createGlossaryTerm(request, "CREATE");

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            assert result != null;
            throw new ChimeraException(
                    "APIException." + result.getErrorDetails().getStatus(),
                    Map.of("exception", result.getErrorDetails().getMessage()),
                    null,
                    HttpStatus.valueOf(result.getErrorDetails().getStatus())
            );
        }
    }
}


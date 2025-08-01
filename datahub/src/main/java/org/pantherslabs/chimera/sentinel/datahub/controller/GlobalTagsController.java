package org.pantherslabs.chimera.sentinel.datahub.controller;

import com.linkedin.common.urn.Urn;
import org.pantherslabs.chimera.sentinel.datahub.dto.GlobalTags;
import org.pantherslabs.chimera.sentinel.datahub.service.GlobalTagService;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.CREATE_ACTION_TYPE;
import static org.pantherslabs.chimera.sentinel.datahub.Constants.UPSERT_ACTION_TYPE;

@RestController
@RequestMapping("/api/tags")
public class GlobalTagsController {

    @Autowired
    private GlobalTagService manageGlobalTag;

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
     * @return
     */
     @PostMapping("/add")
    public ResponseEntity<?> createGlobalTags(@RequestBody GlobalTags request) {

        EmitResult result = null;
        try {
            Urn urn = Urn.createFromString(request.getEntityUrn());
            result = manageGlobalTag.createGlobalTags(
                    request.getEntityUrn(),
                    request.getTagNames(),
                    CREATE_ACTION_TYPE
            );
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
     * @return
     */
    @PostMapping("/edit")
    public ResponseEntity<?> editGlobalTags(@RequestBody GlobalTags request) {

        EmitResult result = null;
        try {
            Urn urn = Urn.createFromString(request.getEntityUrn());
            result = manageGlobalTag.createGlobalTags(
                    request.getEntityUrn(),
                    request.getTagNames(),
                    UPSERT_ACTION_TYPE
            );
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


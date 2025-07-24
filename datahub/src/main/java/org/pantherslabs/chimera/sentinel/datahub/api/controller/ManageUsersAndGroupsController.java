package org.pantherslabs.chimera.sentinel.datahub.api.controller;

import org.pantherslabs.chimera.sentinel.datahub.api.service.ManageUsersAndGroupsService;
import org.pantherslabs.chimera.sentinel.datahub.modal.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.modal.Users;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.response.SuccessResponse;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class ManageUsersAndGroupsController {

    @Autowired
    private ManageUsersAndGroupsService manageUsersAndGroups;

    @PostMapping("/new")
    public ResponseEntity<?> createUsers(@RequestBody List<Users> userInfo) {
        EmitResult result = manageUsersAndGroups.createUsers(userInfo, "CREATE");

        if (!result.isSuccess()) {
            throw new ChimeraException(
                    "APIException." + result.getErrorDetails().getStatus(),
                    Map.of("exception", result.getErrorDetails().getMessage()),
                    null,
                    HttpStatus.valueOf(result.getErrorDetails().getStatus())
            );
        }
        return ResponseEntity.ok(new SuccessResponse("All Users Created Successfully", "200"));
    }

    @PostMapping("/edit")
    public ResponseEntity<?> updateUsers(@RequestBody List<Users> userInfo) throws Exception {
        EmitResult result = manageUsersAndGroups.createUsers(userInfo, "UPSERT");

        if (!result.isSuccess()) {
            throw new ChimeraException(
                    "APIException." + result.getErrorDetails().getStatus(),
                    Map.of("exception", result.getErrorDetails().getMessage()),
                    null,
                    HttpStatus.valueOf(result.getErrorDetails().getStatus())
            );
        }

        return ResponseEntity.ok(new SuccessResponse("All Users Updated successfully", "200"));
    }

    @PostMapping("/deactivate")
    public ResponseEntity<?> deactivateUser(@RequestParam(name = "userName") String userName) {
        EmitResult result = manageUsersAndGroups.deactivateUser(userName);
        if (!result.isSuccess()) {
            throw new ChimeraException(
                    "APIException." + result.getErrorDetails().getStatus(),
                    Map.of("exception", result.getErrorDetails().getMessage()),
                    null,
                    HttpStatus.valueOf(result.getErrorDetails().getStatus())
            );

        }
        return ResponseEntity.ok(new SuccessResponse("User " + userName + " Suspended", "200"));
    }
}
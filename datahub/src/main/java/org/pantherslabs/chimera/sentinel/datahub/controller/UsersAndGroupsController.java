package org.pantherslabs.chimera.sentinel.datahub.controller;

import org.pantherslabs.chimera.sentinel.datahub.service.UsersAndGroupsService;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.dto.Users;
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
public class UsersAndGroupsController {

    @Autowired
    private UsersAndGroupsService manageUsersAndGroups;

    /**
     *
     * @param userInfo
     * [
     *   {
     *     "title": "Mr.",
     *     "firstName": "John",
     *     "lastName": "Doe",
     *     "displayName": "John D.",
     *     "email": "john.doe@example.com",
     *     "manager": "jane.manager@example.com",
     *     "active": true,
     *     "countryCode": "US",
     *     "departmentId": 12345,
     *     "departmentName": "Engineering",
     *     "aboutMe": "Full-stack developer with 10 years of experience.",
     *     "skills": ["Java", "Spring Boot", "MySQL"],
     *     "teams": ["Backend", "API"],
     *     "phone": "+1-555-1234",
     *     "slack": "@johndoe",
     *     "platform": ["GitHub", "Jira"],
     *     "pictureLink": "https://example.com/pictures/johndoe.jpg",
     *     "nativeGroups": ["admins", "devs"],
     *     "groupsMembership": ["engineering", "cloud"]
     *   }]
     * @return
     * @throws Exception
     */
    @PostMapping("/new")
    public ResponseEntity<?> createUsers(@RequestBody List<Users> userInfo) throws Exception {
        EmitResult result = manageUsersAndGroups.createOrEditUsers(userInfo, "CREATE");

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
        EmitResult result = manageUsersAndGroups.createOrEditUsers(userInfo, "UPSERT");

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
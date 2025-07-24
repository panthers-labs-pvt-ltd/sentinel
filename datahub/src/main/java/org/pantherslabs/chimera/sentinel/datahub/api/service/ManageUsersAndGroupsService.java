package org.pantherslabs.chimera.sentinel.datahub.api.service;

import org.pantherslabs.chimera.sentinel.datahub.modal.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.modal.Users;
import org.pantherslabs.chimera.sentinel.datahub.users.ManageUsersAndGroups;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.dto.FilterCondition;
import org.pantherslabs.chimera.unisca.api_nexus.api_nexus_client.dynamic_query.mapper.GenericMapper;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.pantherslabs.chimera.unisca.utilities.ChimeraUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ManageUsersAndGroupsService {
    static ChimeraLogger DCSLogger = ChimeraLoggerFactory.getLogger(ManageUsersAndGroupsService.class);

    public EmitResult createUsers(List<Users> userInfo, String changeType)   {
        EmitResult result = null;
        try{
            ManageUsersAndGroups manageUsersAndGroups = new ManageUsersAndGroups();
            result = manageUsersAndGroups.createOrEditUsers(userInfo, changeType);
        } catch (Exception e) {
            DCSLogger.logError("❌ Exception during user deletion for '" + changeType + "': " + e.getMessage(), e);
            DCSLogger.logError(result.getErrorDetails().getMessage());
        }
        return result;
    }

    public EmitResult deactivateUser(String userInfo)   {
        EmitResult result = null;
        try{
            ManageUsersAndGroups manageUsersAndGroups = new ManageUsersAndGroups();
            result = manageUsersAndGroups.deactivateUser(userInfo);
        } catch (Exception e) {
            DCSLogger.logError("❌ Exception during user deletion for '" + userInfo + "': " + e.getMessage(), e);
        }
        return result;
    }
}
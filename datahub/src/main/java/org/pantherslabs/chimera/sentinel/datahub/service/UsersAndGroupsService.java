package org.pantherslabs.chimera.sentinel.datahub.service;

import java.time.Instant;
import java.util.*;

import org.springframework.stereotype.Service;

import com.linkedin.common.AuditStamp;
import com.linkedin.common.UrnArray;
import com.linkedin.common.url.Url;
import com.linkedin.common.urn.CorpuserUrn;
import com.linkedin.common.urn.Urn;
import com.linkedin.data.template.StringArray;
import com.linkedin.identity.*;
import com.linkedin.mxe.MetadataChangeProposal;

import org.pantherslabs.chimera.sentinel.datahub.commons.EventEmitter;
import org.pantherslabs.chimera.sentinel.datahub.dto.EmitResult;
import org.pantherslabs.chimera.sentinel.datahub.dto.Users;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

import static org.pantherslabs.chimera.sentinel.datahub.Constants.*;
import static org.pantherslabs.chimera.sentinel.datahub.commons.commonsFunctions.*;

@Service
public class UsersAndGroupsService {
    static ChimeraLogger logger = ChimeraLoggerFactory.getLogger(UsersAndGroupsService.class);
    static List<MetadataChangeProposal> proposals = new ArrayList<>();
    EmitResult result;

    /**
     * this Service Class will be used to Create or Edit User
     *
     * @param userInfo   user Information
     * @param changeType CREATE/UPSERT
     * @return
     * @throws Exception
     */
    public EmitResult createOrEditUsers(List<Users> userInfo, String changeType) throws Exception {
        for (Users info : userInfo) {
            // Basic validations
            Objects.requireNonNull(info.getEmail(), "User Email must not be null!");
            Objects.requireNonNull(info.getFirstName(), "FirstName must not be null!");
            Objects.requireNonNull(info.getLastName(), "LastName must not be null!");

            // User URN
            CorpuserUrn userUrn = CorpuserUrn.createFromString(URN_LI_CORP_USER_PREFIX + info.getEmail());

            //Build CorpUserInfo
            CorpUserInfo corpUserInfo = new CorpUserInfo();
            corpUserInfo.setActive(getOrElse(info.getActive(), true));
            corpUserInfo.setCountryCode(getOrElse(info.getCountryCode(), "+91"));
            corpUserInfo.setDepartmentId(getOrElse(info.getDepartmentId(), 0L));
            corpUserInfo.setDepartmentName(getOrElse(info.getDepartmentName(), "Not Specified"));
            corpUserInfo.setEmail(info.getEmail());
            corpUserInfo.setDisplayName(getOrElse(info.getDisplayName(), info.getLastName() + ", " + info.getFirstName()));
            corpUserInfo.setFirstName(getOrElse(info.getFirstName(), "-"));
            corpUserInfo.setLastName(getOrElse(info.getLastName(), "-"));
            corpUserInfo.setFullName(info.getLastName() + info.getFirstName());
            corpUserInfo.setTitle(getOrElse(info.getTitle(), "Read Only User"));
            proposals.add(buildProposal(userUrn, "corpUserInfo", corpUserInfo, changeType));

            // AuditStamp
            AuditStamp createdStamp = new AuditStamp()
                    .setActor(new CorpuserUrn(DATAHUB_ACTOR))
                    .setImpersonator(userUrn)
                    .setMessage("Created Audit Timestamp")
                    .setTime(Instant.now().toEpochMilli());

            // Platforms
            UrnArray platform = new UrnArray();
            List<String> platformNames = info.getPlatform();
            if (platformNames != null && !platformNames.isEmpty()) {
                for (String platformName : platformNames) {
                    platform.add(Urn.createFromString(DATA_PLATFORM_PREFIX + platformName));
                }
            } else {
                platform.add(Urn.createFromString(UNKNOWN_DATA_PLATFORM));
            }

            // Skills
            StringArray skills = new StringArray();
            if (info.getSkills() != null) skills.addAll(info.getSkills());
            else skills.add("default");

            // Teams
            StringArray teams = new StringArray();
            if (info.getTeams() != null) teams.addAll(info.getTeams());
            else teams.add("default");

            // CorpUserEditableInfo
            CorpUserEditableInfo corpUserEditableInfo = new CorpUserEditableInfo()
                    .setAboutMe(getOrElse(info.getAboutMe(), "About Me ??"))
                    .setPhone(getOrElse(info.getPhone(), "99999-99999"))
                    .setPictureLink(new Url(getOrElse(info.getPictureLink(), PROFILE)))
                    .setPlatforms(platform)
                    .setSkills(skills)
                    .setSlack(getOrElse(info.getSlack(), "My Slack"))
                    .setTeams(teams);
            proposals.add(buildProposal(userUrn, CORP_USER_EDITABLE_INFO_ASPECT_NAME, corpUserEditableInfo, changeType));

            // CorpUserStatus
            CorpUserStatus corpUserStatus = new CorpUserStatus();
            corpUserStatus.setStatus(CORP_USER_STATUS_ACTIVE);
            corpUserStatus.setLastModified(createdStamp);
            proposals.add(buildProposal(userUrn, CORP_USER_STATUS_ASPECT_NAME, corpUserStatus, changeType));

            // RoleMembership
            UrnArray roleMembershipArray = new UrnArray();
            roleMembershipArray.add(Urn.createFromString(DATA_PLATFORM_READ_ROLE));
            RoleMembership roleMembership = new RoleMembership().setRoles(roleMembershipArray);
            proposals.add(buildProposal(userUrn, ROLE_MEMBERSHIP_ASPECT_NAME, roleMembership, changeType));

            // CorpUserCredentials
            CorpUserCredentials corpUserCredentials = new CorpUserCredentials();
            final byte[] salt = generateSalt(SALT_TOKEN_LENGTH);
            String encryptedSalt = encrypt(Base64.getEncoder().encodeToString(salt));
            String hashedPassword = getHashedPassword(salt, DEFAULT_USER_PASSWORD);
            corpUserCredentials.setSalt(encryptedSalt);
            corpUserCredentials.setHashedPassword(hashedPassword);
            proposals.add(buildProposal(userUrn, CORP_USER_CREDENTIALS_ASPECT_NAME, corpUserCredentials, changeType));

            // NativeGroupMembership
            UrnArray nativeGroups = new UrnArray();
            if (info.getNativeGroups() != null) {
                for (String urnStr : info.getNativeGroups()) {
                    nativeGroups.add(Urn.createFromString(CORP_GROUP_PREFIX + urnStr));
                }
            } else {
                nativeGroups.add(Urn.createFromString(CORP_GROUP_PREFIX + "default"));
            }
            NativeGroupMembership nativeGroupMembership = new NativeGroupMembership().setNativeGroups(nativeGroups);
            proposals.add(buildProposal(userUrn, NATIVE_GROUP_MEMBERSHIP_ASPECT_NAME, nativeGroupMembership, changeType));

            // GroupMembership
            UrnArray groups = new UrnArray();
            if (info.getGroupsMembership() != null) {
                for (String urnStr : info.getGroupsMembership()) {
                    groups.add(Urn.createFromString(CORP_GROUP_PREFIX + urnStr));
                }
            } else {
                groups.add(Urn.createFromString(CORP_GROUP_PREFIX + "default"));
            }
            GroupMembership groupMembership = new GroupMembership().setGroups(groups);
            proposals.add(buildProposal(userUrn, GROUP_MEMBERSHIP_ASPECT_NAME, groupMembership, changeType));

            // Emit with rollback
            EventEmitter txEmitter = new EventEmitter();
            result = txEmitter.emitWithRollback(proposals);
        }
        return result;
    }

    /**
     * this api wll be used to deactivate any user
     *
     * @param userEmail http://localhost:8080/api/users/deactivate?userName=john.doe@example.com
     * @return
     */
    public EmitResult deactivateUser(String userEmail) {
        List<MetadataChangeProposal> proposals = new ArrayList<>();
        try {
            if (userEmail == null || userEmail.isBlank()) {
                throw new IllegalArgumentException("Username cannot be null or blank.");
            }

            String userUrnStr = URN_LI_CORP_USER_PREFIX + userEmail;
            Urn userUrn = Urn.createFromString(userUrnStr);

            AuditStamp LastModified = new AuditStamp()
                    .setActor(new CorpuserUrn(DATAHUB_ACTOR))
                    .setImpersonator(userUrn)
                    .setMessage("Created Audit Timestamp")
                    .setTime(Instant.now().toEpochMilli());

            CorpUserStatus corpUserStatus = new CorpUserStatus()
                    .setStatus(CORP_USER_STATUS_SUSPENDED)
                    .setLastModified(LastModified);

            proposals.add(buildProposal(userUrn, CORP_USER_STATUS_ASPECT_NAME, corpUserStatus, UPSERT_ACTION_TYPE));

            // Emit with rollback support
            EventEmitter txEmitter = new EventEmitter();
            EmitResult result = txEmitter.emitWithRollback(proposals);

            if (result.isSuccess()) {
                logger.logInfo("✅ User soft-deleted successfully: " + userEmail + result.getSucceeded());
            } else {
                logger.logError("❌ Soft delete failed and rollback triggered for user: " + userEmail);
            }

        } catch (IllegalArgumentException e) {
            logger.logError("⚠️ Invalid input: " + e.getMessage());
        } catch (Exception e) {
            logger.logError("❌ Exception during user deletion for '" + userEmail + "': " + e.getMessage(), e);
        }
        return result;
    }
}
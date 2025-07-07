package org.pantherslabs.chimera.sentinel.data_api.service;

import java.sql.Timestamp;
import org.apache.ibatis.exceptions.PersistenceException;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.pantherslabs.chimera.sentinel.data_api.mapper.generated.DataControlsMapper;
import org.pantherslabs.chimera.sentinel.data_api.model.generated.DataControls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.mybatis.dynamic.sql.SqlBuilder.select;
import static org.pantherslabs.chimera.sentinel.data_api.mapper.generated.DataControlsDynamicSqlSupport.dataControls;

@Service
public class DataControlsService {
    static ChimeraLogger DCSLogger = ChimeraLoggerFactory.getLogger(DataControlsService.class);

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String currentUsername = (authentication != null) ? authentication.getName() : System.getProperty("user.name");

    @Autowired
    private DataControlsMapper dataControlsMapper;

    public DataControls getControlById(Short id) {
        DCSLogger.logInfo("Getting Data Control for " + id);
        return dataControlsMapper.selectByPrimaryKey(id)
                .orElseThrow(() -> new ChimeraException("APIException.404",
                        Map.of("exception", "Control Id " + id.toString() + " Not Found"),
                        null,
                        HttpStatus.NOT_FOUND));
    }

    public List<DataControls> getAllControls() {
        DCSLogger.logInfo("Getting All List of Data Controls");
        try {
            SelectStatementProvider selectStatement = select(DataControlsMapper.selectList)
                    .from(dataControls)
                    .build()
                    .render(RenderingStrategies.MYBATIS3);

            List<DataControls> controls = dataControlsMapper.selectMany(selectStatement);

            if (controls == null || controls.isEmpty()) {
                DCSLogger.logWarning("No data controls found.");
                throw new ChimeraException(
                        "APIException.404",
                        Map.of("exception", "No data controls found"),
                        null,
                        HttpStatus.NO_CONTENT
                );
            }
            DCSLogger.logInfo(String.format("Total %s Data Controls Found",controls.size()));
            return controls;
        }
        catch (Exception e) {
            DCSLogger.logError("Unexpected error while retrieving data controls: " + e.getMessage());
            throw new ChimeraException(
                    "APIException.500",
                    Map.of("exception", e.getMessage()),
                    null,
                    HttpStatus.EXPECTATION_FAILED
            );
        }
    }

    public DataControls createControl(DataControls control) {
        DCSLogger.logInfo("Creating a new DataControl record");
        try {
            if (control == null) {
                DCSLogger.logWarning("Attempted to create a null DataControl");
                throw new ChimeraException(
                        "APIException.400",
                        Map.of("exception", "Provided DataControl object is null"),
                        null,
                        HttpStatus.PRECONDITION_FAILED
                );
            }

            control.setCreatedTs(new Timestamp(System.currentTimeMillis()));
            control.setCreatedBy(currentUsername);

            int rowsInserted = dataControlsMapper.insert(control);

            if (rowsInserted == 0) {
                DCSLogger.logError("Insert attempted but no rows were affected.");
                throw new ChimeraException(
                        "APIException.500",
                        Map.of("exception", "Insert returned 0 rows affected — possible constraint or logic issue"),
                        null,
                        HttpStatus.CONFLICT
                );
            }

            DCSLogger.logInfo("DataControl created successfully with ID: " + control.getControlId());
            return control;

        } catch (PersistenceException  e) {
            // These catch DB-level exceptions like constraint violations, bad SQL, etc.
            DCSLogger.logError("Database error while inserting DataControl: " + e.getMessage(), e);
            throw new ChimeraException(
                    "APIException.500",
                    Map.of("exception", "Database error: " + e.getMessage()),
                    null,
                    HttpStatus.NOT_ACCEPTABLE
            );

        } catch (ChimeraException e) {
            throw e;

        } catch (Exception e) {
            DCSLogger.logError("Unexpected error while creating DataControl: " + e.getMessage(), e);
            throw new ChimeraException(
                    "APIException.500",
                    Map.of("exception", "Unexpected error while creating DataControl " + e.getMessage()),
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    public DataControls updateControl(Short id, DataControls updatedControl) {
        DCSLogger.logInfo("Updating DataControl with ID: " + id);

        try {
            Optional<DataControls> existing = dataControlsMapper.selectByPrimaryKey(id);

            if (existing.isEmpty()) {
                DCSLogger.logWarning("DataControl with ID " + id + " not found for update.");
                throw new ChimeraException(
                        "APIException.404",
                        Map.of("exception", "DataControl with ID " + id + " not found"),
                        null,
                        HttpStatus.NOT_FOUND
                );
            }

            updatedControl.setControlId(id);
            updatedControl.setUpdatedBy(currentUsername);
            updatedControl.setUpdatedTs(new Timestamp(System.currentTimeMillis()));

            int rowsUpdated = dataControlsMapper.updateByPrimaryKeySelective(updatedControl);

            if (rowsUpdated == 0) {
                DCSLogger.logError("Update failed: No rows affected for ID " + id);
                throw new ChimeraException(
                        "APIException.500",
                        Map.of("exception", "Failed to update DataControl with ID " + id),
                        null,
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }

            DCSLogger.logInfo("DataControl with ID " + id + " updated successfully.");
            return getControlById(id);

        } catch (PersistenceException e) {
            DCSLogger.logError("Database error during update: " + e.getMessage(), e);
            throw new ChimeraException(
                    "APIException.500",
                    Map.of("exception", "Database error during update: " + e.getMessage()),
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );

        } catch (ChimeraException e) {
            throw e;

        } catch (Exception e) {
            DCSLogger.logError("Unexpected error during update: " + e.getMessage(), e);
            throw new ChimeraException(
                    "APIException.500",
                    Map.of("exception", "Unexpected error while updating DataControl " + e.getMessage()),
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    public boolean deleteControl(Short id) {
        DCSLogger.logInfo("Attempting to delete DataControl with ID: " + id);

        try {
            Optional<DataControls> existing = dataControlsMapper.selectByPrimaryKey(id);

            if (existing.isEmpty()) {
                DCSLogger.logWarning("DataControl with ID " + id + " not found for deletion.");
                throw new ChimeraException(
                        "APIException.404",
                        Map.of("exception", "DataControl with ID " + id + " not found"),
                        null,
                        HttpStatus.NOT_FOUND
                );
            }

            int rowsDeleted = dataControlsMapper.deleteByPrimaryKey(id);

            if (rowsDeleted == 0) {
                DCSLogger.logError("Deletion failed: No rows affected for ID " + id);
                throw new ChimeraException(
                        "APIException.500",
                        Map.of("exception", "Failed to delete DataControl with ID " + id),
                        null,
                        HttpStatus.INTERNAL_SERVER_ERROR
                );
            }

            DCSLogger.logInfo("DataControl with ID " + id + " deleted successfully.");
            return true;

        } catch (PersistenceException e) {
            DCSLogger.logError("Database error during delete: " + e.getMessage(), e);
            throw new ChimeraException(
                    "APIException.500",
                    Map.of("exception", "Database error during delete: " + e.getMessage()),
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );

        } catch (ChimeraException e) {
            throw e;

        } catch (Exception e) {
            DCSLogger.logError("Unexpected error during delete: " + e.getMessage(), e);
            throw new ChimeraException(
                    "APIException.500",
                    Map.of("exception", "Unexpected error while deleting DataControl " + e.getMessage()),
                    null,
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

}
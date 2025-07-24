package org.pantherslabs.chimera.sentinel.datahub.api.exception;
import jakarta.servlet.http.HttpServletRequest;
import org.pantherslabs.chimera.unisca.exception.ChimeraException;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    ChimeraLogger APILogger = ChimeraLoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ChimeraException.class)
    public ResponseEntity<Object> handleChimeraException(ChimeraException ex, HttpServletRequest request) {
        String fullMessage = ex.getMessage();
        String errorType = null;
        String errorCode = null;
        String errorMessage = null;

        APILogger.logError("Exception Details");

        if (fullMessage != null && fullMessage.startsWith("[")) {
            int closingBracket = fullMessage.indexOf(']');
            if (closingBracket > 0) {
                String meta = fullMessage.substring(1, closingBracket);
                String[] parts = meta.split("\\.");
                if (parts.length == 2) {
                    errorType = parts[0];
                    errorCode = parts[1];
                }
                errorMessage = fullMessage.substring(closingBracket + 1).trim();
            }
        }

        String errorTemplate = String.format(
                "Error Code    : %s\n" +
                        "Error Type    : %s\n" +
                        "Error Message : %s\n" +
                        "Error StackTrace:\n%s",
                errorCode, errorType, errorMessage, Arrays.toString(ex.getStackTrace())
        );
        APILogger.logError(errorTemplate);

        Map<String, Object> body = new HashMap<>();
        body.put("errorCode", errorCode);
        body.put("errorType", errorType);
        body.put("errorMessage", errorMessage);
        body.put("errorRequestURI", request.getRequestURI());
        body.put("errorTimestamp", Instant.now());

        return new ResponseEntity<>(body, ex.getHttpStatus());
    }

    @ExceptionHandler({
            SQLException.class,
            BadSqlGrammarException.class,
            InvalidDataAccessResourceUsageException.class,
            DataAccessException.class
    })
    public ResponseEntity<Object> handleDatabaseExceptions(Exception ex, HttpServletRequest request) {
        APILogger.logError("Database error occurred: " + ex.getMessage(), ex);

        Map<String, Object> body = new HashMap<>();
        body.put("errorType", "DatabaseError");
        body.put("errorCode", "DB-500");
        body.put("errorMessage", ex.getMessage());
        body.put("errorRequestURI", request.getRequestURI());
        body.put("errorTimestamp", Instant.now());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGenericException(Exception ex, HttpServletRequest request) {
        APILogger.logError("Unhandled exception occurred: " + ex.getMessage(), ex);

        Map<String, Object> body = new HashMap<>();
        body.put("errorType", "InternalError");
        body.put("errorCode", "GEN-500");
        body.put("errorMessage", ex.getMessage());
        body.put("errorRequestURI", request.getRequestURI());
        body.put("errorTimestamp", Instant.now());

        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
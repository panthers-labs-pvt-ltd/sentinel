package org.pantherslabs.chimera.sentinel.datahub.referances;

import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

public interface SharedLogger {

    String SYSTEM_USER = "Chimera";
    ChimeraLogger DatahubLogger = ChimeraLoggerFactory.getLogger(SharedLogger.class);

}

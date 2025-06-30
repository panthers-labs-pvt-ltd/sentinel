package org.pantherslabs.chimera.sentinel.datalineage;


import org.pantherslabs.chimera.sentinel.datalineage.transports.OpenLineageTransportTypes;
import org.pantherslabs.chimera.unisca.logging.ChimeraLogger;
import org.pantherslabs.chimera.unisca.logging.ChimeraLoggerFactory;

public interface SharedLogger {

    ChimeraLogger LineageLogger = ChimeraLoggerFactory.getLogger(OpenLineageTransportTypes.class);

}

package org.pantherslabs.chimera.sentinel.dataquality.engine;

import org.pantherslabs.chimera.sentinel.dataquality.controls.DataControls;
import org.apache.arrow.vector.VectorSchemaRoot;

import java.util.List;

public interface Engine {
    void process(VectorSchemaRoot arrowDataFrame, List<DataControls> dataControlsList);
}
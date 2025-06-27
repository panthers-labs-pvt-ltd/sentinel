package org.pantherslabs.chimera.sentinel.dataquality.service;

import org.pantherslabs.chimera.sentinel.dataquality.entities.DQRulesEntity;
import org.pantherslabs.chimera.sentinel.dataquality.entities.DataControlsEntity;
import org.pantherslabs.chimera.utilities.ChimeraDataFrame;
import org.pantherslabs.chimera.utilities.Engine;

import java.util.ArrayList;
import java.util.List;

public class DetailedDQService {

    // Inject DataFrame within DetailedDQService
    private ChimeraDataFrame dataFrame;
    private Engine engine;

    public DetailedDQService(ChimeraDataFrame dataFrame, Engine engine) {
        this.dataFrame = dataFrame;
        this.engine = engine;
    }

    // This method is not implemented yet.
    /**
     * Performs detailed data quality checks.
     */
    public void performDetailedDQ() {
    }

    // This method is not implemented yet.
    /**
     * Fetches detailed data quality controls.
     * @return List of detailed data quality controls.
     */
    public List<DataControlsEntity> getDetailedDQControls() {
        return new ArrayList<>();
    }

    // This method is not implemented yet.
    /**
     * Fetches detailed data quality rules.
     * @return List of detailed data quality rules.
     */
    public List<DQRulesEntity> getDetailedDQRules() {
        return new ArrayList<>();
    }

    // This method is not implemented yet.
    /**
     * Updates detailed data quality rules.
     * @param dqRuleEntities List of detailed data quality rules.
     */
    public void updateDetailedDQRules(List<DQRulesEntity> dqRuleEntities) {
    }
}

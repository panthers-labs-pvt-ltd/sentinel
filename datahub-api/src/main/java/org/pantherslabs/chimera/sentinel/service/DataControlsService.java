package org.pantherslabs.chimera.sentinel.service;

import org.pantherslabs.chimera.sentinel.mapper.generated.DataControlsMapper;
import org.pantherslabs.chimera.sentinel.model.generated.DataControls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class DataControlsService {

    @Autowired
    private DataControlsMapper dataControlsMapper;

//    private final Map<Short, DataControls> controlsStore = new ConcurrentHashMap<>();
//
//    public List<DataControls> getAllControls() {
//        return new ArrayList<>(controlsStore.values());
//    }

//    public DataControls getControlById(Short id) {
//        return controlsStore.get(id);
//    }

    public DataControls getControlById(Short id) {
        return dataControlsMapper.selectByPrimaryKey(id).orElse(null);
    }

//    public DataControls createControl(DataControls dataControls) {
//        // Example: generate controlId if null
//        if (dataControls.getControlId() == null) {
//            short newId = (short) (controlsStore.size() + 1);
//            dataControls.setControlId(newId);
//        }
//        dataControls.setCreatedTs(new Date());
//        controlsStore.put(dataControls.getControlId(), dataControls);
//        return dataControls;
//    }
//
//    public DataControls updateControl(Short id, DataControls dataControls) {
//        DataControls existing = controlsStore.get(id);
//        if (existing == null) return null;
//        dataControls.setControlId(id);
//        dataControls.setUpdatedTs(new Date());
//        controlsStore.put(id, dataControls);
//        return dataControls;
//    }
//
//    public boolean deleteControl(Short id) {
//        return controlsStore.remove(id) != null;
//    }
}
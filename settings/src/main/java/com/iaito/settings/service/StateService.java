package com.iaito.settings.service;

import java.util.List;

import com.iaito.settings.dto.StateDTO;
import com.iaito.settings.model.State;

public interface StateService {
	
    public StateDTO getStateById(long stateId);
    public List<StateDTO> getAllStates();
    public StateDTO addState(State state);
    public StateDTO updateState(State state);
    public void deleteState(long stateId);

}

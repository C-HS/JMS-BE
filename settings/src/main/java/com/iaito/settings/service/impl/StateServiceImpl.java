package com.iaito.settings.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.settings.dto.StateDTO;
import com.iaito.settings.model.State;
import com.iaito.settings.repository.StateRepository;
import com.iaito.settings.service.StateService;

@Service
public class StateServiceImpl implements StateService {
	
	Logger logger = LoggerFactory.getLogger(StateServiceImpl.class);
	
    @Autowired ModelMapper modelMapper;
	@Autowired StateRepository stateRepository;

	@Override
	public StateDTO getStateById(long stateId) {

		return modelMapper.map(stateRepository.findById(stateId).get(), StateDTO.class);
	}

	@Override
	public List<StateDTO> getAllStates() {

		return stateRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e,StateDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public StateDTO addState(State state) {

		state.setStatus("Active");
		
		return modelMapper.map(stateRepository.save(state), StateDTO.class);
	}

	@Override
	public StateDTO updateState(State state) {

		State stateToUpdate = stateRepository.findById(state.getStateId()).get();
		
		stateToUpdate.setStateName(state.getStateName());
		

		return modelMapper.map(stateRepository.save(stateToUpdate), StateDTO.class);
	}

	@Override
	public void deleteState(long stateId) {
		// TODO Auto-generated method stub
		
	}

}

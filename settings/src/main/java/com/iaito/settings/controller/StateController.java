package com.iaito.settings.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iaito.settings.dto.StateDTO;
import com.iaito.settings.model.State;
import com.iaito.settings.service.StateService;


@RestController
public class StateController {

	Logger logger = LoggerFactory.getLogger(StateController.class);
	@Autowired StateService stateService;
	
	@GetMapping(value = "/getState/{stateId}", produces = "application/json")
	public ResponseEntity<StateDTO> state(@PathVariable Long stateId) {
		return ResponseEntity.ok(stateService.getStateById(stateId));
	}
	@GetMapping(value = "/getAllStates", produces = "application/json")
	public ResponseEntity<List<StateDTO>> states() {
		return ResponseEntity.ok(stateService.getAllStates());
	}
	@PostMapping(value = "/addState", consumes = "application/json", produces = "application/json")
	public ResponseEntity<StateDTO> addState(@RequestBody State state) {
		return ResponseEntity.ok(stateService.addState(state));
	}
	@PutMapping(value = "/updateState", consumes = "application/json", produces = "application/json")
	public ResponseEntity<StateDTO> updateState(@RequestBody State state) {
		return ResponseEntity.ok(stateService.updateState(state));
	}
	@DeleteMapping(value = "/deleteState/{stateId}",produces = "application/json")
	public ResponseEntity<String> deleteState(@PathVariable Long stateId) {
		stateService.deleteState(stateId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}
}

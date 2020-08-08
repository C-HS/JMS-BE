package com.iaito.inventory.controller;

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

import com.iaito.inventory.dto.FacilityDTO;
import com.iaito.inventory.model.Facility;
import com.iaito.inventory.service.FacilityService;


@RestController
public class FacilityController {
	
	Logger logger = LoggerFactory.getLogger(FacilityController.class);
	@Autowired FacilityService facilityService;
	
	@GetMapping(value = "/getFacility/{facilityId}", produces = "application/json")
	public ResponseEntity<FacilityDTO> facility(@PathVariable Long facilityId) {
		return ResponseEntity.ok(facilityService.getFacilityById(facilityId));
	}
	@GetMapping(value = "/getAllFacilities", produces = "application/json")
	public ResponseEntity<List<FacilityDTO>> facilities() {
		return ResponseEntity.ok(facilityService.getAllFacilities());
	}
	@PostMapping(value = "/addFacility", consumes = "application/json", produces = "application/json")
	public ResponseEntity<FacilityDTO> addFacility(@RequestBody Facility facility) {
		return ResponseEntity.ok(facilityService.addFacility(facility));
	}
	@PutMapping(value = "/updateFacility", consumes = "application/json", produces = "application/json")
	public ResponseEntity<FacilityDTO> updateFacility(@RequestBody Facility facility) {
		return ResponseEntity.ok(facilityService.updateFacility(facility));
	}
	@DeleteMapping(value = "/deleteFacility/{facilityId}",produces = "application/json")
	public ResponseEntity<String> deleteFacility(@PathVariable Long facilityId) {
		facilityService.deleteFacility(facilityId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

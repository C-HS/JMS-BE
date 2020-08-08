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

import com.iaito.inventory.dto.LocationDTO;
import com.iaito.inventory.model.Location;
import com.iaito.inventory.service.LocationService;

@RestController
public class LocationController {
	
	Logger logger = LoggerFactory.getLogger(LocationController.class);
	@Autowired LocationService locationService;
	
	@GetMapping(value = "/getLocation/{locationId}", produces = "application/json")
	public ResponseEntity<LocationDTO> location(@PathVariable Long locationId) {
		return ResponseEntity.ok(locationService.getLocationById(locationId));
	}
	@GetMapping(value = "/getAllLocations", produces = "application/json")
	public ResponseEntity<List<LocationDTO>> locations() {
		return ResponseEntity.ok(locationService.getAllLocations());
	}
	@PostMapping(value = "/addLocation", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LocationDTO> addLocation(@RequestBody Location location) {
		return ResponseEntity.ok(locationService.addLocation(location));
	}
	@PutMapping(value = "/updateLocation", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LocationDTO> updateLocation(@RequestBody Location location) {
		return ResponseEntity.ok(locationService.updateLocation(location));
	}
	@DeleteMapping(value = "/deleteLocation/{locationId}",produces = "application/json")
	public ResponseEntity<String> deleteLocation(@PathVariable Long locationId) {
		locationService.deleteLocation(locationId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

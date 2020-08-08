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

import com.iaito.settings.dto.CountryDTO;
import com.iaito.settings.model.Country;
import com.iaito.settings.service.CountryService;


@RestController
public class CountryController {
	
	Logger logger = LoggerFactory.getLogger(CountryController.class);
	@Autowired CountryService countryService;
	
	@GetMapping(value = "/getCountry/{countryId}", produces = "application/json")
	public ResponseEntity<CountryDTO> country(@PathVariable Long countryId) {
		return ResponseEntity.ok(countryService.getCountryById(countryId));
	}
	@GetMapping(value = "/getAllCountries", produces = "application/json")
	public ResponseEntity<List<CountryDTO>> countries() {
		return ResponseEntity.ok(countryService.getAllCountries());
	}
	@PostMapping(value = "/addCountry", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CountryDTO> addCountry(@RequestBody Country country) {
		return ResponseEntity.ok(countryService.addCountry(country));
	}
	@PutMapping(value = "/updateCountry", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CountryDTO> updateCountry(@RequestBody Country country) {
		return ResponseEntity.ok(countryService.updateCountry(country));
	}
	@DeleteMapping(value = "/deleteCountry/{countryId}",produces = "application/json")
	public ResponseEntity<String> deleteCountry(@PathVariable Long countryId) {
		countryService.deleteCountry(countryId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

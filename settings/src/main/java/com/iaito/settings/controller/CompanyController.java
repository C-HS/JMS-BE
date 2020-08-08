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

import com.iaito.settings.dto.CompanyDTO;
import com.iaito.settings.model.Company;
import com.iaito.settings.service.CompanyService;


@RestController
public class CompanyController {
	
	Logger logger = LoggerFactory.getLogger(CompanyController.class);
	@Autowired CompanyService companyService;
	
	@GetMapping(value = "/getCompany/{companyId}", produces = "application/json")
	public ResponseEntity<CompanyDTO> company(@PathVariable Long companyId) {
		return ResponseEntity.ok(companyService.getCompanyById(companyId));
	}
	@GetMapping(value = "/getAllCompanies", produces = "application/json")
	public ResponseEntity<List<CompanyDTO>> companies() {
		return ResponseEntity.ok(companyService.getAllCompanies());
	}
	@PostMapping(value = "/addCompany", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CompanyDTO> addCompany(@RequestBody Company company) {
		return ResponseEntity.ok(companyService.addCompany(company));
	}
	@PutMapping(value = "/updateCompany", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CompanyDTO> updateCompany(@RequestBody Company company) {
		return ResponseEntity.ok(companyService.updateCompany(company));
	}
	@DeleteMapping(value = "/deleteCompany/{companyId}",produces = "application/json")
	public ResponseEntity<String> deleteCompany(@PathVariable Long companyId) {
		companyService.deleteCompany(companyId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}


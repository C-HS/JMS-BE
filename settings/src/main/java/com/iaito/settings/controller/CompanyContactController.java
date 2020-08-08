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

import com.iaito.settings.dto.CompanyContactDTO;
import com.iaito.settings.model.CompanyContact;
import com.iaito.settings.service.CompanyContactService;



@RestController
public class CompanyContactController {
	
	Logger logger = LoggerFactory.getLogger(CompanyContactController.class);
	@Autowired CompanyContactService companyContactService;
	
	@GetMapping(value = "/getCompanyContact/{companyContactId}", produces = "application/json")
	public ResponseEntity<CompanyContactDTO> companyContact(@PathVariable Long companyContactId) {
		return ResponseEntity.ok(companyContactService.getCompanyContactById(companyContactId));
	}
	@GetMapping(value = "/getAllCompanyContacts", produces = "application/json")
	public ResponseEntity<List<CompanyContactDTO>> companyContacts() {
		return ResponseEntity.ok(companyContactService.getAllCompanyContacts());
	}
	@PostMapping(value = "/addCompanyContact", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CompanyContactDTO> addCompanyContact(@RequestBody CompanyContact companyContact) {
		return ResponseEntity.ok(companyContactService.addCompanyContact(companyContact));
	}
	@PutMapping(value = "/updateCompanyContact", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CompanyContactDTO> updateCompanyContact(@RequestBody CompanyContact companyContact) {
		return ResponseEntity.ok(companyContactService.updateCompanyContact(companyContact));
	}
	@DeleteMapping(value = "/deleteCompanyContact/{companyContactId}",produces = "application/json")
	public ResponseEntity<String> deleteCompanyContact(@PathVariable Long companyContactId) {
		companyContactService.deleteCompanyContact(companyContactId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

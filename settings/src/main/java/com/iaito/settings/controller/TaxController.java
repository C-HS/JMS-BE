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

import com.iaito.settings.dto.TaxDTO;
import com.iaito.settings.model.Tax;
import com.iaito.settings.service.TaxService;


@RestController
public class TaxController {
	
	Logger logger = LoggerFactory.getLogger(TaxController.class);
	@Autowired TaxService taxService;
	
	@GetMapping(value = "/getTax/{taxId}", produces = "application/json")
	public ResponseEntity<TaxDTO> tax(@PathVariable Long taxId) {
		return ResponseEntity.ok(taxService.getTaxById(taxId));
	}
	@GetMapping(value = "/getAllTaxes", produces = "application/json")
	public ResponseEntity<List<TaxDTO>> taxes() {
		return ResponseEntity.ok(taxService.getAllTaxes());
	}
	@PostMapping(value = "/addTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<TaxDTO> addTax(@RequestBody Tax tax) {
		return ResponseEntity.ok(taxService.addTax(tax));
	}
	@PutMapping(value = "/updateTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<TaxDTO> updateTax(@RequestBody Tax tax) {
		return ResponseEntity.ok(taxService.updateTax(tax));
	}
	@DeleteMapping(value = "/deleteTax/{taxId}",produces = "application/json")
	public ResponseEntity<String> deleteTax(@PathVariable Long taxId) {
		taxService.deleteTax(taxId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

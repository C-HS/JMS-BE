package com.iaito.accounting.controller;

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

import com.iaito.accounting.dto.BillProductTaxDTO;
import com.iaito.accounting.model.BillProductTax;
import com.iaito.accounting.service.BillProductTaxService;

@RestController
public class BillProductTaxController {
	
    Logger logger = LoggerFactory.getLogger(BillProductTaxController.class);
    
    @Autowired BillProductTaxService billProductTaxService;
    
    
    @GetMapping(value = "/getAllBillProductTaxes", produces = "application/json")
	public ResponseEntity<List<BillProductTaxDTO>> billProductTaxes() {
		return ResponseEntity.ok(billProductTaxService.getAllBillProductTaxes());
	}
    
    
    @GetMapping(value = "/getBillProductTax/{billProductTaxId}", produces = "application/json")
	public ResponseEntity<BillProductTaxDTO> billProductTax(@PathVariable Long billProductTaxId) {
		return ResponseEntity.ok(billProductTaxService.getBillProductTaxById(billProductTaxId));
	}
    
    @PostMapping(value = "/addBillProductTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BillProductTaxDTO> addBillProductTax(@RequestBody BillProductTax billProductTax) {
		return ResponseEntity.ok(billProductTaxService.addBillProductTax(billProductTax));
	}
    
	@PutMapping(value = "/updateBillProductTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BillProductTaxDTO> updateBillProductTax(@RequestBody BillProductTax billProductTax) {
		return ResponseEntity.ok(billProductTaxService.updateBillProductTax(billProductTax));
	}
	
	@DeleteMapping(value = "/deleteBillProductTax/{billProductTaxId}",produces = "application/json")
	public ResponseEntity<String> deleteBillProductTax(@PathVariable Long billProductTaxId) {
		billProductTaxService.deleteBillProductTax(billProductTaxId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

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

import com.iaito.accounting.dto.InvoiceProductTaxDTO;
import com.iaito.accounting.model.InvoiceProductTax;
import com.iaito.accounting.service.InvoiceProductTaxService;

@RestController
public class InvoiceProductTaxController {
	
    Logger logger = LoggerFactory.getLogger(InvoiceProductTaxController.class);
    
    @Autowired InvoiceProductTaxService invoiceProductTaxService;
    
    @GetMapping(value = "/getAllInvoiceProductTaxes", produces = "application/json")
	public ResponseEntity<List<InvoiceProductTaxDTO>> invoiceProductTaxes() {
		return ResponseEntity.ok(invoiceProductTaxService.getAllInvoiceProductTaxes());
	}
    
    
    @GetMapping(value = "/getInvoiceProductTax/{invoiceProductTaxId}", produces = "application/json")
	public ResponseEntity<InvoiceProductTaxDTO> invoiceProductTax(@PathVariable Long invoiceProductTaxId) {
		return ResponseEntity.ok(invoiceProductTaxService.getInvoiceProductTaxById(invoiceProductTaxId));
	}
    
    @PostMapping(value = "/addInvoiceProductTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InvoiceProductTaxDTO> addInvoiceProductTax(@RequestBody InvoiceProductTax invoiceProductTax) {
		return ResponseEntity.ok(invoiceProductTaxService.addInvoiceProductTax(invoiceProductTax));
	}
    
	@PutMapping(value = "/updateInvoiceProductTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InvoiceProductTaxDTO> updateInvoiceProductTax(@RequestBody InvoiceProductTax invoiceProductTax) {
		return ResponseEntity.ok(invoiceProductTaxService.updateInvoiceProductTax(invoiceProductTax));
	}
	
	@DeleteMapping(value = "/deleteInvoiceProductTax/{invoiceProductTaxId}",produces = "application/json")
	public ResponseEntity<String> deleteInvoiceProductTax(@PathVariable Long invoiceProductTaxId) {
		invoiceProductTaxService.deleteInvoiceProductTax(invoiceProductTaxId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

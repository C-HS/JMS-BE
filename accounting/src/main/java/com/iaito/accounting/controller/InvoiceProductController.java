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

import com.iaito.accounting.dto.InvoiceProductDTO;
import com.iaito.accounting.model.InvoiceProduct;
import com.iaito.accounting.service.InvoiceProductService;

@RestController
public class InvoiceProductController {
	
    Logger logger = LoggerFactory.getLogger(InvoiceProductController.class);
    
    @Autowired InvoiceProductService invoiceProductService;
    
    @GetMapping(value = "/getAllInvoiceProducts", produces = "application/json")
	public ResponseEntity<List<InvoiceProductDTO>> invoiceProducts() {
		return ResponseEntity.ok(invoiceProductService.getAllInvoiceProducts());
	}
    
    
    @GetMapping(value = "/getInvoiceProduct/{invoiceProductId}", produces = "application/json")
	public ResponseEntity<InvoiceProductDTO> invoiceProduct(@PathVariable Long invoiceProductId) {
		return ResponseEntity.ok(invoiceProductService.getInvoiceProductById(invoiceProductId));
	}
    
    @PostMapping(value = "/addInvoiceProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InvoiceProductDTO> addInvoiceProduct(@RequestBody InvoiceProduct invoiceProduct) {
		return ResponseEntity.ok(invoiceProductService.addInvoiceProduct(invoiceProduct));
	}
    
	@PutMapping(value = "/updateInvoiceProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InvoiceProductDTO> updateInvoiceProduct(@RequestBody InvoiceProduct invoiceProduct) {
		return ResponseEntity.ok(invoiceProductService.updateInvoiceProduct(invoiceProduct));
	}
	
	@DeleteMapping(value = "/deleteInvoiceProduct/{invoiceProductId}",produces = "application/json")
	public ResponseEntity<String> deleteInvoiceProduct(@PathVariable Long invoiceProductId) {
		invoiceProductService.deleteInvoiceProduct(invoiceProductId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

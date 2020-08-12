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

import com.iaito.accounting.dto.InvoiceDTO;
import com.iaito.accounting.model.Invoice;
import com.iaito.accounting.service.InvoiceService;

@RestController
public class InvoiceController {

    Logger logger = LoggerFactory.getLogger(InvoiceController.class);
    
    @Autowired InvoiceService invoiceService;
    
    @GetMapping(value = "/getAllInvoices", produces = "application/json")
	public ResponseEntity<List<InvoiceDTO>> invoices() {
		return ResponseEntity.ok(invoiceService.getAllInvoices());
	}
    
    
    @GetMapping(value = "/getInvoice/{invoiceId}", produces = "application/json")
	public ResponseEntity<InvoiceDTO> invoice(@PathVariable Long invoiceId) {
		return ResponseEntity.ok(invoiceService.getInvoiceById(invoiceId));
	}
    
    @PostMapping(value = "/addInvoice", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InvoiceDTO> addInvoice(@RequestBody Invoice invoice) {
		return ResponseEntity.ok(invoiceService.addInvoice(invoice));
	}
    
	@PutMapping(value = "/updateInvoice", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InvoiceDTO> updateInvoice(@RequestBody Invoice invoice) {
		return ResponseEntity.ok(invoiceService.updateInvoice(invoice));
	}
	
	@DeleteMapping(value = "/deleteInvoice/{invoiceId}",produces = "application/json")
	public ResponseEntity<String> deleteInvoice(@PathVariable Long invoiceId) {
		invoiceService.deleteInvoice(invoiceId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}
}

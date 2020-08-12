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

import com.iaito.accounting.dto.BillDTO;
import com.iaito.accounting.model.Bill;
import com.iaito.accounting.service.BillService;

@RestController
public class BillController {
	
    Logger logger = LoggerFactory.getLogger(BillController.class);
    
    @Autowired BillService billService;
    
    
    @GetMapping(value = "/getAllBills", produces = "application/json")
	public ResponseEntity<List<BillDTO>> bills() {
		return ResponseEntity.ok(billService.getAllBills());
	}
    
    
    @GetMapping(value = "/getBill/{billId}", produces = "application/json")
	public ResponseEntity<BillDTO> bill(@PathVariable Long billId) {
		return ResponseEntity.ok(billService.getBillById(billId));
	}
    
    @PostMapping(value = "/addBill", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BillDTO> addBill(@RequestBody Bill bill) {
		return ResponseEntity.ok(billService.addBill(bill));
	}
    
	@PutMapping(value = "/updateBill", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BillDTO> updateBill(@RequestBody Bill bill) {
		return ResponseEntity.ok(billService.updateBill(bill));
	}
	
	@DeleteMapping(value = "/deleteBill/{billId}",produces = "application/json")
	public ResponseEntity<String> deleteBill(@PathVariable Long billId) {
		billService.deleteBill(billId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

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

import com.iaito.accounting.dto.BillProductDTO;
import com.iaito.accounting.model.BillProduct;
import com.iaito.accounting.service.BillProductService;

@RestController
public class BillProductController {

    Logger logger = LoggerFactory.getLogger(BillProductController.class);
    
    @Autowired BillProductService billProductService;
    
    @GetMapping(value = "/getAllBillProducts", produces = "application/json")
	public ResponseEntity<List<BillProductDTO>> billProducts() {
		return ResponseEntity.ok(billProductService.getAllBillProducts());
	}
    
    
    @GetMapping(value = "/getBillProduct/{billProductId}", produces = "application/json")
	public ResponseEntity<BillProductDTO> billProduct(@PathVariable Long billProductId) {
		return ResponseEntity.ok(billProductService.getBillProductById(billProductId));
	}
    
    @PostMapping(value = "/addBillProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BillProductDTO> addBillProduct(@RequestBody BillProduct billProduct) {
		return ResponseEntity.ok(billProductService.addBillProduct(billProduct));
	}
    
	@PutMapping(value = "/updateBillProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<BillProductDTO> updateBillProduct(@RequestBody BillProduct billProduct) {
		return ResponseEntity.ok(billProductService.updateBillProduct(billProduct));
	}
	
	@DeleteMapping(value = "/deleteBillProduct/{billProductId}",produces = "application/json")
	public ResponseEntity<String> deleteBillProduct(@PathVariable Long billProductId) {
		billProductService.deleteBillProduct(billProductId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}
}

package com.iaito.order.controller.sales;

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

import com.iaito.order.dto.sales.SalesOrderProductTaxDTO;
import com.iaito.order.model.sales.SalesOrderProductTax;
import com.iaito.order.service.sales.SalesOrderProductTaxService;

@RestController
public class SalesOrderProductTaxController {
	
    Logger logger = LoggerFactory.getLogger(SalesOrderProductTaxController.class);
    
    @Autowired SalesOrderProductTaxService salesOrderProductTaxService;
    
    @GetMapping(value = "/getAllSalesOrderProductTaxes", produces = "application/json")
	public ResponseEntity<List<SalesOrderProductTaxDTO>> salesOrderProductTaxes() {
		return ResponseEntity.ok(salesOrderProductTaxService.getAllSalesOrderProductTaxes());
	}
    
    
    @GetMapping(value = "/getSalesOrderProductTax/{salesOrderProductTaxId}", produces = "application/json")
	public ResponseEntity<SalesOrderProductTaxDTO> salesOrderProductTax(@PathVariable Long salesOrderProductTaxId) {
		return ResponseEntity.ok(salesOrderProductTaxService.getSalesOrderProductTaxById(salesOrderProductTaxId));
	}
    
    @PostMapping(value = "/addSalesOrderProductTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SalesOrderProductTaxDTO> addSalesOrderProductTax(@RequestBody SalesOrderProductTax salesOrderProductTax) {
		return ResponseEntity.ok(salesOrderProductTaxService.addSalesOrderProductTax(salesOrderProductTax));
	}
    
	@PutMapping(value = "/updateSalesOrderProductTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SalesOrderProductTaxDTO> updateSalesOrderProductTax(@RequestBody SalesOrderProductTax salesOrderProductTax) {
		return ResponseEntity.ok(salesOrderProductTaxService.updateSalesOrderProductTax(salesOrderProductTax));
	}
	
	@DeleteMapping(value = "/deleteSalesOrderProductTax/{salesOrderProductTaxId}",produces = "application/json")
	public ResponseEntity<String> deleteSalesOrderProductTax(@PathVariable Long salesOrderProductTaxId) {
		salesOrderProductTaxService.deleteSalesOrderProductTax(salesOrderProductTaxId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

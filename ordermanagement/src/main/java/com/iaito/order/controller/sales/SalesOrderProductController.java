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

import com.iaito.order.dto.sales.SalesOrderProductDTO;
import com.iaito.order.model.sales.SalesOrderProduct;
import com.iaito.order.service.sales.SalesOrderProductService;

@RestController
public class SalesOrderProductController {
	
    Logger logger = LoggerFactory.getLogger(SalesOrderProductController.class);
    
    @Autowired SalesOrderProductService salesOrderProductService;
    
    @GetMapping(value = "/getAllSalesOrderProducts", produces = "application/json")
	public ResponseEntity<List<SalesOrderProductDTO>> salesOrderProducts() {
		return ResponseEntity.ok(salesOrderProductService.getAllSalesOrderProducts());
	}
    
    
    @GetMapping(value = "/getSalesOrderProduct/{salesOrderProductId}", produces = "application/json")
	public ResponseEntity<SalesOrderProductDTO> salesOrderProduct(@PathVariable Long salesOrderProductId) {
		return ResponseEntity.ok(salesOrderProductService.getSalesOrderProductById(salesOrderProductId));
	}
    
    @PostMapping(value = "/addSalesOrderProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SalesOrderProductDTO> addSalesOrderProduct(@RequestBody SalesOrderProduct salesOrderProduct) {
		return ResponseEntity.ok(salesOrderProductService.addSalesOrderProduct(salesOrderProduct));
	}
    
	@PutMapping(value = "/updateSalesOrderProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SalesOrderProductDTO> updateSalesOrderProduct(@RequestBody SalesOrderProduct salesOrderProduct) {
		return ResponseEntity.ok(salesOrderProductService.updateSalesOrderProduct(salesOrderProduct));
	}
	
	@DeleteMapping(value = "/deleteSalesOrderProduct/{salesOrderProductId}",produces = "application/json")
	public ResponseEntity<String> deleteSalesOrderProduct(@PathVariable Long salesOrderProductId) {
		salesOrderProductService.deleteSalesOrderProduct(salesOrderProductId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

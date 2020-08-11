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

import com.iaito.order.dto.sales.SalesOrderDTO;
import com.iaito.order.model.sales.SalesOrder;
import com.iaito.order.service.sales.SalesOrderService;


@RestController
public class SalesOrderController {
	
    Logger logger = LoggerFactory.getLogger(SalesOrderController.class);
    
    @Autowired SalesOrderService salesOrderService;
    
    @GetMapping(value = "/getAllSalesOrders", produces = "application/json")
	public ResponseEntity<List<SalesOrderDTO>> salesOrders() {
		return ResponseEntity.ok(salesOrderService.getAllSalesOrders());
	}
    
    
    @GetMapping(value = "/getSalesOrder/{salesOrderId}", produces = "application/json")
	public ResponseEntity<SalesOrderDTO> salesOrder(@PathVariable Long salesOrderId) {
		return ResponseEntity.ok(salesOrderService.getSalesOrderById(salesOrderId));
	}
    
    @PostMapping(value = "/addSalesOrder", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SalesOrderDTO> addSalesOrder(@RequestBody SalesOrder salesOrder) {
		return ResponseEntity.ok(salesOrderService.addSalesOrder(salesOrder));
	}
    
	@PutMapping(value = "/updateSalesOrder", consumes = "application/json", produces = "application/json")
	public ResponseEntity<SalesOrderDTO> updateSalesOrder(@RequestBody SalesOrder salesOrder) {
		return ResponseEntity.ok(salesOrderService.updateSalesOrder(salesOrder));
	}
	
	@DeleteMapping(value = "/deleteSalesOrder/{salesOrderId}",produces = "application/json")
	public ResponseEntity<String> deleteSalesOrder(@PathVariable Long salesOrderId) {
		salesOrderService.deleteSalesOrder(salesOrderId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

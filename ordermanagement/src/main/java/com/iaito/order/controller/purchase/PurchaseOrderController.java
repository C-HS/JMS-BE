package com.iaito.order.controller.purchase;

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

import com.iaito.order.dto.purchase.PurchaseOrderDTO;
import com.iaito.order.model.purchase.PurchaseOrder;
import com.iaito.order.service.purchase.PurchaseOrderService;

@RestController
public class PurchaseOrderController {
	
    Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);
    
    @Autowired PurchaseOrderService purchaseOrderService;
    
    @GetMapping(value = "/getAllPurchaseOrders", produces = "application/json")
	public ResponseEntity<List<PurchaseOrderDTO>> purchaseOrders() {
		return ResponseEntity.ok(purchaseOrderService.getAllPurchaseOrders());
	}
    
    
    @GetMapping(value = "/getPurchaseOrder/{purchaseOrderId}", produces = "application/json")
	public ResponseEntity<PurchaseOrderDTO> purchaseOrder(@PathVariable Long purchaseOrderId) {
		return ResponseEntity.ok(purchaseOrderService.getPurchaseOrderById(purchaseOrderId));
	}
    
    @PostMapping(value = "/addPurchaseOrder", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PurchaseOrderDTO> addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
		return ResponseEntity.ok(purchaseOrderService.addPurchaseOrder(purchaseOrder));
	}
    
	@PutMapping(value = "/updatePurchaseOrder", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PurchaseOrderDTO> updatePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
		return ResponseEntity.ok(purchaseOrderService.updatePurchaseOrder(purchaseOrder));
	}
	
	@DeleteMapping(value = "/deletePurchaseOrder/{purchaseOrderId}",produces = "application/json")
	public ResponseEntity<String> deletePurchaseOrder(@PathVariable Long purchaseOrderId) {
		purchaseOrderService.deletePurchaseOrder(purchaseOrderId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

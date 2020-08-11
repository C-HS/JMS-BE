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

import com.iaito.order.dto.purchase.PurchaseOrderProductDTO;
import com.iaito.order.model.purchase.PurchaseOrderProduct;
import com.iaito.order.service.purchase.PurchaseOrderProductService;

@RestController
public class PurchaseOrderProductController {
	
    Logger logger = LoggerFactory.getLogger(PurchaseOrderProductController.class);
    
    @Autowired PurchaseOrderProductService purchaseOrderProductService;
    
    @GetMapping(value = "/getAllPurchaseOrderProducts", produces = "application/json")
	public ResponseEntity<List<PurchaseOrderProductDTO>> purchaseOrderProducts() {
		return ResponseEntity.ok(purchaseOrderProductService.getAllPurchaseOrderProducts());
	}
    
    
    @GetMapping(value = "/getPurchaseOrderProduct/{purchaseOrderProductId}", produces = "application/json")
	public ResponseEntity<PurchaseOrderProductDTO> purchaseOrderProduct(@PathVariable Long purchaseOrderProductId) {
		return ResponseEntity.ok(purchaseOrderProductService.getPurchaseOrderProductById(purchaseOrderProductId));
	}
    
    @PostMapping(value = "/addPurchaseOrderProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PurchaseOrderProductDTO> addPurchaseOrderProduct(@RequestBody PurchaseOrderProduct purchaseOrderProduct) {
		return ResponseEntity.ok(purchaseOrderProductService.addPurchaseOrderProduct(purchaseOrderProduct));
	}
    
	@PutMapping(value = "/updatePurchaseOrderProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PurchaseOrderProductDTO> updatePurchaseOrderProduct(@RequestBody PurchaseOrderProduct purchaseOrderProduct) {
		return ResponseEntity.ok(purchaseOrderProductService.updatePurchaseOrderProduct(purchaseOrderProduct));
	}
	
	@DeleteMapping(value = "/deletePurchaseOrderProduct/{purchaseOrderProductId}",produces = "application/json")
	public ResponseEntity<String> deletePurchaseOrderProduct(@PathVariable Long purchaseOrderProductId) {
		purchaseOrderProductService.deletePurchaseOrderProduct(purchaseOrderProductId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

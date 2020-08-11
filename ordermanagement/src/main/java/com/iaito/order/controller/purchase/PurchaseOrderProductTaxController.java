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

import com.iaito.order.dto.purchase.PurchaseOrderProductTaxDTO;
import com.iaito.order.model.purchase.PurchaseOrderProductTax;
import com.iaito.order.service.purchase.PurchaseOrderProductTaxService;

@RestController
public class PurchaseOrderProductTaxController {
	
    Logger logger = LoggerFactory.getLogger(PurchaseOrderProductTaxController.class);
    
    @Autowired PurchaseOrderProductTaxService purchaseOrderProductTaxService;
    
    
    @GetMapping(value = "/getAllPurchaseOrderProductTaxes", produces = "application/json")
	public ResponseEntity<List<PurchaseOrderProductTaxDTO>> purchaseOrderProductTaxes() {
		return ResponseEntity.ok(purchaseOrderProductTaxService.getAllPurchaseOrderProductTaxes());
	}
    
    
    @GetMapping(value = "/getPurchaseOrderProductTax/{purchaseOrderProductTaxId}", produces = "application/json")
	public ResponseEntity<PurchaseOrderProductTaxDTO> purchaseOrderProductTax(@PathVariable Long purchaseOrderProductTaxId) {
		return ResponseEntity.ok(purchaseOrderProductTaxService.getPurchaseOrderProductTaxById(purchaseOrderProductTaxId));
	}
    
    @PostMapping(value = "/addPurchaseOrderProductTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PurchaseOrderProductTaxDTO> addPurchaseOrderProductTax(@RequestBody PurchaseOrderProductTax purchaseOrderProductTax) {
		return ResponseEntity.ok(purchaseOrderProductTaxService.addPurchaseOrderProductTax(purchaseOrderProductTax));
	}
    
	@PutMapping(value = "/updatePurchaseOrderProductTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PurchaseOrderProductTaxDTO> updatePurchaseOrderProductTax(@RequestBody PurchaseOrderProductTax purchaseOrderProductTax) {
		return ResponseEntity.ok(purchaseOrderProductTaxService.updatePurchaseOrderProductTax(purchaseOrderProductTax));
	}
	
	@DeleteMapping(value = "/deletePurchaseOrderProductTax/{purchaseOrderProductTaxId}",produces = "application/json")
	public ResponseEntity<String> deletePurchaseOrderProduct(@PathVariable Long purchaseOrderProductTaxId) {
		purchaseOrderProductTaxService.deletePurchaseOrderProductTax(purchaseOrderProductTaxId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

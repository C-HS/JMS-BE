package com.inventory.product.service.controller;

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

import com.inventory.product.service.dto.ProductPurchaseTaxDTO;
import com.inventory.product.service.model.ProductPurchaseTax;
import com.inventory.product.service.service.ProductPurchaseTaxService;

@RestController
public class ProductPurchaseTaxController {
	
	Logger logger = LoggerFactory.getLogger(ProductPurchaseTaxController.class);
	@Autowired ProductPurchaseTaxService productPurchaseTaxService;
	
	@GetMapping(value = "/getProductPurchaseTax/{productPurchaseTaxId}", produces = "application/json")
	public ResponseEntity<ProductPurchaseTaxDTO> productPurchaseTax(@PathVariable Long productPurchaseTaxId) {
		return ResponseEntity.ok(productPurchaseTaxService.getProductPurchaseTaxById(productPurchaseTaxId));
	}
	@GetMapping(value = "/getAllProductPurchaseTaxes", produces = "application/json")
	public ResponseEntity<List<ProductPurchaseTaxDTO>> productPurchaseTaxes() {
		return ResponseEntity.ok(productPurchaseTaxService.getAllProductPurchaseTaxes());
	}
	@PostMapping(value = "/addProductPurchaseTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductPurchaseTaxDTO> addProductPurchaseTax(@RequestBody ProductPurchaseTax productPurchaseTax) {
		return ResponseEntity.ok(productPurchaseTaxService.addProductPurchaseTax(productPurchaseTax));
	}
	@PutMapping(value = "/updateProductPurchaseTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductPurchaseTaxDTO> updateProductPurchaseTax(@RequestBody ProductPurchaseTax productPurchaseTax) {
		return ResponseEntity.ok(productPurchaseTaxService.updateProductPurchaseTax(productPurchaseTax));
	}
	@DeleteMapping(value = "/deleteProductPurchaseTax/{productPurchaseTaxId}",produces = "application/json")
	public ResponseEntity<String> deleteProductPurchaseTax(@PathVariable Long productPurchaseTaxId) {
		productPurchaseTaxService.deleteProductPurchaseTax(productPurchaseTaxId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

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

import com.inventory.product.service.dto.ProductSalesTaxDTO;
import com.inventory.product.service.model.ProductSalesTax;
import com.inventory.product.service.service.ProductSalesTaxService;

@RestController
public class ProductSalesTaxController {
	
	Logger logger = LoggerFactory.getLogger(ProductSalesTaxController.class);
	@Autowired ProductSalesTaxService productSalesTaxService;
	
	@GetMapping(value = "/getProductSalesTax/{productSalesTaxId}", produces = "application/json")
	public ResponseEntity<ProductSalesTaxDTO> productSalesTax(@PathVariable Long productSalesTaxId) {
		return ResponseEntity.ok(productSalesTaxService.getProductSalesTaxById(productSalesTaxId));
	}
	@GetMapping(value = "/getAllProductSalesTaxes", produces = "application/json")
	public ResponseEntity<List<ProductSalesTaxDTO>> productSalesTaxes() {
		return ResponseEntity.ok(productSalesTaxService.getAllProductSalesTaxes());
	}
	@PostMapping(value = "/addProductSalesTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductSalesTaxDTO> addProductSalesTax(@RequestBody ProductSalesTax productSalesTax) {
		return ResponseEntity.ok(productSalesTaxService.addProductSalesTax(productSalesTax));
	}
	@PutMapping(value = "/updateProductSalesTax", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductSalesTaxDTO> updateProductSalesTax(@RequestBody ProductSalesTax productSalesTax) {
		return ResponseEntity.ok(productSalesTaxService.updateProductSalesTax(productSalesTax));
	}
	@DeleteMapping(value = "/deleteProductSalesTax/{productSalesTaxId}",produces = "application/json")
	public ResponseEntity<String> deleteProductSalesTax(@PathVariable Long productSalesTaxId) {
		productSalesTaxService.deleteProductSalesTax(productSalesTaxId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

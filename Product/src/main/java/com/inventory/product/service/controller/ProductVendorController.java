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

import com.inventory.product.service.dto.ProductVendorDTO;
import com.inventory.product.service.model.ProductVendor;
import com.inventory.product.service.service.ProductVendorService;

@RestController
public class ProductVendorController {
	
	Logger logger = LoggerFactory.getLogger(ProductVendorController.class);
	@Autowired ProductVendorService productVendorService;
	
	@GetMapping(value = "/getProductVendor/{productVendorId}", produces = "application/json")
	public ResponseEntity<ProductVendorDTO> productVendor(@PathVariable Long productVendorId) {
		return ResponseEntity.ok(productVendorService.getProductVendorById(productVendorId));
	}
	@GetMapping(value = "/getAllProductVendors", produces = "application/json")
	public ResponseEntity<List<ProductVendorDTO>> productVendors() {
		return ResponseEntity.ok(productVendorService.getAllProductVendors());
	}
	@PostMapping(value = "/addProductVendor", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductVendorDTO> addProductVendor(@RequestBody ProductVendor productVendor) {
		return ResponseEntity.ok(productVendorService.addProductVendor(productVendor));
	}
	@PutMapping(value = "/updateProductVendor", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductVendorDTO> updateProductVendor(@RequestBody ProductVendor productVendor) {
		return ResponseEntity.ok(productVendorService.updateProductVendor(productVendor));
	}
	@DeleteMapping(value = "/deleteProductVendor/{productVendorId}",produces = "application/json")
	public ResponseEntity<String> deleteProductVendor(@PathVariable Long productVendorId) {
		productVendorService.deleteProductVendor(productVendorId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

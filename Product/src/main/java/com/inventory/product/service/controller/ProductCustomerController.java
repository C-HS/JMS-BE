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

import com.inventory.product.service.dto.ProductCustomerDTO;
import com.inventory.product.service.model.ProductCustomer;
import com.inventory.product.service.service.ProductCustomerService;

@RestController
public class ProductCustomerController {
	Logger logger = LoggerFactory.getLogger(ProductCustomerController.class);
	@Autowired ProductCustomerService productCustomerService;
	
	@GetMapping(value = "/getProductCustomer/{productCustomerId}", produces = "application/json")
	public ResponseEntity<ProductCustomerDTO> productCustomer(@PathVariable Long productCustomerId) {
		return ResponseEntity.ok(productCustomerService.getProductCustomerById(productCustomerId));
	}
	@GetMapping(value = "/getAllProductCustomers", produces = "application/json")
	public ResponseEntity<List<ProductCustomerDTO>> productCustomers() {
		return ResponseEntity.ok(productCustomerService.getAllProductCustomers());
	}
	@PostMapping(value = "/addProductCustomer", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductCustomerDTO> addProductCustomer(@RequestBody ProductCustomer productCustomer) {
		return ResponseEntity.ok(productCustomerService.addProductCustomer(productCustomer));
	}
	@PutMapping(value = "/updateProductCustomer", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductCustomerDTO> updateProductCustomer(@RequestBody ProductCustomer productCustomer) {
		return ResponseEntity.ok(productCustomerService.updateProductCustomer(productCustomer));
	}
	@DeleteMapping(value = "/deleteProductCustomer/{productCustomerId}",produces = "application/json")
	public ResponseEntity<String> deleteProductCustomer(@PathVariable Long productCustomerId) {
		productCustomerService.deleteProductCustomer(productCustomerId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

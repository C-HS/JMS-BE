package com.iaito.product.service.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.iaito.product.service.dto.ProductDTO;
import com.iaito.product.service.model.Product;
import com.iaito.product.service.service.ProductService;

@RestController
public class ProductController {
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired ProductService productService;
	
	@GetMapping(value = "/getProduct/{productId}", produces = "application/json")
	public ResponseEntity<ProductDTO> product(@PathVariable Long productId) {
		return ResponseEntity.ok(productService.getProduct(productId));
	}
	@GetMapping(value = "/getAllProducts", produces = "application/json")
	public ResponseEntity<List<ProductDTO>> products() {
		return ResponseEntity.ok(productService.getAllProducts());
	}
	@PostMapping(value = "/addProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductDTO> addProduct(@Valid @RequestBody Product product) {
		return ResponseEntity.ok(productService.addProduct(product));
	}
	@PutMapping(value = "/updateProduct", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductDTO> updateProduct(@Valid @RequestBody Product product) {
		return ResponseEntity.ok(productService.updateProduct(product));
	}
	@DeleteMapping(value = "/deleteProduct/{productId}",produces = "application/json")
	public ResponseEntity<String> deleteProduct(@PathVariable Long productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}
}

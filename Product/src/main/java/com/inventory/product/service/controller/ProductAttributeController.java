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

import com.inventory.product.service.dto.ProductAttributeDTO;
import com.inventory.product.service.model.ProductAttribute;
import com.inventory.product.service.service.ProductAttributeService;

@RestController
public class ProductAttributeController {
	
    Logger logger = LoggerFactory.getLogger(ProductAttributeController.class);

    
    @Autowired ProductAttributeService productAttributeService;
    
    @GetMapping(value = "/getAllProductAttributes", produces = "application/json")
	public ResponseEntity<List<ProductAttributeDTO>> productAttributes() {
		return ResponseEntity.ok(productAttributeService.getAllProductAttribute());
	}
    
    
    @GetMapping(value = "/getProductAttribute/{attributeId}", produces = "application/json")
	public ResponseEntity<ProductAttributeDTO> productAttribute(@PathVariable Long attributeId) {
		return ResponseEntity.ok(productAttributeService.getProductAttributeId(attributeId));
	}
    
    @PostMapping(value = "/addProductAttribute", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductAttributeDTO> addProductAttribute(@RequestBody ProductAttribute attribute) {
		return ResponseEntity.ok(productAttributeService.addProductAttribute(attribute));
	}
    
	@PutMapping(value = "/updateProductAttribute", consumes = "application/json", produces = "application/json")
	public ResponseEntity<ProductAttributeDTO> updateProductAttribute(@RequestBody ProductAttribute attribute) {
		return ResponseEntity.ok(productAttributeService.updateProductAttribute(attribute));
	}
	
	@DeleteMapping(value = "/deleteProductAttribute/{attributeId}",produces = "application/json")
	public ResponseEntity<String> deleteProductAttribute(@PathVariable Long attributeId) {
		productAttributeService.deleteProductAttribute(attributeId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

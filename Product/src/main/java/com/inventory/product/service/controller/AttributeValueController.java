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

import com.inventory.product.service.dto.AttributeValueDTO;
import com.inventory.product.service.model.AttributeValue;
import com.inventory.product.service.service.AttributeValueService;

@RestController
public class AttributeValueController {
	
	 Logger logger = LoggerFactory.getLogger(AttributeValueController.class);
	 
	 @Autowired AttributeValueService attributeValueService;
	 
	    @GetMapping(value = "/getAllAttributeValues", produces = "application/json")
		public ResponseEntity<List<AttributeValueDTO>> attributeValues() {
			return ResponseEntity.ok(attributeValueService.getAllAttributeValue());
		}
	    
	    
	    @GetMapping(value = "/getAttributeValue/{attributeValueId}", produces = "application/json")
		public ResponseEntity<AttributeValueDTO> attributeValue(@PathVariable Long attributeValueId) {
			return ResponseEntity.ok(attributeValueService.getAttributeValueById(attributeValueId));
		}
	    
	    @PostMapping(value = "/addAttributeValue", consumes = "application/json", produces = "application/json")
		public ResponseEntity<AttributeValueDTO> addAttributeValue(@RequestBody AttributeValue attributeValue) {
			return ResponseEntity.ok(attributeValueService.addAttributeValue(attributeValue));
		}
	    
		@PutMapping(value = "/updateAttributeValue", consumes = "application/json", produces = "application/json")
		public ResponseEntity<AttributeValueDTO> updateCatalog(@RequestBody AttributeValue attributeValue) {
			return ResponseEntity.ok(attributeValueService.updateAttributeValue(attributeValue));
		}
		
		@DeleteMapping(value = "/deleteAttributeValue/{attributeValueId}",produces = "application/json")
		public ResponseEntity<String> deleteAttributeValue(@PathVariable Long attributeValueId) {
			attributeValueService.deleteAttributeValue(attributeValueId);
			return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
		}

}

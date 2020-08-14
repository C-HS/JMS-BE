package com.iaito.shipping.controller;

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

import com.iaito.shipping.dto.PickListProductDTO;
import com.iaito.shipping.model.PickListProduct;
import com.iaito.shipping.service.PickListProductService;

@RestController
public class PickListProductController {
	
    Logger logger = LoggerFactory.getLogger(PickListProductController.class);
    
    @Autowired PickListProductService pickListProductService;
    
    @GetMapping(value = "/getPickListProducts", produces = "application/json")
   	public ResponseEntity<List<PickListProductDTO>> pickListProducts() {
   		return ResponseEntity.ok(pickListProductService.getAllPickListProducts());
   	}
       
       
    @GetMapping(value = "/getPickListProduct/{pickListProductId}", produces = "application/json")
   	public ResponseEntity<PickListProductDTO> pickListProduct(@PathVariable Long pickListProductId) {
   		return ResponseEntity.ok(pickListProductService.getPickListProductById(pickListProductId));
   	}
       
       @PostMapping(value = "/addPickListProduct", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<PickListProductDTO> addPickListProduct(@RequestBody PickListProduct pickListProduct) {
   		return ResponseEntity.ok(pickListProductService.addPickListProduct(pickListProduct));
   	}
       
   	@PutMapping(value = "/updatePickListProduct", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<PickListProductDTO> updatePickListProduct(@RequestBody PickListProduct pickListProduct) {
   		return ResponseEntity.ok(pickListProductService.updatePickListProduct(pickListProduct));
   	}
   	
   	@DeleteMapping(value = "/deletePickListProduct/{pickListProductId}",produces = "application/json")
   	public ResponseEntity<String> deletePickListProduct(@PathVariable Long pickListProductId) {
   		pickListProductService.deletePickListProduct(pickListProductId);
   		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
   	}

}

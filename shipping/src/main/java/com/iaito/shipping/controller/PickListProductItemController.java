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

import com.iaito.shipping.dto.PickListProductItemDTO;
import com.iaito.shipping.model.PickListProductItem;
import com.iaito.shipping.service.PickListProductItemService;

@RestController
public class PickListProductItemController {
	
    Logger logger = LoggerFactory.getLogger(PickListProductItemController.class);
    
    @Autowired PickListProductItemService pickListProductItemService;
    
    @GetMapping(value = "/getPickListProductItems", produces = "application/json")
   	public ResponseEntity<List<PickListProductItemDTO>> pickListProductItems() {
   		return ResponseEntity.ok(pickListProductItemService.getAllPickListProductItems());
   	}
       
       
    @GetMapping(value = "/getPickListProductItem/{pickListProductItemId}", produces = "application/json")
   	public ResponseEntity<PickListProductItemDTO> pickListProductItem(@PathVariable Long pickListProductItemId) {
   		return ResponseEntity.ok(pickListProductItemService.getPickListProductItemById(pickListProductItemId));
   	}
       
       @PostMapping(value = "/addPickListProductItem", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<PickListProductItemDTO> addPickListProductItem(@RequestBody PickListProductItem pickListProductItem) {
   		return ResponseEntity.ok(pickListProductItemService.addPickListProductItem(pickListProductItem));
   	}
       
   	@PutMapping(value = "/updatePickListProductItem", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<PickListProductItemDTO> updatePickListProductItem(@RequestBody PickListProductItem pickListProductItem) {
   		return ResponseEntity.ok(pickListProductItemService.updatePickListProductItem(pickListProductItem));
   	}
   	
   	@DeleteMapping(value = "/deletePickListProductItem/{pickListProductItemId}",produces = "application/json")
   	public ResponseEntity<String> deletePickListProductItem(@PathVariable Long pickListProductItemId) {
   		pickListProductItemService.deletePickListProductItem(pickListProductItemId);
   		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
   	}

}

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

import com.iaito.shipping.dto.IncomingShipmentItemDTO;
import com.iaito.shipping.model.IncomingShipmentItem;
import com.iaito.shipping.service.IncomingShipmentItemService;

@RestController
public class IncomingShipmentItemController {

    Logger logger = LoggerFactory.getLogger(IncomingShipmentItemController.class);
    
    @Autowired IncomingShipmentItemService incomingShipmentItemService;
    
    @GetMapping(value = "/getAllIncomingShipmentItems", produces = "application/json")
   	public ResponseEntity<List<IncomingShipmentItemDTO>> incomingShipmentItems() {
   		return ResponseEntity.ok(incomingShipmentItemService.getAllIncomingShipmentItems());
   	}
       
       
    @GetMapping(value = "/getIncomingShipmentItem/{incomingShipmentItemId}", produces = "application/json")
   	public ResponseEntity<IncomingShipmentItemDTO> incomingShipmentItem(@PathVariable Long incomingShipmentItemId) {
   		return ResponseEntity.ok(incomingShipmentItemService.getIncomingShipmentItemById(incomingShipmentItemId));
   	}
       
       @PostMapping(value = "/addIncomingShipmentItem", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<IncomingShipmentItemDTO> addIncomingShipmentItem(@RequestBody IncomingShipmentItem incomingShipmentItem) {
   		return ResponseEntity.ok(incomingShipmentItemService.addIncomingShipmentItem(incomingShipmentItem));
   	}
       
   	@PutMapping(value = "/updateIncomingShipmentItem", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<IncomingShipmentItemDTO> updateIncomingShipmentItem(@RequestBody IncomingShipmentItem incomingShipmentItem) {
   		return ResponseEntity.ok(incomingShipmentItemService.updateIncomingShipmentItem(incomingShipmentItem));
   	}
   	
   	@DeleteMapping(value = "/deleteIncomingShipmentItem/{incomingShipmentItemId}",produces = "application/json")
   	public ResponseEntity<String> deleteIncomingShipmentItem(@PathVariable Long incomingShipmentItemId) {
   		incomingShipmentItemService.deleteIncomingShipmentItem(incomingShipmentItemId);
   		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
   	}
}

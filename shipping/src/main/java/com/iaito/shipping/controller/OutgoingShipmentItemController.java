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

import com.iaito.shipping.dto.OutgoingShipmentItemDTO;
import com.iaito.shipping.model.OutgoingShipmentItem;
import com.iaito.shipping.service.OutgoingShipmentItemService;

@RestController
public class OutgoingShipmentItemController {

    Logger logger = LoggerFactory.getLogger(OutgoingShipmentItemController.class);
    
    @Autowired OutgoingShipmentItemService outgoingShipmentItemService;
    
    @GetMapping(value = "/getAllOutgoingShipmentItems", produces = "application/json")
   	public ResponseEntity<List<OutgoingShipmentItemDTO>> outgoingShipmentItems() {
   		return ResponseEntity.ok(outgoingShipmentItemService.getAllOutgoingShipmentItems());
   	}
       
       
    @GetMapping(value = "/getOutgoingShipmentItem/{outgoingShipmentItemId}", produces = "application/json")
   	public ResponseEntity<OutgoingShipmentItemDTO> outgoingShipmentItem(@PathVariable Long outgoingShipmentItemId) {
   		return ResponseEntity.ok(outgoingShipmentItemService.getOutgoingShipmentItemById(outgoingShipmentItemId));
   	}
       
       @PostMapping(value = "/addOutgoingShipmentItem", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<OutgoingShipmentItemDTO> addOutgoingShipmentItem(@RequestBody OutgoingShipmentItem outgoingShipmentItem) {
   		return ResponseEntity.ok(outgoingShipmentItemService.addOutgoingShipmentItem(outgoingShipmentItem));
   	}
       
   	@PutMapping(value = "/updateOutgoingShipmentItem", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<OutgoingShipmentItemDTO> updateOutgoingShipmentItem(@RequestBody OutgoingShipmentItem outgoingShipmentItem) {
   		return ResponseEntity.ok(outgoingShipmentItemService.updateOutgoingShipmentItem(outgoingShipmentItem));
   	}
   	
   	@DeleteMapping(value = "/deleteOutgoingShipmentItem/{outgoingShipmentItemId}",produces = "application/json")
   	public ResponseEntity<String> deleteOutgoingShipmentItem(@PathVariable Long outgoingShipmentItemId) {
   		outgoingShipmentItemService.deleteOutgoingShipmentItem(outgoingShipmentItemId);
   		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
   	}
}

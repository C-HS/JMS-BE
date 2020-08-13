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

import com.iaito.shipping.dto.OutgoingShipmentDTO;
import com.iaito.shipping.model.OutgoingShipment;
import com.iaito.shipping.service.OutgoingShipmentService;

@RestController
public class OutgoingShipmentController {
	
    Logger logger = LoggerFactory.getLogger(OutgoingShipmentController.class);
    
    @Autowired OutgoingShipmentService outgoingShipmentService;
    
    @GetMapping(value = "/getAllOutgoingShipments", produces = "application/json")
   	public ResponseEntity<List<OutgoingShipmentDTO>> outgoingShipments() {
   		return ResponseEntity.ok(outgoingShipmentService.getAllOutgoingShipments());
   	}
       
       
    @GetMapping(value = "/getOutgoingShipment/{outgoingShipmentId}", produces = "application/json")
   	public ResponseEntity<OutgoingShipmentDTO> outgoingShipment(@PathVariable Long outgoingShipmentId) {
   		return ResponseEntity.ok(outgoingShipmentService.getOutgoingShipmentById(outgoingShipmentId));
   	}
       
       @PostMapping(value = "/addOutgoingShipment", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<OutgoingShipmentDTO> addOutgoingShipment(@RequestBody OutgoingShipment outgoingShipment) {
   		return ResponseEntity.ok(outgoingShipmentService.addOutgoingShipment(outgoingShipment));
   	}
       
   	@PutMapping(value = "/updateOutgoingShipment", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<OutgoingShipmentDTO> updateOutgoingShipment(@RequestBody OutgoingShipment outgoingShipment) {
   		return ResponseEntity.ok(outgoingShipmentService.updateOutgoingShipment(outgoingShipment));
   	}
   	
   	@DeleteMapping(value = "/deleteOutgoingShipment/{outgoingShipmentId}",produces = "application/json")
   	public ResponseEntity<String> deleteOutgoingShipment(@PathVariable Long outgoingShipmentId) {
   		outgoingShipmentService.deleteOutgoingShipment(outgoingShipmentId);
   		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
   	}

}

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

import com.iaito.shipping.dto.IncomingShipmentDTO;
import com.iaito.shipping.model.IncomingShipment;
import com.iaito.shipping.service.IncomingShipmentService;

@RestController
public class IncomingShipmentController {
	
    Logger logger = LoggerFactory.getLogger(IncomingShipmentController.class);
    
    @Autowired IncomingShipmentService incomingShipmentService;
    
    @GetMapping(value = "/getAllIncomingShipments", produces = "application/json")
   	public ResponseEntity<List<IncomingShipmentDTO>> incomingShipments() {
   		return ResponseEntity.ok(incomingShipmentService.getAllIncomingShipments());
   	}
       
       
    @GetMapping(value = "/getIncomingShipment/{incomingShipmentId}", produces = "application/json")
   	public ResponseEntity<IncomingShipmentDTO> incomingShipment(@PathVariable Long incomingShipmentId) {
   		return ResponseEntity.ok(incomingShipmentService.getIncomingShipmentById(incomingShipmentId));
   	}
       
       @PostMapping(value = "/addIncomingShipment", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<IncomingShipmentDTO> addIncomingShipment(@RequestBody IncomingShipment incomingShipment) {
   		return ResponseEntity.ok(incomingShipmentService.addIncomingShipment(incomingShipment));
   	}
       
   	@PutMapping(value = "/updateIncomingShipment", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<IncomingShipmentDTO> updateIncomingShipment(@RequestBody IncomingShipment incomingShipment) {
   		return ResponseEntity.ok(incomingShipmentService.updateIncomingShipment(incomingShipment));
   	}
   	
   	@DeleteMapping(value = "/deleteIncomingShipment/{incomingShipmentId}",produces = "application/json")
   	public ResponseEntity<String> deleteIncomingShipment(@PathVariable Long incomingShipmentId) {
   		incomingShipmentService.deleteIncomingShipment(incomingShipmentId);
   		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
   	}

}

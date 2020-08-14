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

import com.iaito.shipping.dto.TransportDTO;
import com.iaito.shipping.model.Transport;
import com.iaito.shipping.service.TransportService;

@RestController
public class TransportController {
	
    Logger logger = LoggerFactory.getLogger(TransportController.class);
    
    @Autowired TransportService transportService;
    
    
    @GetMapping(value = "/getAllTransports", produces = "application/json")
   	public ResponseEntity<List<TransportDTO>> transports() {
   		return ResponseEntity.ok(transportService.getAllTransports());
   	}
       
       
    @GetMapping(value = "/getTransport/{transportId}", produces = "application/json")
   	public ResponseEntity<TransportDTO> transport(@PathVariable Long transportId) {
   		return ResponseEntity.ok(transportService.getTransportById(transportId));
   	}
       
       @PostMapping(value = "/addTransport", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<TransportDTO> addTransport(@RequestBody Transport transport) {
   		return ResponseEntity.ok(transportService.addTransport(transport));
   	}
       
   	@PutMapping(value = "/updateTransport", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<TransportDTO> updateTransport(@RequestBody Transport transport) {
   		return ResponseEntity.ok(transportService.updateTransport(transport));
   	}
   	
   	@DeleteMapping(value = "/deleteTransport/{transportId}",produces = "application/json")
   	public ResponseEntity<String> deleteTransport(@PathVariable Long transportId) {
   		transportService.deleteTransport(transportId);
   		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
   	}

}

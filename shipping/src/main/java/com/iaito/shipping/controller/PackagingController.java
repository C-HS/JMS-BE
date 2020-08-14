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

import com.iaito.shipping.dto.PackagingDTO;
import com.iaito.shipping.model.Packaging;
import com.iaito.shipping.service.PackagingService;

@RestController
public class PackagingController {
	
    Logger logger = LoggerFactory.getLogger(PackagingController.class);
    
    @Autowired PackagingService packagingService;
    
    
    @GetMapping(value = "/getAllPackagings", produces = "application/json")
   	public ResponseEntity<List<PackagingDTO>> packagings() {
   		return ResponseEntity.ok(packagingService.getAllPackagings());
   	}
       
       
    @GetMapping(value = "/getPackaging/{packagingId}", produces = "application/json")
   	public ResponseEntity<PackagingDTO> packaging(@PathVariable Long packagingId) {
   		return ResponseEntity.ok(packagingService.getPackagingById(packagingId));
   	}
       
       @PostMapping(value = "/addPackaging", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<PackagingDTO> addPackaging(@RequestBody Packaging packaging) {
   		return ResponseEntity.ok(packagingService.addPackaging(packaging));
   	}
       
   	@PutMapping(value = "/updatePackaging", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<PackagingDTO> updatePackaging(@RequestBody Packaging packaging) {
   		return ResponseEntity.ok(packagingService.updatePackaging(packaging));
   	}
   	
   	@DeleteMapping(value = "/deletePackaging/{packagingId}",produces = "application/json")
   	public ResponseEntity<String> deletePackaging(@PathVariable Long packagingId) {
   		packagingService.deletePackaging(packagingId);
   		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
   	}

}

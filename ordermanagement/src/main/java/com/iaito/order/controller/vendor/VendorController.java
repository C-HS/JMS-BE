package com.iaito.order.controller.vendor;

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

import com.iaito.order.dto.vendor.VendorDTO;
import com.iaito.order.model.vendor.Vendor;
import com.iaito.order.service.vendor.VendorService;

@RestController
public class VendorController {
	
    Logger logger = LoggerFactory.getLogger(VendorController.class);
    
    @Autowired VendorService vendorService;
    
    @GetMapping(value = "/getAllVendors", produces = "application/json")
	public ResponseEntity<List<VendorDTO>> vendors() {
		return ResponseEntity.ok(vendorService.getAllVendors());
	}
    
    
    @GetMapping(value = "/getVendor/{vendorId}", produces = "application/json")
	public ResponseEntity<VendorDTO> vendor(@PathVariable Long vendorId) {
		return ResponseEntity.ok(vendorService.getVendorById(vendorId));
	}
    
    @PostMapping(value = "/addVendor", consumes = "application/json", produces = "application/json")
	public ResponseEntity<VendorDTO> addVendor(@RequestBody Vendor vendor) {
		return ResponseEntity.ok(vendorService.addVendor(vendor));
	}
    
	@PutMapping(value = "/updateVendor", consumes = "application/json", produces = "application/json")
	public ResponseEntity<VendorDTO> updateVendor(@RequestBody Vendor vendor) {
		return ResponseEntity.ok(vendorService.updateVendor(vendor));
	}
	
	@DeleteMapping(value = "/deleteVendor/{vendorId}",produces = "application/json")
	public ResponseEntity<String> deleteVendor(@PathVariable Long vendorId) {
		vendorService.deleteVendor(vendorId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

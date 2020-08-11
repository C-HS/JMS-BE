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

import com.iaito.order.dto.vendor.VendorContactDTO;
import com.iaito.order.model.vendor.VendorContact;
import com.iaito.order.service.vendor.VendorContactService;

@RestController
public class VendorContactController {
	
    Logger logger = LoggerFactory.getLogger(VendorContactController.class);
    
    @Autowired VendorContactService vendorContactService;
    
    @GetMapping(value = "/getAllVendorContacts", produces = "application/json")
	public ResponseEntity<List<VendorContactDTO>> vendorContacts() {
		return ResponseEntity.ok(vendorContactService.getAllVendorContacts());
	}
    
    
    @GetMapping(value = "/getVendorContact/{vendorContactId}", produces = "application/json")
	public ResponseEntity<VendorContactDTO> vendorContact(@PathVariable Long vendorContactId) {
		return ResponseEntity.ok(vendorContactService.getVendorContactById(vendorContactId));
	}
    
    @PostMapping(value = "/addVendorContact", consumes = "application/json", produces = "application/json")
	public ResponseEntity<VendorContactDTO> addVendorContact(@RequestBody VendorContact vendorContact) {
		return ResponseEntity.ok(vendorContactService.addVendorContact(vendorContact));
	}
    
	@PutMapping(value = "/updateVendorContact", consumes = "application/json", produces = "application/json")
	public ResponseEntity<VendorContactDTO> updateVendorContact(@RequestBody VendorContact vendorContact) {
		return ResponseEntity.ok(vendorContactService.updateVendorContact(vendorContact));
	}
	
	@DeleteMapping(value = "/deleteVendorContact/{vendorContactId}",produces = "application/json")
	public ResponseEntity<String> deleteVendorContact(@PathVariable Long vendorContactId) {
		vendorContactService.deleteVendorContact(vendorContactId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

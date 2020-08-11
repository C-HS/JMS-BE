package com.iaito.order.controller.customer;

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

import com.iaito.order.dto.customer.CustomerContactDTO;
import com.iaito.order.model.customer.CustomerContact;
import com.iaito.order.service.customer.CustomerContactService;

@RestController
public class CustomerContactController {
	
    Logger logger = LoggerFactory.getLogger(CustomerContactController.class);
    
    @Autowired CustomerContactService customerContactService;
    
    @GetMapping(value = "/getAllCustomerContacts", produces = "application/json")
	public ResponseEntity<List<CustomerContactDTO>> customerContacts() {
		return ResponseEntity.ok(customerContactService.getAllCustomerContacts());
	}
    
    
    @GetMapping(value = "/getCustomerContact/{customerContactId}", produces = "application/json")
	public ResponseEntity<CustomerContactDTO> customerContact(@PathVariable Long customerContactId) {
		return ResponseEntity.ok(customerContactService.getCustomerContactById(customerContactId));
	}
    
    @PostMapping(value = "/addCustomerContact", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerContactDTO> addCustomerContact(@RequestBody CustomerContact customerContact) {
		return ResponseEntity.ok(customerContactService.addCustomerContact(customerContact));
	}
    
	@PutMapping(value = "/updateCustomerContact", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerContactDTO> updateCustomerContact(@RequestBody CustomerContact customerContact) {
		return ResponseEntity.ok(customerContactService.updateCustomerContact(customerContact));
	}
	
	@DeleteMapping(value = "/deleteCustomerContact/{customerContactId}",produces = "application/json")
	public ResponseEntity<String> deleteCustomerContact(@PathVariable Long customerContactId) {
		customerContactService.deleteCustomerContact(customerContactId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}


}

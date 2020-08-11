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

import com.iaito.order.dto.customer.CustomerDTO;
import com.iaito.order.model.customer.Customer;
import com.iaito.order.service.customer.CustomerService;

@RestController
public class CustomerController {
	
    Logger logger = LoggerFactory.getLogger(CustomerController.class);
    
    @Autowired CustomerService customerService;
    
    @GetMapping(value = "/getAllCustomers", produces = "application/json")
	public ResponseEntity<List<CustomerDTO>> customers() {
		return ResponseEntity.ok(customerService.getAllCustomers());
	}
    
    
    @GetMapping(value = "/getCustomer/{customerId}", produces = "application/json")
	public ResponseEntity<CustomerDTO> customer(@PathVariable Long customerId) {
		return ResponseEntity.ok(customerService.getCustomerById(customerId));
	}
    
    @PostMapping(value = "/addCustomer", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerDTO> addCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.addCustomer(customer));
	}
    
	@PutMapping(value = "/updateCustomer", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer) {
		return ResponseEntity.ok(customerService.updateCustomer(customer));
	}
	
	@DeleteMapping(value = "/deleteCustomer/{customerId}",produces = "application/json")
	public ResponseEntity<String> deleteCustomer(@PathVariable Long customerId) {
		customerService.deleteCustomer(customerId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

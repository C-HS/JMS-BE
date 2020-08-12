package com.iaito.order.controller.payment;

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

import com.iaito.order.dto.payment.PaymentTermsDTO;
import com.iaito.order.model.payment.PaymentTerms;
import com.iaito.order.service.payment.PaymentTermsService;

@RestController
public class PaymentTermsController {

    Logger logger = LoggerFactory.getLogger(PaymentTermsController.class);
    
    @Autowired PaymentTermsService paymentTermsService;
    
    @GetMapping(value = "/getAllPaymentTerms", produces = "application/json")
	public ResponseEntity<List<PaymentTermsDTO>> allPaymentTerms() {
		return ResponseEntity.ok(paymentTermsService.getAllPaymentTerms());
	}
    
    
    @GetMapping(value = "/getPaymentTerms/{paymentTermsId}", produces = "application/json")
	public ResponseEntity<PaymentTermsDTO> paymentTerms(@PathVariable Long paymentTermsId) {
		return ResponseEntity.ok(paymentTermsService.getPaymentTermsById(paymentTermsId));
	}
    
    @PostMapping(value = "/addPaymentTerms", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PaymentTermsDTO> addPaymentTerms(@RequestBody PaymentTerms paymentTerms) {
		return ResponseEntity.ok(paymentTermsService.addPaymentTerms(paymentTerms));
	}
    
	@PutMapping(value = "/updatePaymentTerms", consumes = "application/json", produces = "application/json")
	public ResponseEntity<PaymentTermsDTO> updatePaymentTerms(@RequestBody PaymentTerms paymentTerms) {
		return ResponseEntity.ok(paymentTermsService.updatePaymentTerms(paymentTerms));
	}
	
	@DeleteMapping(value = "/deletePaymentTerms/{paymentTermsId}",produces = "application/json")
	public ResponseEntity<String> deletePaymentTerms(@PathVariable Long paymentTermsId) {
		paymentTermsService.deletePaymentTerms(paymentTermsId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}
}

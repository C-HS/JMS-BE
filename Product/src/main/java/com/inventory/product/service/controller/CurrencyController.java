package com.inventory.product.service.controller;

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

import com.inventory.product.service.dto.CurrencyDTO;
import com.inventory.product.service.model.Currency;
import com.inventory.product.service.service.CurrencyService;

@RestController
public class CurrencyController {
	
	Logger logger = LoggerFactory.getLogger(CurrencyController.class);
	@Autowired CurrencyService currencyService;
	
	@GetMapping(value = "/getCurrency/{currencyId}", produces = "application/json")
	public ResponseEntity<CurrencyDTO> currency(@PathVariable Long currencyId) {
		return ResponseEntity.ok(currencyService.getCurrencyById(currencyId));
	}
	@GetMapping(value = "/getAllCurrencies", produces = "application/json")
	public ResponseEntity<List<CurrencyDTO>> currencies() {
		return ResponseEntity.ok(currencyService.getAllCurrencies());
	}
	@PostMapping(value = "/addCurrency", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CurrencyDTO> addCurrency(@RequestBody Currency currency) {
		return ResponseEntity.ok(currencyService.addCurrency(currency));
	}
	@PutMapping(value = "/updateCurrency", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CurrencyDTO> updateCurrency(@RequestBody Currency currency) {
		return ResponseEntity.ok(currencyService.updateCurrency(currency));
	}
	@DeleteMapping(value = "/deleteCurrency/{currencyId}",produces = "application/json")
	public ResponseEntity<String> deleteCurrency(@PathVariable Long currencyId) {
		currencyService.deleteCurrency(currencyId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

package com.iaito.inventory.controller;

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

import com.iaito.inventory.dto.InventoryItemDTO;
import com.iaito.inventory.model.InventoryItem;
import com.iaito.inventory.service.InventoryItemService;

@RestController
public class InventoryItemController {
	
	Logger logger = LoggerFactory.getLogger(InventoryItemController.class);
	@Autowired InventoryItemService inventoryItemService;
	
	@GetMapping(value = "/getInventoryItem/{inventoryItemId}", produces = "application/json")
	public ResponseEntity<InventoryItemDTO> inventoryItem(@PathVariable Long inventoryItemId) {
		return ResponseEntity.ok(inventoryItemService.getInventoryItemById(inventoryItemId));
	}
	@GetMapping(value = "/getAllInventoryItems", produces = "application/json")
	public ResponseEntity<List<InventoryItemDTO>> inventoryItems() {
		return ResponseEntity.ok(inventoryItemService.getAllInventoryItems());
	}
	@PostMapping(value = "/addInventoryItem", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InventoryItemDTO> addInventoryItem(@RequestBody InventoryItem inventoryItem) {
		return ResponseEntity.ok(inventoryItemService.addInventoryItem(inventoryItem));
	}
	@PutMapping(value = "/updateInventoryItem", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InventoryItemDTO> updateInventoryItem(@RequestBody InventoryItem inventoryItem) {
		return ResponseEntity.ok(inventoryItemService.updateInventoryItem(inventoryItem));
	}
	@DeleteMapping(value = "/deleteInventoryItem/{inventoryItemId}",produces = "application/json")
	public ResponseEntity<String> deleteInventoryItem(@PathVariable Long inventoryItemId) {
		inventoryItemService.deleteInventoryItem(inventoryItemId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

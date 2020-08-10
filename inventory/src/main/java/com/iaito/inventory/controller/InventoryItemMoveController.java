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

import com.iaito.inventory.dto.InventoryItemMoveDTO;
import com.iaito.inventory.model.InventoryItemMove;
import com.iaito.inventory.service.InventoryItemMoveService;

@RestController
public class InventoryItemMoveController {
	
	Logger logger = LoggerFactory.getLogger(InventoryItemMoveController.class);
	@Autowired InventoryItemMoveService inventoryItemMoveService;
	
	@GetMapping(value = "/getInventoryItemMove/{inventoryItemMoveId}", produces = "application/json")
	public ResponseEntity<InventoryItemMoveDTO> inventoryItemMove(@PathVariable Long inventoryItemMoveId) {
		return ResponseEntity.ok(inventoryItemMoveService.getInventoryItemMoveById(inventoryItemMoveId));
	}
	@GetMapping(value = "/getAllInventoryItemMoves", produces = "application/json")
	public ResponseEntity<List<InventoryItemMoveDTO>> inventoryItemMoves() {
		return ResponseEntity.ok(inventoryItemMoveService.getAllInventoryItemMoves());
	}
	@PostMapping(value = "/addInventoryItemMove", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InventoryItemMoveDTO> addInventoryItem(@RequestBody InventoryItemMove inventoryItemMove) {
		return ResponseEntity.ok(inventoryItemMoveService.addInventoryItemMove(inventoryItemMove));
	}
	@PutMapping(value = "/updateInventoryItemMove", consumes = "application/json", produces = "application/json")
	public ResponseEntity<InventoryItemMoveDTO> updateInventoryItem(@RequestBody InventoryItemMove inventoryItemMove) {
		return ResponseEntity.ok(inventoryItemMoveService.updateInventoryItemMove(inventoryItemMove));
	}
	@DeleteMapping(value = "/deleteInventoryItemMove/{inventoryItemMoveId}",produces = "application/json")
	public ResponseEntity<String> deleteInventoryItemMove(@PathVariable Long inventoryItemMoveId) {
		inventoryItemMoveService.deleteInventoryItemMove(inventoryItemMoveId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

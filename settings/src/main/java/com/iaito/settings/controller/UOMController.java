package com.iaito.settings.controller;

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

import com.iaito.settings.dto.UOMDTO;
import com.iaito.settings.model.UOM;
import com.iaito.settings.service.UOMService;

@RestController
public class UOMController {
	
	Logger logger = LoggerFactory.getLogger(UOMController.class);
	@Autowired UOMService uomService;
	
	@GetMapping(value = "/getUOM/{uomId}", produces = "application/json")
	public ResponseEntity<UOMDTO> uom(@PathVariable Long uomId) {
		return ResponseEntity.ok(uomService.getUOMById(uomId));
	}
	@GetMapping(value = "/getAllUOMs", produces = "application/json")
	public ResponseEntity<List<UOMDTO>> uoms() {
		return ResponseEntity.ok(uomService.getAllUOM());
	}
	@PostMapping(value = "/addUOM", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UOMDTO> addUOM(@RequestBody UOM uom) {
		return ResponseEntity.ok(uomService.addUOM(uom));
	}
	@PutMapping(value = "/updateUOM", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UOMDTO> updateUOM(@RequestBody UOM uom) {
		return ResponseEntity.ok(uomService.updateUOM(uom));
	}
	@DeleteMapping(value = "/deleteUOM/{uomId}",produces = "application/json")
	public ResponseEntity<String> deleteUOM(@PathVariable Long uomId) {
		uomService.deleteUOM(uomId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

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

import com.iaito.shipping.dto.BoxDTO;
import com.iaito.shipping.model.Box;
import com.iaito.shipping.service.BoxService;

@RestController
public class BoxController {

    Logger logger = LoggerFactory.getLogger(BoxController.class);
    
    @Autowired BoxService boxService;
    
    
    @GetMapping(value = "/getAllBoxes", produces = "application/json")
   	public ResponseEntity<List<BoxDTO>> boxes() {
   		return ResponseEntity.ok(boxService.getAllBoxes());
   	}
       
       
    @GetMapping(value = "/getBox/{boxId}", produces = "application/json")
   	public ResponseEntity<BoxDTO> box(@PathVariable Long boxId) {
   		return ResponseEntity.ok(boxService.getBoxById(boxId));
   	}
       
       @PostMapping(value = "/addBox", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<BoxDTO> addBox(@RequestBody Box box) {
   		return ResponseEntity.ok(boxService.addBox(box));
   	}
       
   	@PutMapping(value = "/updateBox", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<BoxDTO> updateBox(@RequestBody Box box) {
   		return ResponseEntity.ok(boxService.updateBox(box));
   	}
   	
   	@DeleteMapping(value = "/deleteBox/{boxId}",produces = "application/json")
   	public ResponseEntity<String> deleteBox(@PathVariable Long boxId) {
   		boxService.deleteBox(boxId);
   		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
   	}
}

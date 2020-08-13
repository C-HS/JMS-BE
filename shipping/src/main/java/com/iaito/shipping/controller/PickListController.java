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

import com.iaito.shipping.dto.PickListDTO;
import com.iaito.shipping.model.PickList;
import com.iaito.shipping.service.PickListService;

@RestController
public class PickListController {
	
    Logger logger = LoggerFactory.getLogger(PickListController.class);
    
    @Autowired PickListService pickListService;
    
    @GetMapping(value = "/getPickLists", produces = "application/json")
   	public ResponseEntity<List<PickListDTO>> pickLists() {
   		return ResponseEntity.ok(pickListService.getAllPickLists());
   	}
       
       
    @GetMapping(value = "/getPickList/{pickListId}", produces = "application/json")
   	public ResponseEntity<PickListDTO> pickList(@PathVariable Long pickListId) {
   		return ResponseEntity.ok(pickListService.getPickListById(pickListId));
   	}
       
       @PostMapping(value = "/addPickList", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<PickListDTO> addPickList(@RequestBody PickList pickList) {
   		return ResponseEntity.ok(pickListService.addPickList(pickList));
   	}
       
   	@PutMapping(value = "/updatePickList", consumes = "application/json", produces = "application/json")
   	public ResponseEntity<PickListDTO> updatePickList(@RequestBody PickList pickList) {
   		return ResponseEntity.ok(pickListService.updatePickList(pickList));
   	}
   	
   	@DeleteMapping(value = "/deletePickList/{pickListId}",produces = "application/json")
   	public ResponseEntity<String> deletePickList(@PathVariable Long pickListId) {
   		pickListService.deletePickList(pickListId);
   		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
   	}

}

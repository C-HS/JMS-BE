package com.inventory.product.service.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.inventory.product.service.dto.CatalogDTO;
import com.inventory.product.service.model.Catalog;
import com.inventory.product.service.service.CatalogService;

@RestController
public class CatalogController {
    Logger logger = LoggerFactory.getLogger(CatalogController.class);
    //implement all endpoints..
    
    @Autowired CatalogService catalogService;
    
    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, 
    			produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> saveCatalog(@RequestPart("catalog") Catalog catalog, 
    						  @RequestPart("file") MultipartFile file) throws IOException {
    	catalog.setCatalogImage(file.getBytes());
    	catalogService.addCatalog(catalog);
    	logger.warn("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+catalog);
    	return ResponseEntity.ok(file.getBytes());
    }
    
    @GetMapping(value = "/getAllCatalogs", produces = "application/json")
	public ResponseEntity<List<CatalogDTO>> catalogs() {
		return ResponseEntity.ok(catalogService.getAllCatalog());
	}
    
    
    @GetMapping(value = "/getCatalog/{catalogId}", produces = "application/json")
	public ResponseEntity<CatalogDTO> catalog(@PathVariable Long catalogId) {
		return ResponseEntity.ok(catalogService.getCatalogById(catalogId));
	}
    
    @PostMapping(value = "/addCatalog", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CatalogDTO> addCatalog(@RequestBody Catalog catalog) {
		return ResponseEntity.ok(catalogService.addCatalog(catalog));
	}
    
	@PutMapping(value = "/updateCatalog", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CatalogDTO> updateCatalog(@RequestBody Catalog catalog) {
		return ResponseEntity.ok(catalogService.updateCatalog(catalog));
	}
	
	@DeleteMapping(value = "/deleteCatalog/{catalogId}",produces = "application/json")
	public ResponseEntity<String> deleteCatalog(@PathVariable Long catalogId) {
		catalogService.deleteCatalog(catalogId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}
    
}
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

import com.inventory.product.service.dto.CategoryDTO;
import com.inventory.product.service.model.Category;
import com.inventory.product.service.service.CategoryService;

@RestController
public class CategoryController {
	
    Logger logger = LoggerFactory.getLogger(CategoryController.class);

    
    @Autowired CategoryService categoryService;
    
    @GetMapping(value = "/getAllCategories", produces = "application/json")
	public ResponseEntity<List<CategoryDTO>> categories() {
		return ResponseEntity.ok(categoryService.getAllCategory());
	}
    
    
    @GetMapping(value = "/getCategory/{categoryId}", produces = "application/json")
	public ResponseEntity<CategoryDTO> category(@PathVariable Long categoryId) {
		return ResponseEntity.ok(categoryService.getCategoryById(categoryId));
	}
    
    @PostMapping(value = "/addCategory", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CategoryDTO> addCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.addCategory(category));
	}
    
	@PutMapping(value = "/updateCategory", consumes = "application/json", produces = "application/json")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody Category category) {
		return ResponseEntity.ok(categoryService.updateCategory(category));
	}
	
	@DeleteMapping(value = "/deleteCategory/{categoryId}",produces = "application/json")
	public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
		categoryService.deleteCategory(categoryId);
		return ResponseEntity.status(HttpStatus.OK).body("Record Deleted Successfully");
	}

}

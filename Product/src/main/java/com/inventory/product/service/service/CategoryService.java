package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.CategoryDTO;
import com.inventory.product.service.model.Category;


public interface CategoryService {
	
    public CategoryDTO getCategoryById(long categoryId);
    public List<CategoryDTO> getAllCategory();
    public CategoryDTO addCategory(Category category);
    public CategoryDTO updateCategory(Category category);
    public void deleteCategory(long categoryId);

}

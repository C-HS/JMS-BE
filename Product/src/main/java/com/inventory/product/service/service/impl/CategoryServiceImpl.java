package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.CategoryDTO;
import com.inventory.product.service.model.Category;
import com.inventory.product.service.repository.CategoryRepository;
import com.inventory.product.service.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired CategoryRepository categoryRepository;

	@Override
	public CategoryDTO getCategoryById(long categoryId) {
		
		return modelMapper.map(categoryRepository.findById(categoryId).get(), CategoryDTO.class);
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		
		
		return categoryRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, CategoryDTO.class))
				.collect(Collectors.toList());
		
	}

	@Override
	public CategoryDTO addCategory(Category category) {
		
	 return modelMapper.map(categoryRepository.save(category), CategoryDTO.class);

	}

	@Override
	public CategoryDTO updateCategory(Category category) {
		
		Category categoryToUpdate = categoryRepository.findById(category.getCategoryId()).get();
		
		categoryToUpdate.setCategoryName(category.getCategoryName());
		categoryToUpdate.setCatalog(category.getCatalog());
		categoryToUpdate.setCategoryImage(category.getCategoryImage());
		categoryToUpdate.setDescription(category.getDescription());
		categoryToUpdate.setCreateDatetime(category.getCreateDatetime());
		categoryToUpdate.setStatus(category.getStatus());

		return modelMapper.map(categoryRepository.save(categoryToUpdate), CategoryDTO.class);

	}

	@Override
	public void deleteCategory(long categoryId) {

		categoryRepository.deleteById(categoryId);
		
	}

}

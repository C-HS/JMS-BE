package com.inventory.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.product.service.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}

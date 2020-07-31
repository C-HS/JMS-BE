package com.inventory.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.product.service.model.ProductAttribute;


public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, Long>{

}

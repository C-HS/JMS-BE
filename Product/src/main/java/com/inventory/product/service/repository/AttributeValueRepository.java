package com.inventory.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inventory.product.service.model.AttributeValue;


public interface AttributeValueRepository extends JpaRepository<AttributeValue, Long>  {

}

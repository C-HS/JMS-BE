package com.inventory.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.product.service.model.ProductSalesTax;

@Repository
public interface ProductSalesTaxRepository extends JpaRepository<ProductSalesTax, Long>  {

}

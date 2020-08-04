package com.inventory.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.product.service.model.ProductVendor;

@Repository
public interface ProductVendorRepository extends JpaRepository<ProductVendor, Long> {

}

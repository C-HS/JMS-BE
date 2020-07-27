package com.iaito.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iaito.product.service.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

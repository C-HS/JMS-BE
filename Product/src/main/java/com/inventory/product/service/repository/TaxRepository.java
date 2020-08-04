package com.inventory.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.product.service.model.Tax;

@Repository
public interface TaxRepository extends JpaRepository<Tax, Long> {

}

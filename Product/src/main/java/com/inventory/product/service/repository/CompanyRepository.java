package com.inventory.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.product.service.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}

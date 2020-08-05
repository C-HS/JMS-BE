package com.inventory.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inventory.product.service.model.CompanyContact;

@Repository
public interface CompanyContactRepository extends JpaRepository<CompanyContact, Long>  {

}

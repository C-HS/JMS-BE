package com.iaito.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.accounting.model.BillProductTax;

@Repository
public interface BillProductTaxRepository extends JpaRepository<BillProductTax, Long>{

}

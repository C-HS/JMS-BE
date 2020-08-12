package com.iaito.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.accounting.model.InvoiceProductTax;

@Repository
public interface InvoiceProductTaxRepository extends JpaRepository<InvoiceProductTax, Long>   {

}

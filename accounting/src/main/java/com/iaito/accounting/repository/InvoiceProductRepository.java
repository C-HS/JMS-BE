package com.iaito.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.accounting.model.InvoiceProduct;

@Repository
public interface InvoiceProductRepository extends JpaRepository<InvoiceProduct, Long>    {

}

package com.iaito.accounting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.accounting.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long>    {

}

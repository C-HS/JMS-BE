package com.iaito.order.repository.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.order.model.purchase.PurchaseOrderProductTax;

@Repository
public interface PurchaseOrderProductTaxRepository  extends JpaRepository<PurchaseOrderProductTax, Long>{

}

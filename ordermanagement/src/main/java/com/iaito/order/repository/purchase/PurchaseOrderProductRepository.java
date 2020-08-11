package com.iaito.order.repository.purchase;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iaito.order.model.purchase.PurchaseOrderProduct;

public interface PurchaseOrderProductRepository  extends JpaRepository<PurchaseOrderProduct, Long>  {

}

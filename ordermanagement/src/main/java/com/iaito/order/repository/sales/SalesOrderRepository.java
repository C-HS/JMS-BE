package com.iaito.order.repository.sales;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.order.model.sales.SalesOrder;


@Repository
public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long>  {

    
}
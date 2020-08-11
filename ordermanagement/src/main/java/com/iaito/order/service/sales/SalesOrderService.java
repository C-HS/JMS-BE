package com.iaito.order.service.sales;

import java.util.List;

import com.iaito.order.dto.sales.SalesOrderDTO;
import com.iaito.order.model.sales.SalesOrder;


public interface SalesOrderService{

    public SalesOrderDTO getSalesOrderById(long salesOrderId);
    public List<SalesOrderDTO> getAllSalesOrders();
    public SalesOrderDTO addSalesOrder(SalesOrder salesOrder);
    public SalesOrderDTO updateSalesOrder(SalesOrder salesOrder);
    public void deleteSalesOrder(long salesOrderId);
}
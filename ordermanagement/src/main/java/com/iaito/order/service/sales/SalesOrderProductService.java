package com.iaito.order.service.sales;

import java.util.List;

import com.iaito.order.dto.sales.SalesOrderProductDTO;
import com.iaito.order.model.sales.SalesOrderProduct;

public interface SalesOrderProductService{

    public SalesOrderProductDTO getSalesOrderProductById(long salesOrderProductId);
    public List<SalesOrderProductDTO> getAllSalesOrderProducts();
    public SalesOrderProductDTO addSalesOrderProduct(SalesOrderProduct salesOrderProduct);
    public SalesOrderProductDTO updateSalesOrderProduct(SalesOrderProduct salesOrderProduct);
    public void deleteSalesOrderProduct(long salesOrderProductId);

    
}
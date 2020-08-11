package com.iaito.order.service.sales;

import java.util.List;

import com.iaito.order.dto.sales.SalesOrderProductTaxDTO;
import com.iaito.order.model.sales.SalesOrderProductTax;

public interface SalesOrderProductTaxService{

    public SalesOrderProductTaxDTO getSalesOrderProductTaxById(long salesOrderProductTaxId);
    public List<SalesOrderProductTaxDTO> getAllSalesOrderProductTaxes();
    public SalesOrderProductTaxDTO addSalesOrderProductTax(SalesOrderProductTax salesOrderProductTax);
    public SalesOrderProductTaxDTO updateSalesOrderProductTax(SalesOrderProductTax salesOrderProductTax);
    public void deleteSalesOrderProductTax(long salesOrderProductTaxId);

    
}
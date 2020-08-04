package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.TaxDTO;
import com.inventory.product.service.model.Tax;

public interface TaxService {
	
    public TaxDTO getTaxById(long taxId);
    public List<TaxDTO> getAllTaxes();
    public TaxDTO addTax(Tax tax);
    public TaxDTO updateTax(Tax tax);
    public void deleteTax(long taxId);

}

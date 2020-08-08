package com.iaito.settings.service;

import java.util.List;

import com.iaito.settings.dto.TaxDTO;
import com.iaito.settings.model.Tax;


public interface TaxService {
	
    public TaxDTO getTaxById(long taxId);
    public List<TaxDTO> getAllTaxes();
    public TaxDTO addTax(Tax tax);
    public TaxDTO updateTax(Tax tax);
    public void deleteTax(long taxId);

}

package com.iaito.accounting.service;

import java.util.List;

import com.iaito.accounting.dto.BillProductTaxDTO;
import com.iaito.accounting.model.BillProductTax;

public interface BillProductTaxService {

    public BillProductTaxDTO getBillProductTaxById(long billProductTaxId);
    public List<BillProductTaxDTO> getAllBillProductTaxes();
    public BillProductTaxDTO addBillProductTax(BillProductTax billProductTax);
    public BillProductTaxDTO updateBillProductTax(BillProductTax billProductTax);
    public void deleteBillProductTax(long billProductTaxId);
}

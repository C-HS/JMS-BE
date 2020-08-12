package com.iaito.accounting.service;

import java.util.List;

import com.iaito.accounting.dto.InvoiceProductTaxDTO;
import com.iaito.accounting.model.InvoiceProductTax;

public interface InvoiceProductTaxService {
	
    public InvoiceProductTaxDTO getInvoiceProductTaxById(long invoiceProductTaxId);
    public List<InvoiceProductTaxDTO> getAllInvoiceProductTaxes();
    public InvoiceProductTaxDTO addInvoiceProductTax(InvoiceProductTax invoiceProductTax);
    public InvoiceProductTaxDTO updateInvoiceProductTax(InvoiceProductTax invoiceProductTax);
    public void deleteInvoiceProductTax(long invoiceProductTaxId);

}

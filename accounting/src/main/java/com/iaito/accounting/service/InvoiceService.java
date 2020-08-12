package com.iaito.accounting.service;

import java.util.List;

import com.iaito.accounting.dto.InvoiceDTO;
import com.iaito.accounting.model.Invoice;


public interface InvoiceService {
	
    public InvoiceDTO getInvoiceById(long invoiceId);
    public List<InvoiceDTO> getAllInvoices();
    public InvoiceDTO addInvoice(Invoice invoice);
    public InvoiceDTO updateInvoice(Invoice invoice);
    public void deleteInvoice(long invoiceId);

}

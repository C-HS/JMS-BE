package com.iaito.accounting.service;

import java.util.List;

import com.iaito.accounting.dto.InvoiceProductDTO;
import com.iaito.accounting.model.InvoiceProduct;

public interface InvoiceProductService {
	
    public InvoiceProductDTO getInvoiceProductById(long invoiceProductId);
    public List<InvoiceProductDTO> getAllInvoiceProducts();
    public InvoiceProductDTO addInvoiceProduct(InvoiceProduct invoiceProduct);
    public InvoiceProductDTO updateInvoiceProduct(InvoiceProduct invoiceProduct);
    public void deleteInvoiceProduct(long invoiceProductId);

}

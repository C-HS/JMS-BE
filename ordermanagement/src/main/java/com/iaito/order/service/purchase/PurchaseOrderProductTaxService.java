package com.iaito.order.service.purchase;

import java.util.List;

import com.iaito.order.dto.purchase.PurchaseOrderProductTaxDTO;
import com.iaito.order.model.purchase.PurchaseOrderProductTax;

public interface PurchaseOrderProductTaxService {
	
    public PurchaseOrderProductTaxDTO getPurchaseOrderProductTaxById(long purchaseOrderProductTaxId);
    public List<PurchaseOrderProductTaxDTO> getAllPurchaseOrderProductTaxes();
    public PurchaseOrderProductTaxDTO addPurchaseOrderProductTax(PurchaseOrderProductTax purchaseOrderProductTax);
    public PurchaseOrderProductTaxDTO updatePurchaseOrderProductTax(PurchaseOrderProductTax purchaseOrderProductTax);
    public void deletePurchaseOrderProductTax(long purchaseOrderProductTaxId);

}

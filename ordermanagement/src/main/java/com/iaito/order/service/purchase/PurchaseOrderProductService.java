package com.iaito.order.service.purchase;

import java.util.List;

import com.iaito.order.dto.purchase.PurchaseOrderProductDTO;
import com.iaito.order.model.purchase.PurchaseOrderProduct;

public interface PurchaseOrderProductService {

    public PurchaseOrderProductDTO getPurchaseOrderProductById(long purchaseOrderProductId);
    public List<PurchaseOrderProductDTO> getAllPurchaseOrderProducts();
    public PurchaseOrderProductDTO addPurchaseOrderProduct(PurchaseOrderProduct purchaseOrderProduct);
    public PurchaseOrderProductDTO updatePurchaseOrderProduct(PurchaseOrderProduct purchaseOrderProduct);
    public void deletePurchaseOrderProduct(long purchaseOrderProductId);
}

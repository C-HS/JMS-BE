package com.iaito.order.service.purchase;

import java.util.List;

import com.iaito.order.dto.purchase.PurchaseOrderDTO;
import com.iaito.order.model.purchase.PurchaseOrder;

public interface PurchaseOrderService {

    public PurchaseOrderDTO getPurchaseOrderById(long purchaseOrderId);
    public List<PurchaseOrderDTO> getAllPurchaseOrders();
    public PurchaseOrderDTO addPurchaseOrder(PurchaseOrder purchaseOrder);
    public PurchaseOrderDTO updatePurchaseOrder(PurchaseOrder purchaseOrder);
    public void deletePurchaseOrder(long purchaseOrderId);

}

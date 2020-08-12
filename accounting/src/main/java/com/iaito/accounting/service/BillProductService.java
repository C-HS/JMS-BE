package com.iaito.accounting.service;

import java.util.List;

import com.iaito.accounting.dto.BillProductDTO;
import com.iaito.accounting.model.BillProduct;

public interface BillProductService {

    public BillProductDTO getBillProductById(long billProductId);
    public List<BillProductDTO> getAllBillProducts();
    public BillProductDTO addBillProduct(BillProduct billProduct);
    public BillProductDTO updateBillProduct(BillProduct billProduct);
    public void deleteBillProduct(long billProductId);
}

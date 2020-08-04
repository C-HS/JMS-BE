package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.ProductPurchaseTaxDTO;
import com.inventory.product.service.model.ProductPurchaseTax;

public interface ProductPurchaseTaxService {
	
    public ProductPurchaseTaxDTO getProductPurchaseTaxById(long productPurchaseTaxId);
    public List<ProductPurchaseTaxDTO> getAllProductPurchaseTaxes();
    public ProductPurchaseTaxDTO addProductPurchaseTax(ProductPurchaseTax productPurchaseTax);
    public ProductPurchaseTaxDTO updateProductPurchaseTax(ProductPurchaseTax productPurchaseTax);
    public void deleteProductPurchaseTax(long productPurchaseTaxId);

}

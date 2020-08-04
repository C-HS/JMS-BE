package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.ProductSalesTaxDTO;
import com.inventory.product.service.model.ProductSalesTax;

public interface ProductSalesTaxService {
	
    public ProductSalesTaxDTO getProductSalesTaxById(long productSalesTaxId);
    public List<ProductSalesTaxDTO> getAllProductSalesTaxes();
    public ProductSalesTaxDTO addProductSalesTax(ProductSalesTax productSalesTax);
    public ProductSalesTaxDTO updateProductSalesTax(ProductSalesTax productSalesTax);
    public void deleteProductSalesTax(long productSalesTaxId);

}

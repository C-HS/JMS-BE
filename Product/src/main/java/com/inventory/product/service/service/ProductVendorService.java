package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.ProductVendorDTO;
import com.inventory.product.service.model.ProductVendor;

public interface ProductVendorService {
    public ProductVendorDTO getProductVendorById(long productVendorId);
    public List<ProductVendorDTO> getAllProductVendors();
    public ProductVendorDTO addProductVendor(ProductVendor productVendor);
    public ProductVendorDTO updateProductVendor(ProductVendor productVendor);
    public void deleteProductVendor(long productVendorId);

}

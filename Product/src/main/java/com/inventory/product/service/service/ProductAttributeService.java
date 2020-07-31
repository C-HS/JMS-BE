package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.ProductAttributeDTO;
import com.inventory.product.service.model.ProductAttribute;

public interface ProductAttributeService {
	
    public ProductAttributeDTO getProductAttributeId(long attributeId);
    public List<ProductAttributeDTO> getAllProductAttribute();
    public ProductAttributeDTO addProductAttribute(ProductAttribute productAttribute);
    public ProductAttributeDTO updateProductAttribute(ProductAttribute productAttribute);
    public void deleteProductAttribute(long attributeId);

}

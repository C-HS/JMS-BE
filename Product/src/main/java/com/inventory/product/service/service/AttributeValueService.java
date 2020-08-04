package com.inventory.product.service.service;

import java.util.List;

import com.inventory.product.service.dto.AttributeValueDTO;
import com.inventory.product.service.model.AttributeValue;

public interface AttributeValueService {
	
    public AttributeValueDTO getAttributeValueById(long attributeValueId);
    public List<AttributeValueDTO> getAllAttributeValue();
    public AttributeValueDTO addAttributeValue(AttributeValue attributeValue);
    public AttributeValueDTO updateAttributeValue(AttributeValue attributeValue);
    public void deleteAttributeValue(long attributeValueId);

}

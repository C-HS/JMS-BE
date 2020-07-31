package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.ProductAttributeDTO;
import com.inventory.product.service.model.ProductAttribute;
import com.inventory.product.service.repository.ProductAttributeRepository;
import com.inventory.product.service.service.ProductAttributeService;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService{

	Logger logger = LoggerFactory.getLogger(ProductAttributeServiceImpl.class);
	@Autowired ModelMapper modelMapper;
	@Autowired ProductAttributeRepository productAttributeRepository;
	
	@Override
	public ProductAttributeDTO getProductAttributeId(long attributeId) {
		
		return modelMapper.map(productAttributeRepository.findById(attributeId).get(), ProductAttributeDTO.class);
	}

	@Override
	public List<ProductAttributeDTO> getAllProductAttribute() {
		return productAttributeRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, ProductAttributeDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductAttributeDTO addProductAttribute(ProductAttribute productAttribute) {
		return modelMapper.map(productAttributeRepository.save(productAttribute), ProductAttributeDTO.class);
	}

	@Override
	public ProductAttributeDTO updateProductAttribute(ProductAttribute productAttribute) {

		ProductAttribute productAttributeToUpdate = productAttributeRepository.findById(productAttribute.getAttributeId()).get();

		productAttributeToUpdate.setAttributeName(productAttribute.getAttributeName());
		productAttributeToUpdate.setUom(productAttribute.getUom());
		productAttributeToUpdate.setCreateDatetime(productAttribute.getCreateDatetime());
		productAttributeToUpdate.setStatus(productAttribute.getStatus());
		
		return modelMapper.map(productAttributeRepository.save(productAttributeToUpdate), ProductAttributeDTO.class);
	}

	@Override
	public void deleteProductAttribute(long attributeId) {
		productAttributeRepository.deleteById(attributeId);
		
	}

}

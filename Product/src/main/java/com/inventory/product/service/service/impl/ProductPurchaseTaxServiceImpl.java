package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.ProductPurchaseTaxDTO;
import com.inventory.product.service.model.ProductPurchaseTax;
import com.inventory.product.service.repository.ProductPurchaseTaxRepository;
import com.inventory.product.service.service.ProductPurchaseTaxService;

@Service
public class ProductPurchaseTaxServiceImpl implements ProductPurchaseTaxService{
	
	Logger logger = LoggerFactory.getLogger(ProductPurchaseTaxServiceImpl.class);
	
    @Autowired ModelMapper modelMapper;
	@Autowired ProductPurchaseTaxRepository productPurchaseTaxRepository;

	@Override
	public ProductPurchaseTaxDTO getProductPurchaseTaxById(long productPurchaseTaxId) {

		return modelMapper.map(productPurchaseTaxRepository.findById(productPurchaseTaxId).get(), ProductPurchaseTaxDTO.class);
	}

	@Override
	public List<ProductPurchaseTaxDTO> getAllProductPurchaseTaxes() {
		return productPurchaseTaxRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e,ProductPurchaseTaxDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductPurchaseTaxDTO addProductPurchaseTax(ProductPurchaseTax productPurchaseTax) {

		productPurchaseTax.setCreateDatetime(new java.util.Date());
		productPurchaseTax.setStatus("Active");
		
		return modelMapper.map(productPurchaseTaxRepository.save(productPurchaseTax), ProductPurchaseTaxDTO.class);
	}

	@Override
	public ProductPurchaseTaxDTO updateProductPurchaseTax(ProductPurchaseTax productPurchaseTax) {

		ProductPurchaseTax productPurchaseTaxToUpdate = productPurchaseTaxRepository.findById(productPurchaseTax.getProductPurchaseTaxId()).get();
		
		productPurchaseTaxToUpdate.setProductId(productPurchaseTax.getProductId());
		productPurchaseTaxToUpdate.setTaxId(productPurchaseTax.getTaxId());

		return modelMapper.map(productPurchaseTaxRepository.save(productPurchaseTaxToUpdate), ProductPurchaseTaxDTO.class);
	}

	@Override
	public void deleteProductPurchaseTax(long productPurchaseTaxId) {

		productPurchaseTaxRepository.deleteById(productPurchaseTaxId);
		
	}

}

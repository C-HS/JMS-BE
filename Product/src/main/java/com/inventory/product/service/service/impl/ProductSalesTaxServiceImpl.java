package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.ProductSalesTaxDTO;
import com.inventory.product.service.model.ProductSalesTax;
import com.inventory.product.service.repository.ProductSalesTaxRepository;
import com.inventory.product.service.service.ProductSalesTaxService;

@Service
public class ProductSalesTaxServiceImpl implements ProductSalesTaxService{
	
	Logger logger = LoggerFactory.getLogger(ProductSalesTaxServiceImpl.class);
	
    @Autowired ModelMapper modelMapper;
	@Autowired ProductSalesTaxRepository productSalesTaxRepository;

	@Override
	public ProductSalesTaxDTO getProductSalesTaxById(long productSalesTaxId) {

		return modelMapper.map(productSalesTaxRepository.findById(productSalesTaxId).get(), ProductSalesTaxDTO.class);
	}

	@Override
	public List<ProductSalesTaxDTO> getAllProductSalesTaxes() {

		return productSalesTaxRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e,ProductSalesTaxDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductSalesTaxDTO addProductSalesTax(ProductSalesTax productSalesTax) {

		productSalesTax.setCreateDatetime(new java.util.Date());
		productSalesTax.setStatus("Active");
		
		return modelMapper.map(productSalesTaxRepository.save(productSalesTax), ProductSalesTaxDTO.class);
	}

	@Override
	public ProductSalesTaxDTO updateProductSalesTax(ProductSalesTax productSalesTax) {

		ProductSalesTax productSalesTaxToUpdate = productSalesTaxRepository.findById(productSalesTax.getProductSalesTaxId()).get();
		
		productSalesTaxToUpdate.setProduct(productSalesTax.getProduct());
		productSalesTaxToUpdate.setTaxId(productSalesTax.getTaxId());

		return modelMapper.map(productSalesTaxRepository.save(productSalesTaxToUpdate), ProductSalesTaxDTO.class);
	}

	@Override
	public void deleteProductSalesTax(long productSalesTaxId) {
		productSalesTaxRepository.deleteById(productSalesTaxId);
		
	}

}

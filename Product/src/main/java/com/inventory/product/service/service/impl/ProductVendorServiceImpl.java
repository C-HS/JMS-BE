package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.ProductVendorDTO;
import com.inventory.product.service.model.ProductVendor;
import com.inventory.product.service.repository.ProductVendorRepository;
import com.inventory.product.service.service.ProductVendorService;


@Service
public class ProductVendorServiceImpl implements ProductVendorService{
	
	
Logger logger = LoggerFactory.getLogger(ProductVendorServiceImpl.class);
	
    @Autowired ModelMapper modelMapper;
	@Autowired ProductVendorRepository productVendorRepository;

	@Override
	public ProductVendorDTO getProductVendorById(long productVendorId) {

		return modelMapper.map(productVendorRepository.findById(productVendorId).get(), ProductVendorDTO.class);
	}

	@Override
	public List<ProductVendorDTO> getAllProductVendors() {

		return productVendorRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e,ProductVendorDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProductVendorDTO addProductVendor(ProductVendor productVendor) {

		productVendor.setCreateDatetime(new java.util.Date());
		productVendor.setStatus("Active");
		
		return modelMapper.map(productVendorRepository.save(productVendor), ProductVendorDTO.class);
	}

	@Override
	public ProductVendorDTO updateProductVendor(ProductVendor productVendor) {

		ProductVendor productVendorToUpdate = productVendorRepository.findById(productVendor.getProductVendorId()).get();
		
		productVendorToUpdate.setProduct(productVendor.getProduct());
		productVendorToUpdate.setVendorId(productVendor.getVendorId());
		productVendorToUpdate.setCostPrice(productVendor.getCostPrice());
		productVendorToUpdate.setCurrencyId(productVendor.getCurrencyId());

		return modelMapper.map(productVendorRepository.save(productVendorToUpdate), ProductVendorDTO.class);
	}

	@Override
	public void deleteProductVendor(long productVendorId) {

		productVendorRepository.deleteById(productVendorId);
		
	}

}

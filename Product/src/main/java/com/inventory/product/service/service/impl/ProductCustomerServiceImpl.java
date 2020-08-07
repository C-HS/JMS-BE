package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.inventory.product.service.dto.ProductCustomerDTO;
import com.inventory.product.service.model.ProductCustomer;
import com.inventory.product.service.repository.ProductCustomerRepository;
import com.inventory.product.service.service.ProductCustomerService;

@Service
public class ProductCustomerServiceImpl implements ProductCustomerService{
	
Logger logger = LoggerFactory.getLogger(ProductCustomerServiceImpl.class);
	
    @Autowired ModelMapper modelMapper;
	@Autowired ProductCustomerRepository productCustomerRepository;

	@Override
	public ProductCustomerDTO getProductCustomerById(long productCustomerId) {

		return modelMapper.map(productCustomerRepository.findById(productCustomerId).get(), ProductCustomerDTO.class);
	}

	@Override
	public List<ProductCustomerDTO> getAllProductCustomers() {

		return productCustomerRepository
							.findAll()
							.stream()
							.map(e->modelMapper.map(e,ProductCustomerDTO.class))
							.collect(Collectors.toList());
	}

	@Override
	public ProductCustomerDTO addProductCustomer(ProductCustomer productCustomer) {

		productCustomer.setCreateDatetime(new java.util.Date());
		productCustomer.setStatus("Active");
		
		return modelMapper.map(productCustomerRepository.save(productCustomer), ProductCustomerDTO.class);

	}

	@Override
	public ProductCustomerDTO updateProductCustomer(ProductCustomer productCustomer) {

		ProductCustomer productCustomerToUpdate = productCustomerRepository.findById(productCustomer.getProductCustomerId()).get();
		
		productCustomerToUpdate.setProduct(productCustomer.getProduct());
		productCustomerToUpdate.setCustomerId(productCustomer.getCustomerId());
		productCustomerToUpdate.setSalesPrice(productCustomer.getSalesPrice());
		productCustomerToUpdate.setCurrencyId(productCustomer.getCurrencyId());

		return modelMapper.map(productCustomerRepository.save(productCustomerToUpdate), ProductCustomerDTO.class);
	}

	@Override
	public void deleteProductCustomer(long productCustomerId) {
		productCustomerRepository.deleteById(productCustomerId);
		
	}

}

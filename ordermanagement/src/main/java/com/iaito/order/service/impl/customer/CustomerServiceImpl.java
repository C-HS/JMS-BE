package com.iaito.order.service.impl.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.customer.CustomerDTO;
import com.iaito.order.model.customer.Customer;
import com.iaito.order.repository.customer.CustomerRepository;
import com.iaito.order.service.customer.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired CustomerRepository customerRepository;

	@Override
	public CustomerDTO getCustomerById(long customerId) {

		return modelMapper.map(customerRepository.findById(customerId).get(), CustomerDTO.class);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {

		return customerRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, CustomerDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO addCustomer(Customer customer) {

		customer.setCreateDatetime(new java.util.Date());
		customer.setStatus("Active");
		
		return modelMapper.map(customerRepository.save(customer), CustomerDTO.class);
	}

	@Override
	public CustomerDTO updateCustomer(Customer customer) {

		Customer customerToUpdate = customerRepository.findById(customer.getCustomerId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(customerRepository.save(customerToUpdate), CustomerDTO.class);
	}

	@Override
	public void deleteCustomer(long customerId) {

		customerRepository.deleteById(customerId);
		
	}

}

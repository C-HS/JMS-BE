package com.iaito.order.service.impl.customer;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.customer.CustomerContactDTO;
import com.iaito.order.model.customer.CustomerContact;
import com.iaito.order.repository.customer.CustomerContactRepository;
import com.iaito.order.service.customer.CustomerContactService;

@Service
public class CustomerContactServiceImpl implements CustomerContactService{
	
	Logger logger = LoggerFactory.getLogger(CustomerContactServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired CustomerContactRepository customerContactRepository;

	@Override
	public CustomerContactDTO getCustomerContactById(long customerContactId) {

		return modelMapper.map(customerContactRepository.findById(customerContactId).get(), CustomerContactDTO.class);
	}

	@Override
	public List<CustomerContactDTO> getAllCustomerContacts() {

		return customerContactRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, CustomerContactDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerContactDTO addCustomerContact(CustomerContact customerContact) {

		customerContact.setCreateDatetime(new java.util.Date());
		customerContact.setStatus("Active");
		
		return modelMapper.map(customerContactRepository.save(customerContact), CustomerContactDTO.class);
	}

	@Override
	public CustomerContactDTO updateCustomerContact(CustomerContact customerContact) {

		CustomerContact customerContactToUpdate = customerContactRepository.findById(customerContact.getCustomerContactId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(customerContactRepository.save(customerContactToUpdate), CustomerContactDTO.class);
	}

	@Override
	public void deleteCustomerContact(long customerContactId) {

		customerContactRepository.deleteById(customerContactId);
		
	}

}

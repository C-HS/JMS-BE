package com.iaito.accounting.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.accounting.dto.InvoiceProductTaxDTO;
import com.iaito.accounting.model.InvoiceProductTax;
import com.iaito.accounting.repository.InvoiceProductTaxRepository;
import com.iaito.accounting.service.InvoiceProductTaxService;

@Service
public class InvoiceProductTaxServiceImpl implements InvoiceProductTaxService{
	
	Logger logger = LoggerFactory.getLogger(InvoiceProductTaxServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired InvoiceProductTaxRepository invoiceProductTaxRepository;

	@Override
	public InvoiceProductTaxDTO getInvoiceProductTaxById(long invoiceProductTaxId) {
		
		return modelMapper.map(invoiceProductTaxRepository.findById(invoiceProductTaxId).get(), InvoiceProductTaxDTO.class);
	}

	@Override
	public List<InvoiceProductTaxDTO> getAllInvoiceProductTaxes() {

		return invoiceProductTaxRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, InvoiceProductTaxDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public InvoiceProductTaxDTO addInvoiceProductTax(InvoiceProductTax invoiceProductTax) {

		invoiceProductTax.setCreateDatetime(new java.util.Date());
		invoiceProductTax.setStatus("Active");
		
		return modelMapper.map(invoiceProductTaxRepository.save(invoiceProductTax), InvoiceProductTaxDTO.class);
	}

	@Override
	public InvoiceProductTaxDTO updateInvoiceProductTax(InvoiceProductTax invoiceProductTax) {

		InvoiceProductTax invoiceProductTaxToUpdate = invoiceProductTaxRepository.findById(invoiceProductTax.getInvoiceProductTaxId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(invoiceProductTaxRepository.save(invoiceProductTaxToUpdate), InvoiceProductTaxDTO.class);
	}

	@Override
	public void deleteInvoiceProductTax(long invoiceProductTaxId) {

		invoiceProductTaxRepository.deleteById(invoiceProductTaxId);
		
	}

}

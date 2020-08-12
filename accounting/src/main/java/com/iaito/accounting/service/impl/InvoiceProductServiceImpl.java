package com.iaito.accounting.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.accounting.dto.InvoiceProductDTO;
import com.iaito.accounting.model.InvoiceProduct;
import com.iaito.accounting.repository.InvoiceProductRepository;
import com.iaito.accounting.service.InvoiceProductService;

@Service
public class InvoiceProductServiceImpl implements InvoiceProductService{
	
	Logger logger = LoggerFactory.getLogger(InvoiceProductServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired InvoiceProductRepository invoiceProductRepository;

	@Override
	public InvoiceProductDTO getInvoiceProductById(long invoiceProductId) {
		
		return modelMapper.map(invoiceProductRepository.findById(invoiceProductId).get(), InvoiceProductDTO.class);
	}

	@Override
	public List<InvoiceProductDTO> getAllInvoiceProducts() {

		return invoiceProductRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, InvoiceProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public InvoiceProductDTO addInvoiceProduct(InvoiceProduct invoiceProduct) {

		invoiceProduct.setCreateDatetime(new java.util.Date());
		invoiceProduct.setStatus("Active");
		
		return modelMapper.map(invoiceProductRepository.save(invoiceProduct), InvoiceProductDTO.class);
	}

	@Override
	public InvoiceProductDTO updateInvoiceProduct(InvoiceProduct invoiceProduct) {

		InvoiceProduct invoiceProductToUpdate = invoiceProductRepository.findById(invoiceProduct.getInvoiceProductId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(invoiceProductRepository.save(invoiceProductToUpdate), InvoiceProductDTO.class);
	}

	@Override
	public void deleteInvoiceProduct(long invoiceProductId) {

		invoiceProductRepository.deleteById(invoiceProductId);
		
	}

}

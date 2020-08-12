package com.iaito.accounting.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.accounting.dto.InvoiceDTO;
import com.iaito.accounting.model.Invoice;
import com.iaito.accounting.repository.InvoiceRepository;
import com.iaito.accounting.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	Logger logger = LoggerFactory.getLogger(InvoiceServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired InvoiceRepository invoiceRepository;

	@Override
	public InvoiceDTO getInvoiceById(long invoiceId) {

		return modelMapper.map(invoiceRepository.findById(invoiceId).get(), InvoiceDTO.class);
	}

	@Override
	public List<InvoiceDTO> getAllInvoices() {

		return invoiceRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, InvoiceDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public InvoiceDTO addInvoice(Invoice invoice) {
		invoice.setCreateDatetime(new java.util.Date());
		invoice.setInvoiceStatus("Draft");
		
		return modelMapper.map(invoiceRepository.save(invoice), InvoiceDTO.class);
	}

	@Override
	public InvoiceDTO updateInvoice(Invoice invoice) {

		Invoice invoiceToUpdate = invoiceRepository.findById(invoice.getInvoiceId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(invoiceRepository.save(invoiceToUpdate), InvoiceDTO.class);
	}

	@Override
	public void deleteInvoice(long invoiceId) {
		
		invoiceRepository.deleteById(invoiceId);
		
	}

}

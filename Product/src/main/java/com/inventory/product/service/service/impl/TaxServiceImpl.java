package com.inventory.product.service.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.product.service.dto.TaxDTO;
import com.inventory.product.service.model.Tax;
import com.inventory.product.service.repository.TaxRepository;
import com.inventory.product.service.service.TaxService;

@Service
public class TaxServiceImpl implements TaxService{

	Logger logger = LoggerFactory.getLogger(TaxServiceImpl.class);
	
    @Autowired ModelMapper modelMapper;
	@Autowired TaxRepository taxRepository;
	
	@Override
	public TaxDTO getTaxById(long taxId) {

		return modelMapper.map(taxRepository.findById(taxId).get(), TaxDTO.class);
	}

	@Override
	public List<TaxDTO> getAllTaxes() {
		
		return taxRepository
					.findAll()
					.stream()
					.map(e->modelMapper.map(e,TaxDTO.class))
					.collect(Collectors.toList());
	}

	@Override
	public TaxDTO addTax(Tax tax) {

		tax.setCreateDatetime(new java.util.Date());
		tax.setStatus("Active");
		
		return modelMapper.map(taxRepository.save(tax), TaxDTO.class);
	}

	@Override
	public TaxDTO updateTax(Tax tax) {

		Tax taxToUpdate = taxRepository.findById(tax.getTaxId()).get();
		
		taxToUpdate.setTaxDetail(tax.getTaxDetail());
		taxToUpdate.setTaxPercent(tax.getTaxPercent());
		taxToUpdate.setDescription(tax.getDescription());

		return modelMapper.map(taxRepository.save(taxToUpdate), TaxDTO.class);
	}

	@Override
	public void deleteTax(long taxId) {
		
		taxRepository.deleteById(taxId);
		
	}

}

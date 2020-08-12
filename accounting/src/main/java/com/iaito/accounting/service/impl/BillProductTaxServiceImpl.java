package com.iaito.accounting.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.accounting.dto.BillProductTaxDTO;
import com.iaito.accounting.model.BillProductTax;
import com.iaito.accounting.repository.BillProductTaxRepository;
import com.iaito.accounting.service.BillProductTaxService;

@Service
public class BillProductTaxServiceImpl implements BillProductTaxService{
	
	Logger logger = LoggerFactory.getLogger(BillProductTaxServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired BillProductTaxRepository billProductTaxRepository;

	@Override
	public BillProductTaxDTO getBillProductTaxById(long billProductTaxId) {

		return modelMapper.map(billProductTaxRepository.findById(billProductTaxId).get(), BillProductTaxDTO.class);
	}

	@Override
	public List<BillProductTaxDTO> getAllBillProductTaxes() {

		return billProductTaxRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, BillProductTaxDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public BillProductTaxDTO addBillProductTax(BillProductTax billProductTax) {

		billProductTax.setCreateDatetime(new java.util.Date());
		billProductTax.setStatus("Active");
		
		return modelMapper.map(billProductTaxRepository.save(billProductTax), BillProductTaxDTO.class);
	}

	@Override
	public BillProductTaxDTO updateBillProductTax(BillProductTax billProductTax) {


		
		BillProductTax billProductTaxToUpdate = billProductTaxRepository.findById(billProductTax.getBillProductTaxId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(billProductTaxRepository.save(billProductTaxToUpdate), BillProductTaxDTO.class);
	}

	@Override
	public void deleteBillProductTax(long billProductTaxId) {

		billProductTaxRepository.deleteById(billProductTaxId);
		
	}

}

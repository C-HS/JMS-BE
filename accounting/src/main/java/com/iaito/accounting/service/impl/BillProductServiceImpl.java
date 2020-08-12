package com.iaito.accounting.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.accounting.dto.BillProductDTO;
import com.iaito.accounting.model.BillProduct;
import com.iaito.accounting.repository.BillProductRepository;
import com.iaito.accounting.service.BillProductService;

@Service
public class BillProductServiceImpl implements BillProductService{
	
	Logger logger = LoggerFactory.getLogger(BillProductServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired BillProductRepository billProductRepository;

	@Override
	public BillProductDTO getBillProductById(long billProductId) {

		return modelMapper.map(billProductRepository.findById(billProductId).get(), BillProductDTO.class);
	}

	@Override
	public List<BillProductDTO> getAllBillProducts() {

		return billProductRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, BillProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public BillProductDTO addBillProduct(BillProduct billProduct) {

		billProduct.setCreateDatetime(new java.util.Date());
		billProduct.setStatus("Active");
		
		return modelMapper.map(billProductRepository.save(billProduct), BillProductDTO.class);
	}

	@Override
	public BillProductDTO updateBillProduct(BillProduct billProduct) {

		BillProduct billProductToUpdate = billProductRepository.findById(billProduct.getBillProductId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(billProductRepository.save(billProductToUpdate), BillProductDTO.class);
	}

	@Override
	public void deleteBillProduct(long billProductId) {

		billProductRepository.deleteById(billProductId);
		
	}

}

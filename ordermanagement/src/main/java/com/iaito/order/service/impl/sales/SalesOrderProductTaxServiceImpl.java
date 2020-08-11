package com.iaito.order.service.impl.sales;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.sales.SalesOrderProductTaxDTO;
import com.iaito.order.model.sales.SalesOrderProductTax;
import com.iaito.order.repository.sales.SalesOrderProductTaxRepository;
import com.iaito.order.service.sales.SalesOrderProductTaxService;

@Service
public class SalesOrderProductTaxServiceImpl implements SalesOrderProductTaxService{

	Logger logger = LoggerFactory.getLogger(SalesOrderProductTaxServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired SalesOrderProductTaxRepository salesOrderProductTaxRepository;
	
	@Override
	public SalesOrderProductTaxDTO getSalesOrderProductTaxById(long salesOrderProductTaxId) {

		return modelMapper.map(salesOrderProductTaxRepository.findById(salesOrderProductTaxId).get(), SalesOrderProductTaxDTO.class);
	}

	@Override
	public List<SalesOrderProductTaxDTO> getAllSalesOrderProductTaxes() {

		return salesOrderProductTaxRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, SalesOrderProductTaxDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public SalesOrderProductTaxDTO addSalesOrderProductTax(SalesOrderProductTax salesOrderProductTax) {

		salesOrderProductTax.setCreateDatetime(new java.util.Date());
		salesOrderProductTax.setStatus("Active");
		
		return modelMapper.map(salesOrderProductTaxRepository.save(salesOrderProductTax), SalesOrderProductTaxDTO.class);
	}

	@Override
	public SalesOrderProductTaxDTO updateSalesOrderProductTax(SalesOrderProductTax salesOrderProductTax) {


		SalesOrderProductTax salesOrderProductTaxToUpdate = salesOrderProductTaxRepository.findById(salesOrderProductTax.getSalesOrderProductTaxId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(salesOrderProductTaxRepository.save(salesOrderProductTaxToUpdate), SalesOrderProductTaxDTO.class);
	}

	@Override
	public void deleteSalesOrderProductTax(long salesOrderProductTaxId) {

		salesOrderProductTaxRepository.deleteById(salesOrderProductTaxId);
		
	}

}

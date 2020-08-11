package com.iaito.order.service.impl.sales;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.sales.SalesOrderProductDTO;
import com.iaito.order.model.sales.SalesOrderProduct;
import com.iaito.order.repository.sales.SalesOrderProductRepository;
import com.iaito.order.service.sales.SalesOrderProductService;

@Service
public class SalesOrderProductServiceImpl implements SalesOrderProductService{
	
	Logger logger = LoggerFactory.getLogger(SalesOrderProductServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired SalesOrderProductRepository salesOrderProductRepository;

	@Override
	public SalesOrderProductDTO getSalesOrderProductById(long salesOrderProductId) {

		return modelMapper.map(salesOrderProductRepository.findById(salesOrderProductId).get(), SalesOrderProductDTO.class);
	}

	@Override
	public List<SalesOrderProductDTO> getAllSalesOrderProducts() {

		return salesOrderProductRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, SalesOrderProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public SalesOrderProductDTO addSalesOrderProduct(SalesOrderProduct salesOrderProduct) {
		
		salesOrderProduct.setCreateDatetime(new java.util.Date());
		salesOrderProduct.setStatus("Active");
		
		return modelMapper.map(salesOrderProductRepository.save(salesOrderProduct), SalesOrderProductDTO.class);
	}

	@Override
	public SalesOrderProductDTO updateSalesOrderProduct(SalesOrderProduct salesOrderProduct) {

		SalesOrderProduct salesOrderProductToUpdate = salesOrderProductRepository.findById(salesOrderProduct.getSalesOrderProductId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(salesOrderProductRepository.save(salesOrderProductToUpdate), SalesOrderProductDTO.class);
	}

	@Override
	public void deleteSalesOrderProduct(long salesOrderProductId) {

		salesOrderProductRepository.deleteById(salesOrderProductId);
		
	}

}

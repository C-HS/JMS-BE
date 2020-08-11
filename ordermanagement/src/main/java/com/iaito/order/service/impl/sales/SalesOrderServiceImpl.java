package com.iaito.order.service.impl.sales;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.sales.SalesOrderDTO;
import com.iaito.order.model.sales.SalesOrder;
import com.iaito.order.repository.sales.SalesOrderRepository;
import com.iaito.order.service.sales.SalesOrderService;


@Service
public class SalesOrderServiceImpl implements SalesOrderService{
	
	Logger logger = LoggerFactory.getLogger(SalesOrderServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired SalesOrderRepository salesOrderRepository;

	@Override
	public SalesOrderDTO getSalesOrderById(long salesOrderId) {

		return modelMapper.map(salesOrderRepository.findById(salesOrderId).get(), SalesOrderDTO.class);
	}

	@Override
	public List<SalesOrderDTO> getAllSalesOrders() {

		return salesOrderRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, SalesOrderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public SalesOrderDTO addSalesOrder(SalesOrder salesOrder) {

		salesOrder.setCreateDatetime(new java.util.Date());
		salesOrder.setOrderStatus("Quotation");
		
		return modelMapper.map(salesOrderRepository.save(salesOrder), SalesOrderDTO.class);
	}

	@Override
	public SalesOrderDTO updateSalesOrder(SalesOrder salesOrder) {

		SalesOrder salesOrderToUpdate = salesOrderRepository.findById(salesOrder.getSalesOrderId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(salesOrderRepository.save(salesOrderToUpdate), SalesOrderDTO.class);
	}

	@Override
	public void deleteSalesOrder(long salesOrderId) {

		salesOrderRepository.deleteById(salesOrderId);
		
	}

}

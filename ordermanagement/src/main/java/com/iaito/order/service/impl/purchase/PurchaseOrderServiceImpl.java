package com.iaito.order.service.impl.purchase;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.purchase.PurchaseOrderDTO;
import com.iaito.order.model.purchase.PurchaseOrder;
import com.iaito.order.repository.purchase.PurchaseOrderRepository;
import com.iaito.order.service.purchase.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{
	
	Logger logger = LoggerFactory.getLogger(PurchaseOrderServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired PurchaseOrderRepository purchaseOrderRepository;


	@Override
	public PurchaseOrderDTO getPurchaseOrderById(long purchaseOrderId) {

		return modelMapper.map(purchaseOrderRepository.findById(purchaseOrderId).get(), PurchaseOrderDTO.class);
	}

	@Override
	public List<PurchaseOrderDTO> getAllPurchaseOrders() {

		return purchaseOrderRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, PurchaseOrderDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PurchaseOrderDTO addPurchaseOrder(PurchaseOrder purchaseOrder) {

		purchaseOrder.setCreateDatetime(new java.util.Date());
		purchaseOrder.setOrderStatus("Quotation");
		
		return modelMapper.map(purchaseOrderRepository.save(purchaseOrder), PurchaseOrderDTO.class);
	}

	@Override
	public PurchaseOrderDTO updatePurchaseOrder(PurchaseOrder purchaseOrder) {

		PurchaseOrder purchaseOrderToUpdate = purchaseOrderRepository.findById(purchaseOrder.getPurchaseOrderId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(purchaseOrderRepository.save(purchaseOrderToUpdate), PurchaseOrderDTO.class);
	}

	@Override
	public void deletePurchaseOrder(long purchaseOrderId) {
		
		purchaseOrderRepository.deleteById(purchaseOrderId);
		
	}

}

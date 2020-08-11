package com.iaito.order.service.impl.purchase;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.purchase.PurchaseOrderProductDTO;
import com.iaito.order.model.purchase.PurchaseOrderProduct;
import com.iaito.order.repository.purchase.PurchaseOrderProductRepository;
import com.iaito.order.service.purchase.PurchaseOrderProductService;

@Service
public class PurchaseOrderProductServiceImpl implements PurchaseOrderProductService{
	
	Logger logger = LoggerFactory.getLogger(PurchaseOrderProductServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired PurchaseOrderProductRepository purchaseOrderProductRepository;

	@Override
	public PurchaseOrderProductDTO getPurchaseOrderProductById(long purchaseOrderProductId) {

		return modelMapper.map(purchaseOrderProductRepository.findById(purchaseOrderProductId).get(), PurchaseOrderProductDTO.class);
	}

	@Override
	public List<PurchaseOrderProductDTO> getAllPurchaseOrderProducts() {

		return purchaseOrderProductRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, PurchaseOrderProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PurchaseOrderProductDTO addPurchaseOrderProduct(PurchaseOrderProduct purchaseOrderProduct) {

		purchaseOrderProduct.setCreateDatetime(new java.util.Date());
		purchaseOrderProduct.setStatus("Active");
		
		return modelMapper.map(purchaseOrderProductRepository.save(purchaseOrderProduct), PurchaseOrderProductDTO.class);
	}

	@Override
	public PurchaseOrderProductDTO updatePurchaseOrderProduct(PurchaseOrderProduct purchaseOrderProduct) {

		PurchaseOrderProduct purchaseOrderProductToUpdate = purchaseOrderProductRepository.findById(purchaseOrderProduct.getPurchaseOrderProductId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(purchaseOrderProductRepository.save(purchaseOrderProductToUpdate), PurchaseOrderProductDTO.class);
	}

	@Override
	public void deletePurchaseOrderProduct(long purchaseOrderProductId) {

		purchaseOrderProductRepository.deleteById(purchaseOrderProductId);
		
	}

}

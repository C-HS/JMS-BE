package com.iaito.order.service.impl.purchase;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.order.dto.purchase.PurchaseOrderProductTaxDTO;
import com.iaito.order.model.purchase.PurchaseOrderProductTax;
import com.iaito.order.repository.purchase.PurchaseOrderProductTaxRepository;
import com.iaito.order.service.purchase.PurchaseOrderProductTaxService;

@Service
public class PurchaseOrderProductTaxServiceImpl implements PurchaseOrderProductTaxService{
	
	Logger logger = LoggerFactory.getLogger(PurchaseOrderProductTaxServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired PurchaseOrderProductTaxRepository purchaseOrderProductTaxRepository;

	@Override
	public PurchaseOrderProductTaxDTO getPurchaseOrderProductTaxById(long purchaseOrderProductTaxId) {

		return modelMapper.map(purchaseOrderProductTaxRepository.findById(purchaseOrderProductTaxId).get(), PurchaseOrderProductTaxDTO.class);
	}

	@Override
	public List<PurchaseOrderProductTaxDTO> getAllPurchaseOrderProductTaxes() {

		return purchaseOrderProductTaxRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, PurchaseOrderProductTaxDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PurchaseOrderProductTaxDTO addPurchaseOrderProductTax(PurchaseOrderProductTax purchaseOrderProductTax) {

		purchaseOrderProductTax.setCreateDatetime(new java.util.Date());
		purchaseOrderProductTax.setStatus("Active");
		
		return modelMapper.map(purchaseOrderProductTaxRepository.save(purchaseOrderProductTax), PurchaseOrderProductTaxDTO.class);
	}

	@Override
	public PurchaseOrderProductTaxDTO updatePurchaseOrderProductTax(PurchaseOrderProductTax purchaseOrderProductTax) {

		PurchaseOrderProductTax purchaseOrderProductTaxToUpdate = purchaseOrderProductTaxRepository.findById(purchaseOrderProductTax.getPurchaseOrderProductTaxId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(purchaseOrderProductTaxRepository.save(purchaseOrderProductTaxToUpdate), PurchaseOrderProductTaxDTO.class);
	}

	@Override
	public void deletePurchaseOrderProductTax(long purchaseOrderProductTaxId) {

		purchaseOrderProductTaxRepository.deleteById(purchaseOrderProductTaxId);
		
	}

}

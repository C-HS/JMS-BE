package com.iaito.shipping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.shipping.dto.PickListProductDTO;
import com.iaito.shipping.model.PickListProduct;
import com.iaito.shipping.repository.PickListProductRepository;
import com.iaito.shipping.service.PickListProductService;

@Service
public class PickListProductServiceImpl implements PickListProductService{
	
	Logger logger = LoggerFactory.getLogger(PickListProductServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired PickListProductRepository pickListProductRepository;

	@Override
	public PickListProductDTO getPickListProductById(long pickListProductId) {

		return modelMapper.map(pickListProductRepository.findById(pickListProductId).get(), PickListProductDTO.class);
	}

	@Override
	public List<PickListProductDTO> getAllPickListProducts() {

		return pickListProductRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, PickListProductDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PickListProductDTO addPickListProduct(PickListProduct pickListProduct) {

		pickListProduct.setCreateDatetime(new java.util.Date());
		pickListProduct.setStatus("Active");
		
		return modelMapper.map(pickListProductRepository.save(pickListProduct), PickListProductDTO.class);
	}

	@Override
	public PickListProductDTO updatePickListProduct(PickListProduct pickListProduct) {

		PickListProduct pickListProductToUpdate = pickListProductRepository.findById(pickListProduct.getPicklistProductId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(pickListProductRepository.save(pickListProductToUpdate), PickListProductDTO.class);
	}

	@Override
	public void deletePickListProduct(long pickListProductId) {
		pickListProductRepository.deleteById(pickListProductId);
		
	}

}

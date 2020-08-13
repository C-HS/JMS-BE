package com.iaito.shipping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.shipping.dto.PickListProductItemDTO;
import com.iaito.shipping.model.PickListProductItem;
import com.iaito.shipping.repository.PickListProductItemRepository;
import com.iaito.shipping.service.PickListProductItemService;

@Service
public class PickListProductItemServiceImpl implements PickListProductItemService {
	
	Logger logger = LoggerFactory.getLogger(PickListProductItemServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired PickListProductItemRepository pickListProductItemRepository;

	@Override
	public PickListProductItemDTO getPickListProductItemById(long pickListProductItemId) {

		return modelMapper.map(pickListProductItemRepository.findById(pickListProductItemId).get(), PickListProductItemDTO.class);
	}

	@Override
	public List<PickListProductItemDTO> getAllPickListProductItems() {

		return pickListProductItemRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, PickListProductItemDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PickListProductItemDTO addPickListProductItem(PickListProductItem pickListProductItem) {

		pickListProductItem.setCreateDatetime(new java.util.Date());
		pickListProductItem.setStatus("Active");
		
		return modelMapper.map(pickListProductItemRepository.save(pickListProductItem), PickListProductItemDTO.class);
	}

	@Override
	public PickListProductItemDTO updatePickListProductItem(PickListProductItem pickListProductItem) {

		PickListProductItem pickListProductItemToUpdate = pickListProductItemRepository.findById(pickListProductItem.getPicklistProductItemId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(pickListProductItemRepository.save(pickListProductItemToUpdate), PickListProductItemDTO.class);
	}

	@Override
	public void deletePickListProductItem(long pickListProductItemId) {
		
		pickListProductItemRepository.deleteById(pickListProductItemId);
		
	}

}

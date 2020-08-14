package com.iaito.shipping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.shipping.dto.PickListDTO;
import com.iaito.shipping.model.PickList;
import com.iaito.shipping.repository.PickListRepository;
import com.iaito.shipping.service.PickListService;


@Service
public class PickListServiceImpl implements PickListService{
	
	Logger logger = LoggerFactory.getLogger(PickListServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired PickListRepository pickListRepository;

	@Override
	public PickListDTO getPickListById(long pickListId) {

		return modelMapper.map(pickListRepository.findById(pickListId).get(), PickListDTO.class);
	}

	@Override
	public List<PickListDTO> getAllPickLists() {

		return pickListRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, PickListDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public PickListDTO addPickList(PickList pickList) {

		pickList.setCreateDatetime(new java.util.Date());
		pickList.setStatus("Draft");
		
		return modelMapper.map(pickListRepository.save(pickList), PickListDTO.class);
	}

	@Override
	public PickListDTO updatePickList(PickList pickList) {

		PickList pickListToUpdate = pickListRepository.findById(pickList.getPicklistId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(pickListRepository.save(pickListToUpdate), PickListDTO.class);
	}

	@Override
	public void deletePickList(long pickListId) {

		pickListRepository.deleteById(pickListId);
		
	}

}

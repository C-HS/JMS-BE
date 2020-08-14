package com.iaito.shipping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.shipping.dto.OutgoingShipmentItemDTO;
import com.iaito.shipping.model.OutgoingShipmentItem;
import com.iaito.shipping.repository.OutgoingShipmentItemRepository;
import com.iaito.shipping.service.OutgoingShipmentItemService;


@Service
public class OutgoingShipmentItemServiceImpl implements OutgoingShipmentItemService{
	
	Logger logger = LoggerFactory.getLogger(OutgoingShipmentItemServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired OutgoingShipmentItemRepository outgoingShipmentItemRepository;

	@Override
	public OutgoingShipmentItemDTO getOutgoingShipmentItemById(long outgoingShipmentItemId) {

		return modelMapper.map(outgoingShipmentItemRepository.findById(outgoingShipmentItemId).get(), OutgoingShipmentItemDTO.class);
	}

	@Override
	public List<OutgoingShipmentItemDTO> getAllOutgoingShipmentItems() {

		return outgoingShipmentItemRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, OutgoingShipmentItemDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public OutgoingShipmentItemDTO addOutgoingShipmentItem(OutgoingShipmentItem outgoingShipmentItem) {

		outgoingShipmentItem.setCreateDatetime(new java.util.Date());
		outgoingShipmentItem.setStatus("Active");
		
		return modelMapper.map(outgoingShipmentItemRepository.save(outgoingShipmentItem), OutgoingShipmentItemDTO.class);
	}

	@Override
	public OutgoingShipmentItemDTO updateOutgoingShipmentItem(OutgoingShipmentItem outgoingShipmentItem) {

		OutgoingShipmentItem outgoingShipmentItemToUpdate = outgoingShipmentItemRepository.findById(outgoingShipmentItem.getOutgoingShipmentItemId()).get();
		
//		catalogToUpdate.setCatalogName(catalog.getCatalogName());
//		catalogToUpdate.setDescription(catalog.getDescription());
		//catalogToUpdate.setCatalogImage(null);
		
		return modelMapper.map(outgoingShipmentItemRepository.save(outgoingShipmentItemToUpdate), OutgoingShipmentItemDTO.class);
	}

	@Override
	public void deleteOutgoingShipmentItem(long outgoingShipmentItemId) {

		outgoingShipmentItemRepository.deleteById(outgoingShipmentItemId);
		
	}

}

package com.iaito.shipping.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.shipping.dto.IncomingShipmentItemDTO;
import com.iaito.shipping.model.IncomingShipmentItem;
import com.iaito.shipping.repository.IncomingShipmentItemRepository;
import com.iaito.shipping.service.IncomingShipmentItemService;

@Service
public class IncomingShipmentItemServiceImpl implements IncomingShipmentItemService {
	
	Logger logger = LoggerFactory.getLogger(IncomingShipmentItemServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired IncomingShipmentItemRepository incomingShipmentItemRepository;

	@Override
	public IncomingShipmentItemDTO getIncomingShipmentItemById(long incomingShipmentItemId) {

		return modelMapper.map(incomingShipmentItemRepository.findById(incomingShipmentItemId).get(), IncomingShipmentItemDTO.class);
	}

	@Override
	public List<IncomingShipmentItemDTO> getAllIncomingShipmentItems() {

		return incomingShipmentItemRepository
				.findAll()
				.stream()
				.map(e->modelMapper.map(e, IncomingShipmentItemDTO.class))
				.collect(Collectors.toList());
	}

	@Override
	public IncomingShipmentItemDTO addIncomingShipmentItem(IncomingShipmentItem incomingShipmentItem) {

		incomingShipmentItem.setCreateDatetime(new java.util.Date());
		incomingShipmentItem.setStatus("Active");
		
		return modelMapper.map(incomingShipmentItemRepository.save(incomingShipmentItem), IncomingShipmentItemDTO.class);
	}

	@Override
	public IncomingShipmentItemDTO updateIncomingShipmentItem(IncomingShipmentItem incomingShipmentItem) {

		IncomingShipmentItem incomingShipmentItemToUpdate = incomingShipmentItemRepository.findById(incomingShipmentItem.getIncomingShipmentItemId()).get();

		return modelMapper.map(incomingShipmentItemRepository.save(incomingShipmentItemToUpdate), IncomingShipmentItemDTO.class);
	}

	@Override
	public void deleteIncomingShipmentItem(long incomingShipmentItemId) {

		incomingShipmentItemRepository.deleteById(incomingShipmentItemId);
		
	}

}

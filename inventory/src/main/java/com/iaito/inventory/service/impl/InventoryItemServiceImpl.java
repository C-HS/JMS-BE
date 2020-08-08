package com.iaito.inventory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.inventory.dto.InventoryItemDTO;
import com.iaito.inventory.dto.LocationDTO;
import com.iaito.inventory.model.InventoryItem;
import com.iaito.inventory.model.Location;
import com.iaito.inventory.repository.InventoryItemRepository;
import com.iaito.inventory.service.InventoryItemService;

@Service
public class InventoryItemServiceImpl implements InventoryItemService{

    Logger logger = LoggerFactory.getLogger(InventoryItemServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired InventoryItemRepository inventoryItemRepository;
	
	@Override
	public InventoryItemDTO getInventoryItemById(long inventoryItemId) {

		return modelMapper.map(inventoryItemRepository.findById(inventoryItemId).get(), InventoryItemDTO.class);
	}

	@Override
	public List<InventoryItemDTO> getAllInventoryItems() {

        return inventoryItemRepository
        .findAll()
        .stream()
        .map(e->modelMapper.map(e, InventoryItemDTO.class))
        .collect(Collectors.toList());
	}

	@Override
	public InventoryItemDTO addInventoryItem(InventoryItem inventoryItem) {
		
		inventoryItem.setCreateDatetime(new java.util.Date());
		inventoryItem.setStatus("Active");
		
		return modelMapper.map(inventoryItemRepository.save(inventoryItem), InventoryItemDTO.class);
	}

	@Override
	public InventoryItemDTO updateInventoryItem(InventoryItem inventoryItem) {

		InventoryItem inventoryItemToUpdate = inventoryItemRepository.findById(inventoryItem.getInventoryItemId()).get();
		
		//catalogToUpdate.setCatalogName(catalog.getCatalogName());
	//	catalogToUpdate.setDescription(catalog.getDescription());
		
		return modelMapper.map(inventoryItemRepository.save(inventoryItemToUpdate), InventoryItemDTO.class);
	}

	@Override
	public void deleteInventoryItem(long inventoryItemId) {

		inventoryItemRepository.deleteById(inventoryItemId);
		
	}

}

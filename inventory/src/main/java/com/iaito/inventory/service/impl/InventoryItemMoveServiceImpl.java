package com.iaito.inventory.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iaito.inventory.dto.InventoryItemDTO;
import com.iaito.inventory.dto.InventoryItemMoveDTO;
import com.iaito.inventory.model.InventoryItem;
import com.iaito.inventory.model.InventoryItemMove;
import com.iaito.inventory.repository.InventoryItemMoveRepository;
import com.iaito.inventory.service.InventoryItemMoveService;

@Service
public class InventoryItemMoveServiceImpl implements InventoryItemMoveService{
	
    Logger logger = LoggerFactory.getLogger(InventoryItemMoveServiceImpl.class);
	
	@Autowired ModelMapper modelMapper;
	
	@Autowired InventoryItemMoveRepository inventoryItemMoveRepository;

	@Override
	public InventoryItemMoveDTO getInventoryItemMoveById(long inventoryItemMoveId) {


		return modelMapper.map(inventoryItemMoveRepository.findById(inventoryItemMoveId).get(), InventoryItemMoveDTO.class);
	}

	@Override
	public List<InventoryItemMoveDTO> getAllInventoryItemMoves() {
		
        return inventoryItemMoveRepository
        .findAll()
        .stream()
        .map(e->modelMapper.map(e, InventoryItemMoveDTO.class))
        .collect(Collectors.toList());
	}

	@Override
	public InventoryItemMoveDTO addInventoryItemMove(InventoryItemMove inventoryItemMove) {

		inventoryItemMove.setMovementDatetime(new java.util.Date());
		inventoryItemMove.setStatus("Active");
		
		return modelMapper.map(inventoryItemMoveRepository.save(inventoryItemMove), InventoryItemMoveDTO.class);
	}

	@Override
	public InventoryItemMoveDTO updateInventoryItemMove(InventoryItemMove inventoryItemMove) {

		InventoryItemMove inventoryItemMoveToUpdate = inventoryItemMoveRepository.findById(inventoryItemMove.getInventoryItemMoveId()).get();
		
		//catalogToUpdate.setCatalogName(catalog.getCatalogName());
	//	catalogToUpdate.setDescription(catalog.getDescription());
		
		return modelMapper.map(inventoryItemMoveRepository.save(inventoryItemMoveToUpdate), InventoryItemMoveDTO.class);
	}

	@Override
	public void deleteInventoryItemMove(long inventoryItemMoveId) {

		inventoryItemMoveRepository.deleteById(inventoryItemMoveId);
		
	}

}

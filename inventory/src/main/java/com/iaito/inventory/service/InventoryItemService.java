package com.iaito.inventory.service;

import java.util.List;

import com.iaito.inventory.dto.InventoryItemDTO;
import com.iaito.inventory.model.InventoryItem;

public interface InventoryItemService {
	
    public InventoryItemDTO getInventoryItemById(long inventoryItemId);
    public List<InventoryItemDTO> getAllInventoryItems();
    public InventoryItemDTO addInventoryItem(InventoryItem inventoryItem);
    public InventoryItemDTO updateInventoryItem(InventoryItem inventoryItem);
    public void deleteInventoryItem(long inventoryItemId);

}

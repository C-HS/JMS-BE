package com.iaito.inventory.service;

import java.util.List;

import com.iaito.inventory.dto.InventoryItemMoveDTO;
import com.iaito.inventory.model.InventoryItemMove;



public interface InventoryItemMoveService {
    public InventoryItemMoveDTO getInventoryItemMoveById(long inventoryItemMoveId);
    public List<InventoryItemMoveDTO> getAllInventoryItemMoves();
    public InventoryItemMoveDTO addInventoryItemMove(InventoryItemMove inventoryItemMove);
    public InventoryItemMoveDTO updateInventoryItemMove(InventoryItemMove inventoryItemMove);
    public void deleteInventoryItemMove(long inventoryItemMoveId);
}

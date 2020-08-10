package com.iaito.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iaito.inventory.model.InventoryItemMove;

@Repository
public interface InventoryItemMoveRepository extends JpaRepository<InventoryItemMove, Long> {

}

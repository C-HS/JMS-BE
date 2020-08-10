package com.iaito.inventory.dto;

import com.iaito.inventory.model.InventoryItem;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InventoryItemMoveDTO {
	
	private long inventoryItemMoveId;
	
	private String operationType;
	
	private long quantity;
	
	private long fromVendor;
	
	private long purchaseOrder;
	
	private long inShipment;
	
	private long toCustomer;
	
	private long salesOrder;

	private long outShipment;

	private long fromFacility;

	private long fromLocation;

	private long toFacility;
	
	private long toLocation;
	
	private java.util.Date movementDatetime;
	
	private String status;

	private InventoryItem inventoryItem;

}

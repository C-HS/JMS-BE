package com.iaito.inventory.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InventoryItemDTO {
	
	private long inventoryItemId;

	private long facilityId;

	private long locationId;

	private long productId;

	private String lotNo;

	private long slno;

	private long quantity;

	private long fromVendor;

	private long purchaseOrder;

	private long inShipment;

	private long companyId;

	private long toCustomer;

	private long salesOrder;

	private long outShipment;

	private String tid;

	private String taggingStatus;
	
	private java.util.Date createDatetime;
	
	private String status;

}

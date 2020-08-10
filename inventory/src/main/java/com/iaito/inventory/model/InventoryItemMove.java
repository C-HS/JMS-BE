package com.iaito.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "InventoryItemMove")
public class InventoryItemMove {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inventory_item_move_id")
	private long inventoryItemMoveId;

//	@Column(name = "inventory_item_id")
//	private long inventoryItemId;
	
	@Column(name = "operation_type")
	private String operationType;
	
	@Column(name = "quantity")
	private long quantity;
	
	@Column(name = "from_vendor")
	private long fromVendor;
	
	@Column(name = "purchase_order")
	private long purchaseOrder;
	
	@Column(name = "in_shipment")
	private long inShipment;
	
	@Column(name = "to_customer")
	private long toCustomer;
	
	@Column(name = "sales_order")
	private long salesOrder;
	
	@Column(name = "out_shipment")
	private long outShipment;

	@Column(name = "from_facility")
	private long fromFacility;
	
	@Column(name = "from_location")
	private long fromLocation;
	
	@Column(name = "to_facility")
	private long toFacility;
	
	@Column(name = "to_location")
	private long toLocation;
	
	
	@Column(name = "movement_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date movementDatetime;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "inventory_item_id")
	private InventoryItem inventoryItem;

}

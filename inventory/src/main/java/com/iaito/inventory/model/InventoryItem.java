package com.iaito.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "InventoryItem")
public class InventoryItem {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inventory_item_id")
	private long inventoryItemId;

	@Column(name = "facility_id")
	private long facilityId;
	
	@Column(name = "location_id")
	private long locationId;
	
	@Column(name = "product_id")
	private long productId;

	@Column(name = "lot_no")
	private String lotNo;
	
	@Column(name = "slno")
	private long slno;
	
	@Column(name = "quantity")
	private long quantity;
	
	@Column(name = "from_vendor")
	private long fromVendor;
	
	@Column(name = "purchase_order")
	private long purchaseOrder;
	
	@Column(name = "in_shipment")
	private long inShipment;

	@Column(name = "company_id")
	private long companyId;
	
	@Column(name = "to_customer")
	private long toCustomer;
	
	@Column(name = "sales_order")
	private long salesOrder;
	
	@Column(name = "out_shipment")
	private long outShipment;

	@Column(name = "tid")
	private String tid;
	
	@Column(name = "tagging_status")
	private String taggingStatus;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;

}

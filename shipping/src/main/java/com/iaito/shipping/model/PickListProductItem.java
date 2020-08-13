package com.iaito.shipping.model;

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
@Table(name = "PickListProduct")
public class PickListProductItem {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "picklist_product_item_id")
	private long picklistProductItemId;
    
	@Column(name = "picklist_product_id")
	private long picklistProductId;
    
    @Column(name = "inventory_item_id")
	private long inventoryItemId;
    
	@Column(name = "quantity")
	private long quantity;
	
	@Column(name = "available_quantity")
	private long availableQuantity;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;

	@Column(name = "status")
	private String status;

}

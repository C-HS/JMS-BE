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
@Table(name = "OutgoingShipmentItem")
public class OutgoingShipmentItem {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "outgoing_shipment_item_id")
	private long outgoingShipmentItemId;

	@Column(name = "outgoing_shipment_id")
	private long outgoingShipmentId;

	@Column(name = "product_id")
	private long productId;

	@Column(name = "product_description")
	private String productDescription;
    
	@Column(name = "ordered_quantity")
	private double orderedQuantity;
	
	@Column(name = "available_quantity")
	private double availableQuantity;

	@Column(name = "done_quantity")
	private double doneQuantity;

	@Column(name = "uom")
	private long uom;

	@Column(name = "expected_date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date expectedDate;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;

}

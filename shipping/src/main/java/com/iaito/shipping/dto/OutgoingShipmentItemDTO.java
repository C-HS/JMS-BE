package com.iaito.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OutgoingShipmentItemDTO {

	private long outgointShipmentItemId;

	private long outgointShipmentId;

	private long productId;

	private String productDescription;
    
	private double orderedQuantity;
	
	private double availableQuantity;

	private double doneQuantity;

	private long uom;

	private java.util.Date expectedDate;

	private java.util.Date createDatetime;
	
	private String status;
}

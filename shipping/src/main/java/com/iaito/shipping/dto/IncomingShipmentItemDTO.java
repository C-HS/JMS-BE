package com.iaito.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class IncomingShipmentItemDTO {
	
	private long incomingShipmentItemId;

	private long incomingShipmentId;

	private long productId;

	private String productDescription;
    
	private double orderedQuantity;

	private double doneQuantity;

	private long uom;

	private java.util.Date expectedDate;
	
	private java.util.Date createDatetime;

	private String status;

}

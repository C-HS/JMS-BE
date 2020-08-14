package com.iaito.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PackagingDTO {

	private long packagingId;

	private long outgoingShipmentId;
    
	private String outgoingShipmentNo;
	
	private String notes;
	
	private long createdBy;
	
	private java.util.Date createDatetime;

	private String status;
}

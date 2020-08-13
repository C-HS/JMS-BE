package com.iaito.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class OutgoingShipmentDTO {
	
    private long outgoingShipmentId;

	private String outgoingShipmentNo;

	private long companyId;

	private long customerId;

	private long customerContactId;

	private long facilityId;
	
	private long locationId;

	private long salesOrderId;

	private String salesOrderNo;

	private java.util.Date scheduledDate;

	private String reference;

	private String source;

	private long responsiblePerson;
	
	private String priority;
	
	private String notes;

	private java.util.Date createDatetime;

//	private java.util.Date deliveryDate;

	private String shipmentStatus;

//	private String deliveryStatus;
	
	private long createdBy;

}

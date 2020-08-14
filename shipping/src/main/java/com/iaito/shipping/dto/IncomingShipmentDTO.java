package com.iaito.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class IncomingShipmentDTO {

	private long incomingShipmentId;

	private String incomingShipmentNo;

	private long companyId;

	private long vendorId;

	private long vendorContactId;

	private long facilityId;

	private long locationId;

	private long purchaseOrderId;

	private String purchaseOrderNo;
	
	private java.util.Date scheduledDate;

	private String reference;

	private String source;

	private long responsiblePerson;

	private String priority;

	private String notes;

	private java.util.Date createDatetime;

	private String shipmentStatus;

	private long createdBy;
}

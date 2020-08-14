package com.iaito.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TransportDTO {
	
	private long transportId;

	private long outgoingShipmentId;

	private String outgoingShipmentNo;
	
	private String transportName;

	private String transportAddress;

	private String transportRegNo;

	private String documentNo;

	private String vehicleNo;

	private String trackingNo;

	private String trackingLink;

	private String contactPerson;

	private String phoneNo;

	private String mobileNo;

	private String email;

	private String website;

	private long createdBy;
	
	private java.util.Date createDatetime;
	
	private String status;

}

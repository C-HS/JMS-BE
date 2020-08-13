package com.iaito.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PickListDTO {

	private long picklistId;
     
	private String picklistNo;

	private long outgoingShipmentId;

	private String outgoingShipmentNo;

	private long picker;

	private long createdBy;

	private long verifiedBy;

	private java.util.Date createDatetime;

	private java.util.Date verificationDatetime;

	private String status;
	
	private String pickStatus;
	
	private String verificationStatus;
}

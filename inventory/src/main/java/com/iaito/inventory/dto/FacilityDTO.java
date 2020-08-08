package com.iaito.inventory.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class FacilityDTO {

	private long facilityId;
    
	private String facilityName;
	
	private String facilityType;

	private long companyId;

	private long countryId;
	
	private long stateId;
	
	private String city;
	
	private String pinCode;

	private String phoneNo;

	private String email;
	
	private java.util.Date createDatetime;

	private String status;
    
}
package com.iaito.settings.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CompanyDTO {
	
	private long companyId;
	
	private String companyName;
	
	private String addressLine1;

	private String addressLine2;
	
	private long countryId;
	
	private long stateId;
	
	private String city;
	
	private String pinCode;
	
	private String phoneNo;
	
	private String mobileNo;
	
	private String email;
	
	private String website;
	
	private String gstinNo;
	
	private String registrationNo;
	
	private long currencyId;
	
	private byte[] companyLogo;

	private java.util.Date createDatetime;

	private String status;

}


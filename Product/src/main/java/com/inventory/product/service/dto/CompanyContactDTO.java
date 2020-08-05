package com.inventory.product.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CompanyContactDTO {
	
	private long companyContactId;
	
	private long companyId;
	
	private String contactType;
	
	private String contactName;
	
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
	
	private String notes;
	
	private java.util.Date createDatetime;
	
	private String status;

}

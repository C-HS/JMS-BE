package com.iaito.settings.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CountryDTO {
	
	private long countryId;
	
	private String countryName;
	
	private String countryCode;
	
	private String countryFlag;
	
	private String status;

}

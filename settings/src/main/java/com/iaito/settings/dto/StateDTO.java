package com.iaito.settings.dto;


import com.iaito.settings.model.Country;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class StateDTO {
	
	private long stateId;
	
	private String stateName;
	
	private String status;
	
	private Country country;

}

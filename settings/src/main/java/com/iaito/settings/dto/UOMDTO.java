package com.iaito.settings.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UOMDTO {

	private long uomId;
	
	private String uomName;
	
	private String description;
	
	private java.util.Date createDatetime;
	
	private String status;
	
}

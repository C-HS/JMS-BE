package com.inventory.product.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TaxDTO {
	
	private long taxId;
	
	private String taxDetail;
	
	private float taxPercent;
	
	private String description;
	
	private java.util.Date createDatetime;
	
	private String status;

}

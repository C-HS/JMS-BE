package com.inventory.product.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductAttributeDTO {
	
	private long attributeId;
	
	private String attributeName;
	
	private String uom;

	private java.util.Date createDatetime;
	
	private String status;

}

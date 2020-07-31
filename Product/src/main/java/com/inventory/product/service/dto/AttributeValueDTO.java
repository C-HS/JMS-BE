package com.inventory.product.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class AttributeValueDTO {
	
	private long attributeValueId;
    
	private long productId;
	
	private long attributeId;
	
	private String attributeValue;
	
	private java.util.Date createDatetime;
	
	private String status;

}

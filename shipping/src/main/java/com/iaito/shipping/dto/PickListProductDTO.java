package com.iaito.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PickListProductDTO {

	private long picklistProductId;
    
	private long picklistId;

	private long productId;

	private String pickingRule;

	private long quantity;

	private java.util.Date createDatetime;
	
	private String status;
}

package com.inventory.product.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductPurchaseTaxDTO {
	
	private long productPurchaseTaxId;
	
	private long productId;
	
	private long taxId;

	private java.util.Date createDatetime;
	
	private String status;


}

package com.inventory.product.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductCustomerDTO {
	
	private long productCustomerId;
	
	private long productId;
	
	private long customerId;
	
	private double salesPrice;
	
	private long currencyId;
	
	private java.util.Date createDatetime;

	private String status;

}

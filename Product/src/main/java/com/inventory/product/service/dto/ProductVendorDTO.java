package com.inventory.product.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductVendorDTO {

	private long productVendorId;

	private long productId;

	private long vendorId;

	private double costPrice;

	private long currencyId;
	
	private java.util.Date createDatetime;

	private String status;

}

package com.inventory.product.service.dto;

import com.inventory.product.service.model.Product;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductSalesTaxDTO {
	
	private long productSalesTaxId;
	
//	private long productId;
	
	private long taxId;

	private java.util.Date createDatetime;
	
	private String status;
	
	private Product product;

}

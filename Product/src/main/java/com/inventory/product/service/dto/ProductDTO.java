package com.inventory.product.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDTO {
	private long productId;
	private long parentProductId;
	private String productName;
	private String productType;
	private byte[] productImage;
	private int canBeSold;
	private int canBePurchased;
	private int canBeManufactured;
	private String traceability;
	private String internalReference;
	private long categoryId;
	private String hsnCode;
	private String hsnDescription;
	private double salesPrice;
	private String salesCurrency;
	private double costPrice;
	private String costCurrency;
	private String uom;
	private long companyId;
	private String weight;
	private String description;
	private java.util.Date createDatetime;
	private String status;
}

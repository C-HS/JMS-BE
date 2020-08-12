package com.iaito.accounting.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BillProductDTO {
	
	private long billProductId;

	private long billId;

	private long productId;

	private String productDescription;

	private double quantity;
	
	private double uom;

	private double unitPrice;

	private double discountPercent;

	private double subTotal;

	private double taxAmount;

	private double discountAmount;

	private double totalAmount;

	private java.util.Date createDatetime;

	private String status;

}

package com.iaito.order.dto.sales;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SalesOrderProductDTO {

	private long salesOrderProductId;

	private long salesOrderId;

	private long productId;

	private String productDescription;
    
	private double orderedQuantity;

	private double deliveredQuantity;

	private double invoicedQuantity;
	
	private double unitPrice;

	private double discountPercent;
	
	private double subTotal;

	private double taxAmount;

	private double discountAmount;

	private double totalAmount;

	private java.util.Date createDatetime;

	private String status;
    
}
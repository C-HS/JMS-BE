package com.iaito.order.dto.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PurchaseOrderProductDTO {
	

	private long purchaseOrderProductId;

	private long purchaseOrderId;

	private long productId;

	private String productDescription;
    
	private double orderedQuantity;

	private double receivedQuantity;

	private double billedQuantity;
	
	private double unitPrice;

//	private double discountPercent;
	
	private double subTotal;

	private double taxAmount;

//	private double discountAmount;

	private double totalAmount;
	
	private java.util.Date scheduleDate;
	
	private java.util.Date createDatetime;

	private String status;

}

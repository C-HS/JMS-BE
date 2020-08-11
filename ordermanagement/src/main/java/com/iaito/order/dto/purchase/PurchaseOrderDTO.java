package com.iaito.order.dto.purchase;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PurchaseOrderDTO {

	private long purchaseOrderId;
    
	private String purchaseOrderNo;
	
	private long vendorId;

	private long vendorContactId;

	private long companyId;

	private long currencyId;
	
	private double totalAmount;
	
	private double taxAmount;
	
	private double untaxAmount;

	private long paymentTermsId;
	
	private java.util.Date createDatetime;

	private java.util.Date receiptDate;

	private java.util.Date expectedDate;

	private java.util.Date confirmationDate;

	private java.util.Date expiryDate;

	private String orderStatus;

	private String billingStatus;

	private String paymentStatus;

	private String receiptStatus;

	private String termsConditions;

	private long createdBy;

	private long confirmedBy;

	private long purchaseRepresentative;

	private String paymentMode;

	private String reference;

	private String source;

	private String fiscalPosition;

	private String shippingPolicy;

	private String incoterms;
    
}
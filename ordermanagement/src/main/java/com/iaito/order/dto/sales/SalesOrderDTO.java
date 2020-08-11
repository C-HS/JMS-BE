package com.iaito.order.dto.sales;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SalesOrderDTO{

	private long salesOrderId;

	private String salesOrderNo;

	private long customerId;

	private long customerContactId;

	private long companyId;

	private long currencyId;

	private double totalAmount;

	private double taxAmount;

	private double untaxAmount;

	private long paymentTermsId;

	private java.util.Date createDatetime;

	private java.util.Date deliveryDate;

	private java.util.Date expectedDate;

	private java.util.Date confirmationDate;

	private java.util.Date expiryDate;
	
	private String orderStatus;

	private String invoiceStatus;

	private String paymentStatus;

	private String deliveryStatus;

	private String termsConditions;

	private long createdBy;

	private long confirmedBy;

	private long salesPerson;

	private String paymentMode;

	private String reference;

	private String source;

	private String fiscalPosition;

	private String shippingPolicy;

	private String incoterms;
    
}
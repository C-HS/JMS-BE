package com.iaito.accounting.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InvoiceDTO {

	private long invoiceId;
 
	private long invoiceNumber;

	private java.util.Date invoiceDate;

	private long salesOrderId;

	private String salesOrderNo;

	private long customerId;

	private long customerContactId;
	
	private long companyId;

	private long currencyId;
	
	private long paymentTermsId;
	
	private String reference;

	private String source;
	
	private String paymentStatus;
	
	private String paymentMode;

	private String paymentReference;

	private String fiscalPosition;

	private String incoterms;
	
	private java.util.Date paymentReceiveDate;

	private String termsConditions;
	
	private double totalAmount;
	
	private double taxAmount;
	
	private double untaxAmount;
	
	private long createdBy;
	
	private java.util.Date createDatetime;

	private String invoiceStatus;

	private long paymentConfirmedBy;
}

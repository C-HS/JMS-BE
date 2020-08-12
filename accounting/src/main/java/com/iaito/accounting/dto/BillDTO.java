package com.iaito.accounting.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BillDTO {

	private long billId;

	private long billNumber;

	private java.util.Date billDate;

	private long purchaseOrderId;

	private String purchaseOrderNo;
 
	private long vendorId;

	private long vendorContactId;

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
	
	private java.util.Date accountingDate;

	private java.util.Date paymentSentDate;

	private String termsConditions;
	
	private double totalAmount;
	
	private double taxAmount;
	
	private double untaxAmount;
	
	private long createdBy;
	
	private java.util.Date createDatetime;

	private String billStatus;
}

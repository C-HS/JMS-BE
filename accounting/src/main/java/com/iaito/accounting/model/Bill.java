package com.iaito.accounting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Bill")
public class Bill {
	
 	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_id")
	private long billId;
 	
 	@Column(name = "bill_number")
	private long billNumber;
 	
	@Column(name = "bill_date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date billDate;
 	
    @Column(name = "purchase_order_id")
	private long purchaseOrderId;
    
	@Column(name = "purchase_order_no")
	private String purchaseOrderNo;
 	
	@Column(name = "vendor_id")
	private long vendorId;

	@Column(name = "vendor_contact_id")
	private long vendorContactId;
	
	@Column(name = "company_id")
	private long companyId;

	@Column(name = "currency_id")
	private long currencyId;
	
	@Column(name = "payment_terms_id")
	private long paymentTermsId;
	
	@Column(name = "reference")
	private String reference;

	@Column(name = "source")
	private String source;
	
	@Column(name = "payment_status")
	private String paymentStatus;
	
	@Column(name = "payment_mode")
	private String paymentMode;
	
	@Column(name = "payment_reference")
	private String paymentReference;

	@Column(name = "fiscal_position")
	private String fiscalPosition;

	@Column(name = "incoterms")
	private String incoterms;
	
	@Column(name = "accounting_date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date accountingDate;
	
	@Column(name = "payment_sent_date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date paymentSentDate;
	
	@Column(name = "terms_conditions")
	private String termsConditions;
	
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "tax_amount")
	private double taxAmount;
	
	@Column(name = "untax_amount")
	private double untaxAmount;
	
	@Column(name = "created_by")
	private long createdBy;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;

	@Column(name = "bill_status")
	private String billStatus;

}

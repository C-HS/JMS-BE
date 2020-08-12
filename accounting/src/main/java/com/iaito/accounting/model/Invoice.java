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
@Table(name = "Invoice")
public class Invoice {
	
	 	@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "invoice_id")
		private long invoiceId;
	 	
	 	@Column(name = "invoice_number")
		private long invoiceNumber;
	 	
		@Column(name = "invoice_date")
		@Temporal(TemporalType.TIMESTAMP)
		private java.util.Date invoiceDate;
	 	
	    @Column(name = "sales_order_id")
		private long salesOrderId;
	    
		@Column(name = "sales_order_no")
		private String salesOrderNo;
	 	
		@Column(name = "customer_id")
		private long customerId;

		@Column(name = "customer_contact_id")
		private long customerContactId;
		
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
		
		@Column(name = "payment_receive_date")
		@Temporal(TemporalType.TIMESTAMP)
		private java.util.Date paymentReceiveDate;
		
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

		@Column(name = "invoice_status")
		private String invoiceStatus;

		@Column(name = "payment_confirmed_by")
		private long paymentConfirmedBy;


}

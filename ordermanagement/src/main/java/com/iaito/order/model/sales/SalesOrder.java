package com.iaito.order.model.sales;

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
@Table(name = "SalesOrder")
public class SalesOrder {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "tax_amount")
	private double taxAmount;
	
	@Column(name = "untax_amount")
	private double untaxAmount;

	@Column(name = "payment_terms_id")
	private long paymentTermsId;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;

	@Column(name = "delivery_date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date deliveryDate;

	@Column(name = "expected_date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date expectedDate;

	@Column(name = "confirmation_date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date confirmationDate;

	@Column(name = "expiry_date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date expiryDate;
	
	@Column(name = "order_status")
	private String orderStatus;

	@Column(name = "invoice_status")
	private String invoiceStatus;

	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "delivery_status")
	private String deliveryStatus;

	@Column(name = "terms_conditions")
	private String termsConditions;

	@Column(name = "created_by")
	private long createdBy;

	@Column(name = "confirmed_by")
	private long confirmedBy;

	@Column(name = "sales_person")
	private long salesPerson;

	@Column(name = "payment_mode")
	private String paymentMode;

	@Column(name = "reference")
	private String reference;

	@Column(name = "source")
	private String source;

	@Column(name = "fiscal_position")
	private String fiscalPosition;

	@Column(name = "shipping_policy")
	private String shippingPolicy;

	@Column(name = "incoterms")
	private String incoterms;
    
}
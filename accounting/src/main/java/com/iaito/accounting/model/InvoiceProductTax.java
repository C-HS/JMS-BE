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
@Table(name = "InvoiceProductTax")
public class InvoiceProductTax {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "invoice_product_tax_id")
	private long invoiceProductTaxId;

	@Column(name = "invoice_product_id")
	private long invoiceProductId;

	@Column(name = "tax_id")
	private long taxId;

	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;

	
	@Column(name = "status")
	private String status;
}

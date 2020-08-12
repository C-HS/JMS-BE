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
@Table(name = "BillProduct")
public class BillProduct {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bill_product_id")
	private long billProductId;

	@Column(name = "bill_id")
	private long billId;

	@Column(name = "product_id")
	private long productId;

	@Column(name = "product_description")
	private String productDescription;

	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "uom")
	private double uom;
	
	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "discount_percent")
	private double discountPercent;
	
	@Column(name = "sub_total")
	private double subTotal;

	@Column(name = "tax_amount")
	private double taxAmount;

	@Column(name = "discount_amount")
	private double discountAmount;

	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;

	
	@Column(name = "status")
	private String status;
}

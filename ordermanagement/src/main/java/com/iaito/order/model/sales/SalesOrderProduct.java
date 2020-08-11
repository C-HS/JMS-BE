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
@Table(name = "SalesOrderProduct")
public class SalesOrderProduct {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "sales_order_product_id")
	private long salesOrderProductId;

	@Column(name = "sales_order_id")
	private long salesOrderId;

	@Column(name = "product_id")
	private long productId;

	@Column(name = "product_description")
	private String productDescription;
    
	@Column(name = "ordered_quantity")
	private double orderedQuantity;

	@Column(name = "delivered_quantity")
	private double deliveredQuantity;

	@Column(name = "invoiced_quantity")
	private double invoicedQuantity;
	
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
package com.iaito.order.model.purchase;

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
@Table(name = "PurchaseOrderProduct")
public class PurchaseOrderProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "purchase_order_product_id")
	private long purchaseOrderProductId;

	@Column(name = "purchase_order_id")
	private long purchaseOrderId;

	@Column(name = "product_id")
	private long productId;

	@Column(name = "product_description")
	private String productDescription;
    
	@Column(name = "ordered_quantity")
	private double orderedQuantity;

	@Column(name = "received_quantity")
	private double receivedQuantity;

	@Column(name = "billed_quantity")
	private double billedQuantity;
	
	@Column(name = "unit_price")
	private double unitPrice;

//	@Column(name = "discount_percent")
//	private double discountPercent;
	
	@Column(name = "sub_total")
	private double subTotal;

	@Column(name = "tax_amount")
	private double taxAmount;

//	@Column(name = "discount_amount")
//	private double discountAmount;

	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "schedule_date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date scheduleDate;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;

	
	@Column(name = "status")
	private String status;

}

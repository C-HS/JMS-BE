package com.inventory.product.service.model;

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
@Table(name = "ProductVendor")
public class ProductVendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_vendor_id")
	private long productVendorId;
	
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "vendor_id")
	private long vendorId;
	
	@Column(name = "cost_price")
	private double costPrice;
	
	@Column(name = "currency_id")
	private long currencyId;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;

}
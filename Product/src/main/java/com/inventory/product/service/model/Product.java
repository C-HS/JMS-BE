package com.inventory.product.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "Product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "product_type")
	private String productType;
	
	@Column(name = "product_image")
	@Lob
	private byte[] productImage;
	
	@Column(name = "can_be_sold")
	private int canBeSold;
	
	@Column(name = "can_be_purchased")
	private int canBePurchased;
	
	@Column(name = "can_be_manufactured")
	private int canBeManufactured;
	
	@Column(name = "traceability")
	private String traceability;
	
	@Column(name = "int_ref")
	private String internalReference;
	
	@Column(name = "category_id")
	private long categoryId;
	
	@Column(name = "hsn_code")
	private String hsnCode;
	
	@Column(name = "hsn_desc")
	private String hsnDescription;
	
	@Column(name = "sales_price")
	private double salesPrice;
	
	@Column(name = "sales_currency")
	private String salesCurrency;
	
	@Column(name = "cost_price")
	private double costPrice;
	
	@Column(name = "cost_currency")
	private String costCurrency;
	
	@Column(name = "uom")
	private String uom;
	
	@Column(name = "company_id")
	private long companyId;
	
	@Column(name = "weight")
	private String weight;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;
}

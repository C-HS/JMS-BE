package com.inventory.product.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ProductPurchaseTax")
public class ProductPurchaseTax {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_purchase_tax_id")
	private long productPurchaseTaxId;
	
//	@Column(name = "product_id")
//	private long productId;
	
	@Column(name = "tax_id")
	private long taxId;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

}

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
@Table(name = "AttributeValue")
public class AttributeValue {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "attribute_value_id")
	private long attributeValueId;
    
	@Column(name = "product_id")
	private long productId;
	
	@Column(name = "attribute_id")
	private long attributeId;
	
	@Column(name = "attribute_value")
	private String attributeValue;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;

}

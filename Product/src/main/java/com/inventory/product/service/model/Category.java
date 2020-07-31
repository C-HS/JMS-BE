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
@Table(name = "Category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private long categoryId;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "catalog_id")
	private long catalogId;
	
	@Column(name = "category_image")
	@Lob
	private byte[] categoryImage;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;

}

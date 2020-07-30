package com.inventory.product.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Catalog")
public class Catalog {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "catalog_id")
	private long catalogId;
	@Column(name = "catalog_name")
	private String catalogName;
    
}
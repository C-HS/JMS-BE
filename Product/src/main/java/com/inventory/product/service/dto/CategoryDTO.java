package com.inventory.product.service.dto;

import com.inventory.product.service.model.Catalog;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CategoryDTO {
	
	private long categoryId;
	private String categoryName;
	private long catalogId;
	private byte[] categoryImage;
	private String description;
	private java.util.Date createDatetime;
	private String status;

}

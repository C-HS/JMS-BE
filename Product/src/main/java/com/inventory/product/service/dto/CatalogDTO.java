package com.inventory.product.service.dto;

//import java.util.ArrayList;
//import java.util.List;
//
//import com.inventory.product.service.model.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CatalogDTO {
    private long catalogId;
	private String catalogName;
	private byte[] file;
	private String catalogDesc;
	private java.util.Date createDatetime;
	private String status;
//	private List<Category> categoryList = new ArrayList<>();
}
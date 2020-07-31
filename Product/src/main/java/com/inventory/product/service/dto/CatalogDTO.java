package com.inventory.product.service.dto;

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
	private byte[] catalogImage;
	private String description;
	private java.util.Date createDatetime;
	private String status;
}
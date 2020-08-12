package com.iaito.accounting.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BillProductTaxDTO {
	
	private long billProductTaxId;

	private long billProductId;

	private long taxId;

	private java.util.Date createDatetime;

	private String status;

}

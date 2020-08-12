package com.iaito.accounting.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class InvoiceProductTaxDTO {
	
	private long invoiceProductTaxId;

	private long invoiceProductId;

	private long taxId;

	private java.util.Date createDatetime;

	private String status;

}

package com.iaito.order.dto.sales;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SalesOrderProductTaxDTO{

	private long salesOrderProductTaxId;

	private long salesOrderProductId;

	private long taxId;

	private java.util.Date createDatetime;

	private String status;
    
}

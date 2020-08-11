package com.iaito.order.dto.purchase;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PurchaseOrderProductTaxDTO {

	private long purchaseOrderProductTaxId;

	private long purchaseOrderProductId;

	private long taxId;

	private java.util.Date createDatetime;

	private String status;

}

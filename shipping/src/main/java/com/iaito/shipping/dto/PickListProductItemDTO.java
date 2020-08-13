package com.iaito.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PickListProductItemDTO {

	private long picklistProductItemId;

	private long picklistProductId;

	private long inventoryItemId;

	private long quantity;

	private long availableQuantity;

	private java.util.Date createDatetime;

	private String status;
}

package com.inventory.product.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CurrencyDTO {

	private long currencyId;

	private String currencyName;

	private String currencyCode;

	private byte[] currencyLogo;

	private java.util.Date createDatetime;

	private String status;
}

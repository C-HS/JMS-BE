package com.iaito.order.dto.payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class PaymentTermsDTO {

		private long paymentTermsId;

		private String paymentTermsDetails;

		private java.util.Date createDatetime;

		private String status;

}
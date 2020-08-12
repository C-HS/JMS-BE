package com.iaito.order.model.payment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "PaymentTerms")
public class PaymentTerms {
	
	 @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "payment_terms_id")
		private long paymentTermsId;
	    
		@Column(name = "payment_terms_details")
		private String paymentTermsDetails;
		
		@Column(name = "create_datetime")
		@Temporal(TemporalType.TIMESTAMP)
		private java.util.Date createDatetime;
		
		@Column(name = "status")
		private String status;

}

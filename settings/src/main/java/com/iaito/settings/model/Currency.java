package com.iaito.settings.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "Currency")
public class Currency {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "currency_id")
	private long currencyId;
	
	@Column(name = "currency_name")
	private String currencyName;
	
	@Column(name = "currency_code")
	private String currencyCode;
	
	@Column(name = "currency_logo")
	@Lob
	private byte[] currencyLogo;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;

}

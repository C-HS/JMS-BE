package com.iaito.settings.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
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
@Table(name = "Company")
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "company_id")
	private long companyId;
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "address_line1")
	private String addressLine1;
	
	@Column(name = "address_line2")
	private String addressLine2;
	
	@Column(name = "country_id")
	private long countryId;
	
	@Column(name = "state_id")
	private long stateId;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pin_code")
	private String pinCode;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name = "mobile_no")
	private String mobileNo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "website")
	private String website;
	
	@Column(name = "gstin_no")
	private String gstinNo;
	
	@Column(name = "registration_no")
	private String registrationNo;
	
	@Column(name = "currency_id")
	private long currencyId;
	
	@Column(name = "company_logo")
	@Lob
	private byte[] companyLogo;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;
	
	@OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CompanyContact> companyContactList = new ArrayList<>();

}

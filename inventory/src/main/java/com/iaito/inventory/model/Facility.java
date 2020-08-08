package com.iaito.inventory.model;

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
@Table(name = "Facility")
public class Facility {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "facility_id")
	private long facilityId;
    
	@Column(name = "facility_name")
	private String facilityName;

	
	@Column(name = "facility_type")
	private String facilityType;

	@Column(name = "company_id")
	private long companyId;

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

	@Column(name = "email")
	private String email;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;
    
}
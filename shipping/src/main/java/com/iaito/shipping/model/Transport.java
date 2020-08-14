package com.iaito.shipping.model;

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
@Table(name = "Transport")
public class Transport {
	
	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "transport_id")
		private long transportId;
		
		@Column(name = "shipment_id") // incomming/outgoing
		private long shipmentId;
	    
		@Column(name = "shipment_no") // incomming/outgoing
		private String shipmentNo;
		
		@Column(name = "shipment_type") // incomming/outgoing
		private String shipmentType;
		
		@Column(name = "transport_name")
		private String transportName;
		
		@Column(name = "transport_address")
		private String transportAddress;
		
		@Column(name = "transport_reg_no")
		private String transportRegNo;
		
		@Column(name = "document_no")
		private String documentNo;
		
		@Column(name = "vehicle_no")
		private String vehicleNo;
		
		@Column(name = "tracking_no")
		private String trackingNo;
		
		@Column(name = "tracking_link")
		private String trackingLink;
		
		@Column(name = "contact_person")
		private String contactPerson;
		
		@Column(name = "phone_no")
		private String phoneNo;
		
		@Column(name = "mobile_no")
		private String mobileNo;
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "website")
		private String website;
		
		@Column(name = "created_by")
		private long createdBy;
		
		@Column(name = "create_datetime")
		@Temporal(TemporalType.TIMESTAMP)
		private java.util.Date createDatetime;

		@Column(name = "status")
		private String status;

}

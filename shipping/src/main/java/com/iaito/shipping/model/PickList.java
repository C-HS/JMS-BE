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
@Table(name = "PickList")
public class PickList {
	
	   @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "picklist_id")
		private long picklistId;
	    
		@Column(name = "picklist_no")
		private String picklistNo;
		
		@Column(name = "outgoing_shipment_id")
		private long outgoingShipmentId;
	    
		@Column(name = "outgoing_shipment_no")
		private String outgoingShipmentNo;
		
		@Column(name = "picker")
		private long picker;
		
		@Column(name = "created_by")
		private long createdBy;
		
		@Column(name = "verified_by")
		private long verifiedBy;
		
		@Column(name = "create_datetime")
		@Temporal(TemporalType.TIMESTAMP)
		private java.util.Date createDatetime;
		
		@Column(name = "verification_datetime")
		@Temporal(TemporalType.TIMESTAMP)
		private java.util.Date verificationDatetime;

		@Column(name = "status")
		private String status;
		
		@Column(name = "pick_status")
		private String pickStatus;
		
		@Column(name = "verification_status")
		private String verificationStatus;



}

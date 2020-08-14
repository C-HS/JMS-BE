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
@Table(name = "Packaging")
public class Packaging {

	   @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "packaging_id")
		private long packagingId;
		
		@Column(name = "outgoing_shipment_id")
		private long outgoingShipmentId;
	    
		@Column(name = "outgoing_shipment_no")
		private String outgoingShipmentNo;
		
		@Column(name = "notes")
		private String notes;
		
		@Column(name = "created_by")
		private long createdBy;
		
		@Column(name = "create_datetime")
		@Temporal(TemporalType.TIMESTAMP)
		private java.util.Date createDatetime;

		@Column(name = "status")
		private String status;
		
}

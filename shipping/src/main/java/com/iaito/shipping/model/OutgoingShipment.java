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
@Table(name = "OutgoingShipment")
public class OutgoingShipment {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "outgoing_shipment_id")
	private long outgoingShipmentId;
    
	@Column(name = "outgoing_shipment_no")
	private String outgoingShipmentNo;
	
	@Column(name = "company_id")
	private long companyId;
	
	@Column(name = "customer_id")
	private long customerId;

	@Column(name = "customer_contact_id")
	private long customerContactId;

	@Column(name = "facility_id")
	private long facilityId;
	
	@Column(name = "location_id")
	private long locationId;
	
	@Column(name = "sales_order_id")
	private long salesOrderId;
	
	@Column(name = "sales_order_no")
	private String salesOrderNo;
	
	@Column(name = "scheduled_date")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date scheduledDate;
	
	@Column(name = "reference")
	private String reference;

	@Column(name = "source")
	private String source;
	
	@Column(name = "responsible_person")
	private long responsiblePerson;
	
	@Column(name = "priority")
	private String priority;
	
	@Column(name = "notes")
	private String notes;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;

//	@Column(name = "delivery_date")
//	@Temporal(TemporalType.TIMESTAMP)
//	private java.util.Date deliveryDate;

	@Column(name = "shipment_status")
	private String shipmentStatus;

//
//	@Column(name = "delivery_status")
//	private String deliveryStatus;


	@Column(name = "created_by")
	private long createdBy;


}

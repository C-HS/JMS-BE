package com.iaito.inventory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Location")
public class Location {
	
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private long locationId;
	
	@Column(name = "location_type")
	private String locationType;

	@Column(name = "area")
	private String area;

	@Column(name = "aisle")
	private String aisle;
	
	@Column(name = "section")
	private String section;
	
	@Column(name = "level")
	private String level;
	
	@Column(name = "position")
	private String position;

	@Column(name = "description")
	private String description;

	@Column(name = "lat_long")
	private String latLong;
	
	@Column(name = "tid")
	private String tid;
	
	@Column(name = "tagging_status")
	private String taggingStatus;
	
	@Column(name = "create_datetime")
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date createDatetime;
	
	@Column(name = "status")
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "facility_id")
	private Facility facility;

}

package com.iaito.inventory.dto;

import com.iaito.inventory.model.Facility;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class LocationDTO {
	
	private long locationId;
	
	private String locationType;

	private String area;

	private String aisle;
	
	private String section;
	
	private String level;
	
	private String position;

	private String description;

	private String latLong;
	
	private String tid;
	
	private String taggingStatus;
	
	private java.util.Date createDatetime;
	
	private String status;
	
	private Facility facility;

}

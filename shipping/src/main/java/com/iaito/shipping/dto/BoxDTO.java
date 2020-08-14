package com.iaito.shipping.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class BoxDTO {

	private long boxId;
	   
	private long packagingId;

	private String length;

	private String bredth;

	private String height;

	private String weight;

	private String items;

	private long itemCount;

	private java.util.Date createDatetime;

	private String status;
}

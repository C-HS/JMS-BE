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
@Table(name = "Box")
public class Box {
	
	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "box_id")
		private long boxId;
	   
	    @Column(name = "packaging_id")
		private long packagingId;
		
		@Column(name = "length")
		private String length;
	    
		@Column(name = "bredth")
		private String bredth;
		
		@Column(name = "height")
		private String height;
		
		@Column(name = "weight")
		private String weight;
		
		@Column(name = "items")
		private String items;
		
		@Column(name = "item_count")
		private long itemCount;
		
		@Column(name = "create_datetime")
		@Temporal(TemporalType.TIMESTAMP)
		private java.util.Date createDatetime;

		@Column(name = "status")
		private String status;

}

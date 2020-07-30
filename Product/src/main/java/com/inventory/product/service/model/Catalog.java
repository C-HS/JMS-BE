package com.inventory.product.service.model;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Catalog")
public class Catalog {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "catalog_id")
	private long catalogId;
	@Column(name = "catalog_name")
	private String catalogName;
    
}
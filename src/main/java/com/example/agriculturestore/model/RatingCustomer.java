package com.example.agriculturestore.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="ratingCustomer")
public class RatingCustomer implements Serializable {
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="RATINGCUSTOMER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="RATINGCUSTOMER_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="packing", nullable=false, length=10)	
	private int packing;
	
	@Column(name="qulity", nullable=false, length=10)	
	private int qulity;
	
	@Column(name="purchaseValue", nullable=false, length=10)	
	private int purchaseValue;
	
	@Column(name="nutritionalValue", nullable=false, length=10)	
	private int nutritionalValue;
	
	@Column(name="sorting", nullable=false, length=10)	
	private int sorting;
	
	@ManyToOne(targetEntity=Rating.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ratingId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKratingCust544833"))	
	private Rating rating;

}

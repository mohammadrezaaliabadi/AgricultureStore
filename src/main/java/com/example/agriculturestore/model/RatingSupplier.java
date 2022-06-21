package com.example.agriculturestore.model; /**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: 
 * License Type: Academic
 */
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
@Table(name="ratingSupplier")
public class RatingSupplier implements Serializable {
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="RATINGSUPLIER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="RATINGSUPLIER_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="checkout", nullable=false, length=10)	
	private int checkout;
	
	@Column(name="safe", nullable=false, length=10)	
	private int safe;
	
	@Column(name="simplicity", nullable=false, length=10)	
	private int simplicity;
	
	@Column(name="salesValue", nullable=false, length=10)	
	private int salesValue;
	
	@ManyToOne(targetEntity=Rating.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ratingId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKratingSupl636830"))	
	private Rating rating;
	
}

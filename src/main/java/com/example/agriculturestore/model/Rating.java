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
@Table(name="rating")
public class Rating implements Serializable {
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="RATING_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="RATING_ID_GENERATOR", strategy="native")	
	private int id;
	
	@ManyToOne(targetEntity= RatingType.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="ratingTypeId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKrating123760"))	
	private RatingType ratingType;
	
	@ManyToOne(targetEntity=Product.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="productId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKrating751113"))	
	private Product product;
	
	@ManyToOne(targetEntity=Order.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="orderId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKrating757797"))	
	private Order order;
	
	@OneToMany(mappedBy="rating", targetEntity= RatingCustomer.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ratingCustomer = new java.util.HashSet();
	
	@OneToMany(mappedBy="rating", targetEntity= RatingSupplier.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set ratingSupplier = new java.util.HashSet();
	


}

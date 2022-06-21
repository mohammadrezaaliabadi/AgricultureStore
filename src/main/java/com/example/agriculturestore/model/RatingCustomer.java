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
import java.io.Serializable;
import javax.persistence.*;
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="ratingCustomer")
public class RatingCustomer implements Serializable {
	public RatingCustomer() {
	}
	
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
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setPacking(int value) {
		this.packing = value;
	}
	
	public int getPacking() {
		return packing;
	}
	
	public void setQulity(int value) {
		this.qulity = value;
	}
	
	public int getQulity() {
		return qulity;
	}
	
	public void setPurchaseValue(int value) {
		this.purchaseValue = value;
	}
	
	public int getPurchaseValue() {
		return purchaseValue;
	}
	
	public void setNutritionalValue(int value) {
		this.nutritionalValue = value;
	}
	
	public int getNutritionalValue() {
		return nutritionalValue;
	}
	
	public void setSorting(int value) {
		this.sorting = value;
	}
	
	public int getSorting() {
		return sorting;
	}
	
	public void setRating(Rating value) {
		this.rating = value;
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}

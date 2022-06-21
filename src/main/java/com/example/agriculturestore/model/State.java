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
@Table(name="State")
public class State implements Serializable {
	public State() {
	}
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="STATE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="STATE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=false, length=50)	
	private String name;
	
	@ManyToOne(targetEntity=Country.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="countryId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKState623324"))	
	private Country country;
	
	@OneToMany(mappedBy="state", targetEntity=City.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set city = new java.util.HashSet();
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCountry(Country value) {
		this.country = value;
	}
	
	public Country getCountry() {
		return country;
	}
	
	public void setCity(java.util.Set value) {
		this.city = value;
	}
	
	public java.util.Set getCity() {
		return city;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}

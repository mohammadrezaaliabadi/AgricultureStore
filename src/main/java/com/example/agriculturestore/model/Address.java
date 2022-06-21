package com.example.agriculturestore.model;
import lombok.*;

import java.io.Serializable;
import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@org.hibernate.annotations.Proxy(lazy=false)
@Table(name="Address")
public class Address implements Serializable {
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="ADDRESS_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ADDRESS_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="postalCode", nullable=true, length=50)	
	private String postalCode;
	
	@Column(name="subAdderss", nullable=true, length=200)	
	private String subAdderss;
	
	@ManyToOne(targetEntity= City.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="cityId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKAddress72873"))	
	private City city;
	
	@ManyToMany(targetEntity= PersonalInfo.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="PersonalInfoAddress", joinColumns={ @JoinColumn(name="addressId") }, inverseJoinColumns={ @JoinColumn(name="personalInfoId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set personalInfo = new java.util.HashSet();
	
	@ManyToMany(targetEntity= Product.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="ProductAddress", joinColumns={ @JoinColumn(name="addressId") }, inverseJoinColumns={ @JoinColumn(name="productI") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set productI = new java.util.HashSet();
	
	@OneToMany(mappedBy="address", targetEntity= Order.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set order = new java.util.HashSet();
	
}

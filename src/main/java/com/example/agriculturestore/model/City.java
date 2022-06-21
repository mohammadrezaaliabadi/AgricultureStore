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
@Table(name="City")
public class City implements Serializable {

	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="CITY_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="CITY_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=false, length=50)	
	private String name;
	
	@ManyToOne(targetEntity= State.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="stateId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKCity833779"))	
	private State state;
	
	@OneToMany(mappedBy="city", targetEntity=Address.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set address = new java.util.HashSet();
	

	
}

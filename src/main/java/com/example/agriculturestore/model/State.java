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
@Table(name="State")
public class State implements Serializable {

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
	

	
}

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
@Table(name="Country")
public class Country implements Serializable {
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COUNTRY_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COUNTRY_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="ISO3166Code", nullable=false, unique=true, length=10)	
	private int ISO3166Code;
	
	@Column(name="callingCode", nullable=false, length=10)	
	private String callingCode;
	
	@OneToMany(mappedBy="country", targetEntity= State.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set state = new java.util.HashSet();
	
}

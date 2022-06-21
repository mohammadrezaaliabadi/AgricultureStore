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
@Table(name="ProductionType")
public class ProductionType implements Serializable {
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PRODUCTIONTYPE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PRODUCTIONTYPE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=false, unique=true, length=10)	
	private int name;
	
	@OneToMany(mappedBy="productionType", targetEntity=Product.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set product = new java.util.HashSet();
	
}

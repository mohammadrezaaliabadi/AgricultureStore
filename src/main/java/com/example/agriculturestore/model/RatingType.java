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
@Table(name="ratingType")
public class RatingType implements Serializable {
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="RATINGTYPE_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="RATINGTYPE_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=false, unique=true, length=10)	
	private int name;
	
	@OneToMany(mappedBy="ratingType", targetEntity=Rating.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set rating = new java.util.HashSet();

	
}

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
@Table(name="Roles")
public class Roles implements Serializable {

	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="ROLES_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ROLES_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=false, unique=true, length=100)	
	private String name;
	
	@ManyToMany(targetEntity=Users.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="UsersRoles", joinColumns={ @JoinColumn(name="rolesId") }, inverseJoinColumns={ @JoinColumn(name="usersId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set users = new java.util.HashSet();

	
}

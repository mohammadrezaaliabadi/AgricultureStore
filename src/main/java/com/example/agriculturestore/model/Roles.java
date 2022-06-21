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
	
	public void setUsers(java.util.Set value) {
		this.users = value;
	}
	
	public java.util.Set getUsers() {
		return users;
	}
	
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}

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
@Table(name="PersonalInfo")
public class PersonalInfo implements Serializable {
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PERSONALINFO_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PERSONALINFO_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="phone", nullable=false, unique=true, length=15)	
	private String phone;
	
	@Column(name="email", nullable=false, unique=true, length=255)	
	private String email;
	
	@Column(name="birthDay", nullable=true)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date birthDay;
	
	@Column(name="nationalCode", nullable=false, unique=true, length=15)	
	private int nationalCode;
	
	@Column(name="firstName", nullable=true, length=20)	
	private String firstName;
	
	@Column(name="lastName", nullable=true, length=20)	
	private String lastName;
	
	@ManyToOne(targetEntity=Users.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="usersId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKPersonalIn771947"))	
	private Users users;
	
	@ManyToMany(mappedBy="personalInfo", targetEntity=Address.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set address = new java.util.HashSet();

	
}

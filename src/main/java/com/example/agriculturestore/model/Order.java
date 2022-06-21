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
@Table(name="`Order`")
public class Order implements Serializable {
	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="ORDER_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="ORDER_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="amount", nullable=false, length=10)	
	private int amount;
	
	@Column(name="price", nullable=false, precision=19, scale=0)	
	private java.math.BigDecimal price;
	
	@Column(name="orderCode", nullable=false, length=20)	
	private int orderCode;
	
	@Column(name="createdDate", nullable=false)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date createdDate;
	
	@Column(name="dedline", nullable=false)	
	@Temporal(TemporalType.DATE)	
	private java.util.Date dedline;
	
	@ManyToOne(targetEntity= OrderStatus.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="orderStatusId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKOrder543799"))	
	private OrderStatus orderStatus;
	
	@ManyToOne(targetEntity=Address.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="addressid", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKOrder963879"))	
	private Address address;
	
	@ManyToOne(targetEntity=TransactionTypeProduct.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="transactionTypeProductTransactionTypeId", referencedColumnName="transactionTypeId", nullable=false), @JoinColumn(name="transactionTypeProductProductId", referencedColumnName="productId", nullable=false) }, foreignKey=@ForeignKey(name="FKOrder450371"))	
	private TransactionTypeProduct transactionTypeProductTransactionType;
	
	@ManyToMany(targetEntity=Users.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="UsersOrder", joinColumns={ @JoinColumn(name="orderId") }, inverseJoinColumns={ @JoinColumn(name="usersId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set users = new java.util.HashSet();
	
	@OneToMany(mappedBy="order", targetEntity= Rating.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set rating = new java.util.HashSet();
	

}

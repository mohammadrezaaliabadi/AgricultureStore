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
@Table(name="Product", indexes={ @Index(columnList="name"), @Index(columnList="productCode") })
public class Product implements Serializable {

	
	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="PRODUCT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="PRODUCT_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="name", nullable=false, length=50)	
	private String name;
	
	@Column(name="productCode", nullable=false, length=20)	
	private int productCode;
	
	@Column(name="productDescription", nullable=true, length=10)	
	private Integer productDescription;
	
	@Column(name="image", nullable=true, length=50)	
	private String image;
	
	@Column(name="packing", nullable=false, length=255)	
	private String packing;
	
	@Column(name="amount", nullable=false, length=10)	
	private int amount;
	
	@Column(name="minimumOrderQuantity", nullable=false, length=10)	
	private int minimumOrderQuantity;
	
	@Column(name="minimumPrice", nullable=true, precision=19, scale=0)	
	private java.math.BigDecimal minimumPrice;
	
	@Column(name="maximumPrice", nullable=true, precision=19, scale=0)	
	private java.math.BigDecimal maximumPrice;
	
	@Column(name="color", nullable=true, length=20)	
	private String color;
	
	@Column(name="sizeOrDimension", nullable=true, length=100)	
	private String sizeOrDimension;
	
	@Column(name="qualityAndHealthCertificate", nullable=true, length=50)	
	private String qualityAndHealthCertificate;
	
	@Column(name="status", nullable=false)	
	private boolean status;
	
	@Column(name="`like`", nullable=false, length=15)	
	private int like;
	
	@Column(name="`view`", nullable=false, length=15)	
	private int view;
	
	@Column(name="salesValue", nullable=false, length=10)	
	private int salesValue;
	
	@ManyToOne(targetEntity=BuyOrSell.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="buyOrSellid", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKProduct585535"))	
	private BuyOrSell buyOrSell;
	
	@ManyToOne(targetEntity= ProductType.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="productTypeId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKProduct990911"))	
	private ProductType productType;
	
	@ManyToOne(targetEntity= ProductionType.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="productionTypeId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKProduct656114"))	
	private ProductionType productionType;
	
	@ManyToMany(targetEntity=Users.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="UsersProduct", joinColumns={ @JoinColumn(name="productId") }, inverseJoinColumns={ @JoinColumn(name="usersId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set users = new java.util.HashSet();
	
	@ManyToMany(mappedBy="productI", targetEntity=Address.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set address = new java.util.HashSet();
	
	@OneToMany(mappedBy="product", targetEntity=TransactionTypeProduct.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set transactionTypeProduct = new java.util.HashSet();
	
	@OneToMany(mappedBy="product", targetEntity=Comment.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set comment = new java.util.HashSet();
	
	@OneToMany(mappedBy="product", targetEntity= Rating.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set rating = new java.util.HashSet();

}

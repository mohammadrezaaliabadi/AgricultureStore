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
@Table(name="TransactionTypeProduct")
@IdClass(TransactionTypeProductPK.class)
public class TransactionTypeProduct implements Serializable {

	
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof TransactionTypeProduct))
			return false;
		TransactionTypeProduct transactiontypeproduct = (TransactionTypeProduct)aObj;
		if (getTransactionType() == null) {
			if (transactiontypeproduct.getTransactionType() != null)
				return false;
		}
		else if (!getTransactionType().equals(transactiontypeproduct.getTransactionType()))
			return false;
		if (getProduct() == null) {
			if (transactiontypeproduct.getProduct() != null)
				return false;
		}
		else if (!getProduct().equals(transactiontypeproduct.getProduct()))
			return false;
		return true;
	}
	
	public int hashCode() {
		int hashcode = 0;
		if (getTransactionType() != null) {
			hashcode = hashcode + (int) getTransactionType().getId();
		}
		if (getProduct() != null) {
			hashcode = hashcode + (int) getProduct().getId();
		}
		return hashcode;
	}
	
	@PrimaryKeyJoinColumn	
	@ManyToOne(targetEntity=TransactionType.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="transactionTypeId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKTransactio174530"))	
	private TransactionType transactionType;
	
	@Column(name="transactionTypeId", nullable=false, insertable=false, updatable=false)	
	@Id	
	@GeneratedValue(generator="TRANSACTIONTYPEPRODUCT_TRANSACTIONTYPEID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="TRANSACTIONTYPEPRODUCT_TRANSACTIONTYPEID_GENERATOR", strategy="foreign", parameters=@org.hibernate.annotations.Parameter(name="property", value="transactionType"))	
	private int transactionTypeId;

	
	@PrimaryKeyJoinColumn	
	@ManyToOne(targetEntity= Product.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="productId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKTransactio705475"))	
	private Product product;
	
	@Column(name="productId", nullable=false, insertable=false, updatable=false)	
	@Id	
	@GeneratedValue(generator="TRANSACTIONTYPEPRODUCT_PRODUCTID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="TRANSACTIONTYPEPRODUCT_PRODUCTID_GENERATOR", strategy="foreign", parameters=@org.hibernate.annotations.Parameter(name="property", value="product"))	
	private int productId;

	
	@OneToMany(mappedBy="transactionTypeProductTransactionType", targetEntity= Order.class)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set order = new java.util.HashSet();

	
	
	public String toString() {
		return String.valueOf(((getTransactionType() == null) ? "" : String.valueOf(getTransactionType().getId())) + " " + ((getProduct() == null) ? "" : String.valueOf(getProduct().getId())));
	}
	
	@Transient	
	private boolean _saved = false;
	
	public void onSave() {
		_saved=true;
	}
	
	
	public void onLoad() {
		_saved=true;
	}
	
	
	public boolean isSaved() {
		return _saved;
	}
	
	
}

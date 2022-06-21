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
@Embeddable
public class TransactionTypeProductPK implements Serializable {
	public boolean equals(Object aObj) {
		if (aObj == this)
			return true;
		if (!(aObj instanceof TransactionTypeProductPK))
			return false;
		TransactionTypeProductPK transactiontypeproductpk = (TransactionTypeProductPK)aObj;
		if (getTransactionType() == null) {
			if (transactiontypeproductpk.getTransactionType() != null)
				return false;
		}
		else if (!getTransactionType().equals(transactiontypeproductpk.getTransactionType()))
			return false;
		if (getProduct() == null) {
			if (transactiontypeproductpk.getProduct() != null)
				return false;
		}
		else if (!getProduct().equals(transactiontypeproductpk.getProduct()))
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
	
	@ManyToOne(targetEntity=TransactionType.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="transactionTypeId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKTransactio174530"))	
	private TransactionType transactionType;

	
	@ManyToOne(targetEntity=Product.class, fetch=FetchType.LAZY)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="productId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKTransactio705475"))	
	private Product product;
}

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
@Table(name="Comment")
public class Comment implements Serializable {

	@Column(name="id", nullable=false, length=10)	
	@Id	
	@GeneratedValue(generator="COMMENT_ID_GENERATOR")	
	@org.hibernate.annotations.GenericGenerator(name="COMMENT_ID_GENERATOR", strategy="native")	
	private int id;
	
	@Column(name="createDate", nullable=false, length=10)	
	private int createDate;
	
	@Column(name="title", nullable=true, length=255)	
	private String title;
	
	@Column(name="pros", nullable=true, length=255)	
	private String pros;
	
	@Column(name="cons", nullable=true, length=10)	
	private Integer cons;
	
	@Column(name="commentT", nullable=false, length=255)	
	private String commentT;
	
	@Column(name="image", nullable=true, length=255)	
	private String image;
	
	@Column(name="`like`", nullable=false, length=15)	
	private int like;
	
	@Column(name="disLike", nullable=false, length=10)	
	private int disLike;
	
	@ManyToOne(targetEntity= Product.class, fetch=FetchType.LAZY)
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.LOCK})	
	@JoinColumns(value={ @JoinColumn(name="productId", referencedColumnName="id", nullable=false) }, foreignKey=@ForeignKey(name="FKComment564941"))	
	private Product product;
	
	@ManyToMany(targetEntity=Comment.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@JoinTable(name="CommentComment", joinColumns={ @JoinColumn(name="replayCommentId") }, inverseJoinColumns={ @JoinColumn(name="commentId") })	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set comment = new java.util.HashSet();
	
	@ManyToMany(mappedBy="comment", targetEntity=Comment.class)	
	@org.hibernate.annotations.Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE, org.hibernate.annotations.CascadeType.LOCK})	
	@org.hibernate.annotations.LazyCollection(org.hibernate.annotations.LazyCollectionOption.TRUE)	
	private java.util.Set replayComment = new java.util.HashSet();


	
}

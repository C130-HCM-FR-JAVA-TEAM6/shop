package com.spring.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="size")
public class Size {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sizeId;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	private String size;
	public Size() {
		// TODO Auto-generated constructor stub
	}
	
	public Size(Product product, String size) {
		super();
		this.product = product;
		this.size = size;
	}

	public long getSizeId() {
		return sizeId;
	}
	public void setSizeId(long sizeId) {
		this.sizeId = sizeId;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}

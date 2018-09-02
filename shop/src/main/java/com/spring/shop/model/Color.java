package com.spring.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="color")
public class Color {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long colorId;
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	private String color;
	public Color() {
		// TODO Auto-generated constructor stub
	}
	
	public Color(Product product, String color) {
		super();
		this.product = product;
		this.color = color;
	}

	public long getColorId() {
		return colorId;
	}
	public void setColorId(long colorId) {
		this.colorId = colorId;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}

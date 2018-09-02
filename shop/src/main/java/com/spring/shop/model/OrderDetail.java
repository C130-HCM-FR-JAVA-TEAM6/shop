package com.spring.shop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="order_detail")
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long order_detail_id;
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
	private Order order;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="color_id")
	private Color color;
	
	@ManyToOne
	@JoinColumn(name="size_id")
	private Size size;
	
	private long quantity;
	private double total;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetail(Order order, Product product, Color color, Size size, long quantity, double total) {
		super();
		this.order = order;
		this.product = product;
		this.color = color;
		this.size = size;
		this.quantity = quantity;
		this.total = total;
	}
	
	public long getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(long order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
		
	

	
	
}

package com.spring.shop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetail implements Serializable{
	@Id
//	@Column(name="orderId")
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	@Id
//	@Column(name="producId")
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product produc;
//	@Column(name="quantity")
	private long quantity;
//	@Column(name="total")
	private double total;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetail(Order order, Product produc, long quantity, double total) {
		super();
		this.order = order;
		this.produc = produc;
		this.quantity = quantity;
		this.total = total;
	}

	public Product getProduc() {
		return produc;
	}
	public void setProduc(Product produc) {
		this.produc = produc;
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

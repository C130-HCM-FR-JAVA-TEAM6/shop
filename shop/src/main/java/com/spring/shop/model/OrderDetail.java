package com.spring.shop.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetail implements Serializable{
	@Id
//	@Column(name="orderId")
	private long orderId;
	@Id
//	@Column(name="producId")
	private long producId;
//	@Column(name="quantity")
	private long quantity;
//	@Column(name="total")
	private double total;
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProducId() {
		return producId;
	}
	public void setProducId(long producId) {
		this.producId = producId;
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

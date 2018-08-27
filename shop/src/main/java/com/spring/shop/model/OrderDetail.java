package com.spring.shop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(OrderDetailPrimaryKey.class)
@Table(name="order_detail")
public class OrderDetail implements Serializable{
	@Id
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
	@Id
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	private long quantity;
	private double total;
	
	public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetail(Order order, Product product, long quantity, double total) {
		super();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
		this.total = total;
	}

	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
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
	

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public boolean equals(Object obj) {
		OrderDetail o = (OrderDetail)obj;
		if(this.product.getProductId() == o.getProduct().getProductId()) {
			return true;
		}
		return false;
	}
	
	
}

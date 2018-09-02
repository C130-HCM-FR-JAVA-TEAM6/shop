package com.spring.shop.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="[order]")
public class Order implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	private Date orderDate;
	
	@OneToMany(mappedBy="order")
	private List<OrderDetail> orderDetail;
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Order(Account account) {
		super();
		this.account = account;
	}



	public Order(Account account, Date orderDate) {
		super();
		this.account = account;
		this.orderDate = orderDate;
	}



	public Order(Account account, Date orderDate, List<OrderDetail> orderDetail) {
		super();
		this.account = account;
		this.orderDate = orderDate;
		this.orderDetail = orderDetail;
	}



	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}
	public void setOrderDetail(List<OrderDetail> orderDetail) {
		this.orderDetail = orderDetail;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return orderId+" - "+account.getAccountId()+" - "+orderDate+" - "+orderDetail;
	}
	
	
	
}

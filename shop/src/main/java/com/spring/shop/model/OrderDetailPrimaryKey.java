package com.spring.shop.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrderDetailPrimaryKey implements Serializable{
	Order order;
	Product product;
}

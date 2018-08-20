package com.spring.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="producer")
public class Producer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long producerId;
	private String producerName;
	public long getProducerId() {
		return producerId;
	}
	public void setProducerId(long producerId) {
		this.producerId = producerId;
	}
	public String getProducerName() {
		return producerName;
	}
	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}
	
}

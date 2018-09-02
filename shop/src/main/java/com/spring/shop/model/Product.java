package com.spring.shop.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	private String productName;
	private double price;
	
	@ManyToOne
	@JoinColumn(name="type_id")
	private ProductType productType;
	
	@ManyToOne
	@JoinColumn(name="producer_id")
	private Producer producer;
	
	@OneToMany(mappedBy="product")
	private List<ProductImage> productImage;
	
	@OneToMany(mappedBy="product")
	private List<Size> productSize;
	
	@OneToMany(mappedBy="product")
	private List<Color> productColor;
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public List<ProductImage> getProductImage() {
		return productImage;
	}
	public void setProductImage(List<ProductImage> productImage) {
		this.productImage = productImage;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Producer getProducer() {
		return producer;
	}
	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	public ProductType getProductType() {
		return productType;
	}
	public void setProductType(ProductType productType) {
		this.productType = productType;
	}
	public List<Size> getProductSize() {
		return productSize;
	}
	public void setProductSize(List<Size> productSize) {
		this.productSize = productSize;
	}
	public List<Color> getProductColor() {
		return productColor;
	}
	public void setProductColor(List<Color> productColor) {
		this.productColor = productColor;
	}
	
	
	
	
	
	
}

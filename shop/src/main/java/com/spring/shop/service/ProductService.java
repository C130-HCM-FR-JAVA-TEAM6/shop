package com.spring.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.spring.shop.model.Product;
import com.spring.shop.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	//showListProduct
	public String listProduct(Model model) {
		model.addAttribute("listProduct", productRepository.findAll());
		return "";
	}
	//updateProduct-AD
	public String updateProduct(@ModelAttribute("Product") Product product, Model model ) {
		productRepository.save(product);
		model.addAttribute("listProduct", productRepository.findAll());
		return "";
	}
	//deleteProduct-AD
	public String deleteProduct(@PathVariable long id,Model model) {
		productRepository.deleteById(id);
		model.addAttribute("listProduct", productRepository.findAll());
		return "";
	}
	//createProduct-AD
	public String createProduct(@ModelAttribute("Product") Product product,Model model) {
		productRepository.save(product);
		model.addAttribute("listProduct", productRepository.findAll());
		return "";
	}
	public Product getProduct(long productId) {
		return productRepository.getProduct(productId);
	}
}

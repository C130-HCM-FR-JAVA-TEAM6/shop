package com.spring.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.shop.model.Product;
import com.spring.shop.repository.ColorRepository;
import com.spring.shop.repository.ImageRepository;
import com.spring.shop.repository.ProductRepository;
import com.spring.shop.repository.ProductTypeRepository;
import com.spring.shop.repository.SizeRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ColorRepository colorRepository;
	@Autowired
	private SizeRepository sizeRepository;
	@Autowired
	private ImageRepository imageRepository;
	@Autowired
	private ProductTypeRepository productTypeRepository;

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	// updateProduct-AD
	public String updateProduct(@ModelAttribute("Product") Product product, Model model) {
		productRepository.save(product);
		model.addAttribute("listProduct", productRepository.findAll());
		return "";
	}

	// createProduct-AD
	public void createProduct(@RequestBody Product product) {
		productRepository.save(product);
	}// findByID

	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}

	// exist
	public boolean isProductExist(Product product) {
		return findById(product.getProductId()) != null;
	}

	// save
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	// delete
	public void deleteProduct(long id) {
		colorRepository.deleteAllColorProduct(productRepository.findById(id).get());
		sizeRepository.delete(productRepository.findById(id).get());
		imageRepository.deleteProductImage(productRepository.findById(id).get());
		productRepository.deleteById(id);
	}

	public Product getProduct(long productId) {
		return productRepository.getProduct(productId);
	}
	public List<Product> getMenshirtProduct(){
		return productRepository.getMenshirtProduct(productTypeRepository.findById((long) 1).get(),productTypeRepository.findById((long) 3).get());
	}
}

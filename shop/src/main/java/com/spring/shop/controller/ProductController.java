package com.spring.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.shop.model.Product;
import com.spring.shop.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductService productService;
	
//	@PreAuthorize("hasRole('member')")
	@RequestMapping("/listProduct")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
}

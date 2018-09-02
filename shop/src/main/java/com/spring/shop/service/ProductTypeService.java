package com.spring.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.model.ProductType;
import com.spring.shop.repository.ProductTypeRepository;

@Service
public class ProductTypeService {
	@Autowired
	private ProductTypeRepository productTypeRepository;
	
	public List<ProductType> getAllProductType(){
		return productTypeRepository.findAll();
	}
}

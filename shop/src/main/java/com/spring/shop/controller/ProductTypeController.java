package com.spring.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ls.LSInput;

import com.spring.shop.model.ProductType;
import com.spring.shop.service.ProductTypeService;

@RestController
@CrossOrigin(origins = "*")
public class ProductTypeController {
	@Autowired
	private ProductTypeService productTypeService;
	
	//getAllList
	@RequestMapping("/listProductType")
	public List<ProductType> getAllListProductType(){
		return productTypeService.getAllProductType();
	}
}

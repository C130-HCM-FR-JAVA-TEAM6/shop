package com.spring.shop.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.shop.model.Product;
import com.spring.shop.repository.ColorRepository;
import com.spring.shop.repository.SizeRepository;
import com.spring.shop.service.ColorService;
import com.spring.shop.service.ImageService;
import com.spring.shop.service.ProductService;
import com.spring.shop.service.SizeService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {
	
	@Autowired
	private SizeService sizeService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ColorService colorService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private ColorRepository colorRepository;
	@Autowired 
	private SizeRepository sizeRepository;
	
	List<String> files = new ArrayList<String>();
	
	//getListProduct
	@RequestMapping("/listProduct")
	public List<Product> getAllProduct(){
		return productService.getAllProduct();
	}
	
	//CreateProduct
	@RequestMapping(value = "/createProduct", method= RequestMethod.POST)
	public ResponseEntity<?> createProduct( @RequestBody Product product){
		productService.createProduct(product);
		sizeService.createSize(product.getProductId(), product.getProductSize());
		colorService.createColorProduct(product.getProductId(), product.getProductColor());
		imageService.createProductImage(product.getProductId(), product.getProductImage());
		return new ResponseEntity<Product>(product, HttpStatus.CREATED);
	}
	
	//DeleteProduct
	@RequestMapping(value = "deleteProduct/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Integer id ){
		productService.deleteProduct(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	//GetProductByID
	@RequestMapping(value = "product/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable("id") Long id ){	
		return productService.findById(id).get();
	}
	
	//UpdateProductByID
	@RequestMapping( value = "update/{id}", method = RequestMethod.PUT)
	public  ResponseEntity<?> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
		
		Optional<Product> productUpdate = productService.findById(id);
		
		if(productUpdate == null) {
			return ResponseEntity.notFound().build();
		}
		
		product.setProductId(id);
	
		productService.saveProduct(product);
		colorRepository.deleteAllColorProduct(productUpdate.get());
		colorService.createColorProduct(product.getProductId(), product.getProductColor());
		
		sizeRepository.delete(productUpdate.get());
		sizeService.createSize(product.getProductId(), product.getProductSize());
		
		imageService.deleteProductImage(productUpdate.get());
		imageService.createProductImage(product.getProductId(), product.getProductImage());
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}
	
}



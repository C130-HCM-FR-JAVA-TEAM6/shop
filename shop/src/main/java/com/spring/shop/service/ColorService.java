package com.spring.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.model.Color;
import com.spring.shop.model.Product;
import com.spring.shop.repository.ColorRepository;

@Service
public class ColorService {
	@Autowired
	private ColorRepository colorRepository;
	public Color findColor(long colorId) {
		return colorRepository.findById(colorId).get();
	}	
	@Autowired
	private ProductService productService;
	
	public List<Color> getAllColorProduct(Product product){
		return colorRepository.getAllColorProduct(product);
	}
	public boolean deleteAllColorProduct(Product product) {
		for(Color c: getAllColorProduct(product)) {
			colorRepository.deleteById(c.getColorId());
		}
		return true;
	}
	public boolean createColorProduct(long productId, List<Color> listColor) {
		for(Color c : listColor) {
			Color color = colorRepository
					.save(new Color(productService.findById(productId).get(),c.getColor()));
		}
		return true;
	}
	
	public List<Color> getAllColor(){
		return colorRepository.findAll();
	}
	
	public void createColor(Color color) {
		 colorRepository.save(color);
	}
	//save
		public List<Color> saveColor(List<Color> color) {
			return colorRepository.saveAll(color);
		}
}

package com.spring.shop.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.spring.shop.model.Product;
import com.spring.shop.model.ProductImage;
import com.spring.shop.repository.ImageRepository;

@Service
public class ImageService {
	
	org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(this.getClass().getName());
	private final java.nio.file.Path rootLocation = Paths.get("upload-dir");
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ImageRepository imageRepository;
	
	public List<ProductImage> getAllProductImage(Product product){
		return imageRepository.getAllProductImage(product);
	}
	
	public boolean deleteProductImage(Product product) {
		for(ProductImage pi : getAllProductImage(product)) {
			imageRepository.deleteById(pi.getImageId());
		}
		return true;
	}
	
	public boolean createProductImage(long productId, List<ProductImage> listProImage) {
		for(ProductImage pi : listProImage) {
			Product product = productService.findById(productId).get();
			ProductImage productImage = imageRepository.save(new ProductImage(pi.getProductImage(), product));
		}
		return true;
	}
	public void saveImage(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("FAIL!");
			// TODO: handle exception
		}
	}
	public Resource loadFile(String fileName) {
		try {
			java.nio.file.Path file = rootLocation.resolve(fileName);
			UrlResource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return (Resource) resource;
			}else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
			// TODO: handle exception
		}
	}
	public void init() {
		try {
			Files.createDirectories(rootLocation);
		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
			// TODO: handle exception
		}
	}
	
}

package com.spring.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.model.Product;
import com.spring.shop.model.Size;
import com.spring.shop.repository.SizeRepository;

@Service
public class SizeService {
	@Autowired
	private SizeRepository sizeRepository;

	public Size findSize(long sizeId) {
		return sizeRepository.findById(sizeId).get();
	}

	@Autowired
	private ProductService productService;

	public List<Size> getAllSize(Product product) {
		return sizeRepository.getAllSize(product);
	}

	public boolean deleteAllSize(Product product) {
		for (Size s : getAllSize(product)) {
			sizeRepository.deleteById(s.getSizeId());
		}
		return true;
	}

	public boolean createSize(long productId, List<Size> listSize) {
		for (Size s : listSize) {
			Size size = sizeRepository.save(new Size(productService.findById(productId).get(), s.getSize()));
		}
		return true;
	}

	// save
	public List<Size> saveSize(List<Size> size) {
		return sizeRepository.saveAll(size);
	}

}

package com.spring.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.shop.model.Product;
import com.spring.shop.model.ProductImage;

@Repository
public interface ImageRepository extends JpaRepository<ProductImage, Long>{
	@Query("select pi from ProductImage pi where pi.product = :product")
	List<ProductImage> getAllProductImage(@Param("product") Product product);
	
	@Transactional
	@Modifying
	@Query("delete ProductImage where product = :product")
	void deleteProductImage(@Param("product") Product product);
}

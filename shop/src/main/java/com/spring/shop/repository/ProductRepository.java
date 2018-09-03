package com.spring.shop.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.shop.model.Product;
import com.spring.shop.model.ProductType;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select p from Product p where p.productId = :productid")
	public Product getProduct(@Param("productid") long productId);
	
	@Query("select p from Product p where p.productType = :type1 or p.productType = :type2")
	public List<Product> getMenshirtProduct(@Param("type1") ProductType type1,@Param("type2") ProductType type2);
}

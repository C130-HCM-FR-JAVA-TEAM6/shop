package com.spring.shop.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	@Query("select p from Product p where p.productId = :productid")
	public Product getProduct(@Param("productid") long productId);
}

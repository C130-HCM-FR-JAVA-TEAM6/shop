package com.spring.shop.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.shop.model.Color;
import com.spring.shop.model.Product;
@Repository
public interface ColorRepository extends JpaRepository<Color, Long>{
	@Query("select c from Color c where c.product = :product")
	List<Color> getAllColorProduct(@Param("product") Product product);

	@Transactional
	@Modifying
	@Query("delete Color where product = :product")
	void deleteAllColorProduct(@Param("product") Product product);
}

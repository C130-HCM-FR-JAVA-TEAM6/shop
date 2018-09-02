package com.spring.shop.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.shop.model.Product;
import com.spring.shop.model.Size;
@Repository
public interface SizeRepository extends JpaRepository<Size, Long>{
	@Query("select s from Size s where s.product = :product")
	List<Size> getAllSize(@Param("product") Product product);
	
	
	@Transactional
	@Modifying
	@Query("delete Size where product = :product")
	void delete(@Param("product") Product product);
}

package com.spring.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.spring.shop.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}

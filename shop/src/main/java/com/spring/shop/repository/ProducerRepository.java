package com.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.shop.model.Producer;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long>{

}

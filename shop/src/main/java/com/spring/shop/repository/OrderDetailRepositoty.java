package com.spring.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.shop.model.OrderDetail;
import com.spring.shop.model.OrderDetailPrimaryKey;
@Repository
public interface OrderDetailRepositoty extends JpaRepository<OrderDetail,OrderDetailPrimaryKey>{

}
  
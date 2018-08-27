package com.spring.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.model.OrderDetail;
import com.spring.shop.repository.OrderDetailRepositoty;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepositoty orderDetailSercive;
	public boolean saveOrderDetail(List<OrderDetail> list) {
		try {
			for(OrderDetail o:list) {
				orderDetailSercive.save(o);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
}

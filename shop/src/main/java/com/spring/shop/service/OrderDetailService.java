package com.spring.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.model.OrderDetail;
import com.spring.shop.repository.OrderDetailRepositoty;

@Service
public class OrderDetailService {
	@Autowired
	private OrderDetailRepositoty orderDetailRepository;
	@Autowired
	private ProductService productSevice;
	@Autowired
	private OrderService orderService;
	public boolean saveOrderDetail(List<OrderDetail> list) {
		for(OrderDetail o:list) {
			orderDetailRepository.save(o);
		}
		return true;
	}
	public List<OrderDetail> findAll(){
		return orderDetailRepository.findAll();
	}
//	public OrderDetail saveOrderDetail() {
//		return orderDetailRepository.save(new OrderDetail(orderService.findById(3).getOrderId(), productSevice.getProduct(3).getProductId(), 1, 500000));
//	}
}

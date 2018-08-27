package com.spring.shop.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.SessionScope;

import com.spring.shop.model.Account;
import com.spring.shop.model.Order;
import com.spring.shop.model.OrderDetail;
import com.spring.shop.model.Product;
import com.spring.shop.repository.OrderRepository;



@Service
@Transactional
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private ProductService productService;
	@Autowired
	private AccountService accountService;
	
	public Order createOrder(long accountId) {
		Account account = accountService.findById(accountId);
		java.util.Date date = new java.util.Date();
		Date sqldate = new Date(date.getYear(), date.getMonth(), date.getDay());
		List<OrderDetail> listOrderDetail = new ArrayList<>();
		Order order = new Order(account,sqldate,listOrderDetail);
 		return order;
	}
	public Order findById(long orderId) {
		return orderRepository.findById(orderId).get();
	}
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}
	public List<Order> findAllOrder(){
		return orderRepository.findAll();
	}
}

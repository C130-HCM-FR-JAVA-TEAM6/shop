package com.spring.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.shop.model.Color;
import com.spring.shop.model.Order;
import com.spring.shop.model.OrderDetail;
import com.spring.shop.model.Product;
import com.spring.shop.model.Size;
import com.spring.shop.service.AccountService;
import com.spring.shop.service.ColorService;
import com.spring.shop.service.OrderDetailService;
import com.spring.shop.service.OrderService;
import com.spring.shop.service.ProductService;
import com.spring.shop.service.SizeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@Autowired
	private SizeService sizeService;
	
	@Autowired
	private ColorService colorService;
	
	@PostMapping("/getOrder")
	public Order getOrder(@RequestBody Order order){
		List<OrderDetail> list = order.getOrderDetail();
		for(int i =0 ;i<list.size();i++) {
			Product product = productService.getProduct(list.get(i).getProduct().getProductId());
			Size size = sizeService.findSize(list.get(i).getSize().getSizeId());
			Color color = colorService.findColor(list.get(i).getColor().getColorId());
			list.set(i, new OrderDetail(order, product,color,size, list.get(i).getQuantity(), list.get(i).getQuantity()*product.getPrice()));
		}
		return new Order(order.getAccount(), order.getOrderDate(),list);
	}
	@PostMapping("/addOrder")
	public ResponseEntity<?> addOrder(@RequestBody Order order){
		List<OrderDetail> list = order.getOrderDetail();

		Order orderInsert = orderService.saveOrder(new Order(order.getAccount(), order.getOrderDate()));
		
		for(int i =0 ;i<list.size();i++) {
			Product product = productService.getProduct(list.get(i).getProduct().getProductId());
			Size size = sizeService.findSize(list.get(i).getSize().getSizeId());
			Color color = colorService.findColor(list.get(i).getColor().getColorId());
			list.set(i, new OrderDetail(orderInsert, product,color,size,list.get(i).getQuantity(), list.get(i).getQuantity()*product.getPrice()));
		}
		boolean check = orderDetailService.saveOrderDetail(list);
		orderInsert.setOrderDetail(list);
		if(check) {
			return new ResponseEntity<Order>(orderInsert,HttpStatus.OK);
		}else {
			return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
		}
		
	}
	@RequestMapping("/getOrderDetail")
	public List<OrderDetail> getOrderDetail(){
		return orderDetailService.findAll();
	}
	
}

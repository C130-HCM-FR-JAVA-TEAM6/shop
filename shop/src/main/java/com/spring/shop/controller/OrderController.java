package com.spring.shop.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.shop.model.Account;
import com.spring.shop.model.Order;
import com.spring.shop.model.OrderDetail;
import com.spring.shop.model.Product;
import com.spring.shop.service.AccountService;
import com.spring.shop.service.OrderService;
import com.spring.shop.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/addOrder/{productId}/accountId")
	public Order addOrder(HttpServletRequest request, HttpServletResponse response,@PathVariable("productId") long productId, @PathVariable("accountId") long accountId){
		HttpSession session = request.getSession();
		if(session.getAttribute(String.valueOf(accountId)) == null) {
			Order order = orderService.createOrder(2);
			session.setAttribute("member1",order);
			System.out.println("session null and create new session");
			return order;
		}else {
			Order order = (Order) session.getAttribute(String.valueOf(accountId));
			List<OrderDetail> listOrder = order.getOrderDetail();
			Product product = productService.getProduct(productId);
			listOrder.add(new OrderDetail(orderService.findById(order.getOrderId()),product,1,product.getPrice()));
			order.setOrderDetail(listOrder);
			session.setAttribute("member1", order);
			System.out.println("session exsits");
			return order;
		}
		
	}
	@RequestMapping("/addProductToCart")
	public Order addProduct(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		long accountId = Long.valueOf(request.getParameter("accountId"));
		long productId = Long.valueOf(request.getParameter("productId"));
		if(session.getAttribute(String.valueOf(accountId)) == null) {
			Order order = orderService.createOrder(accountId);
			List<OrderDetail> listOrder = new ArrayList<>();
			Product product = productService.getProduct(productId);
			listOrder.add(new OrderDetail(order,product,1,product.getPrice()));
			order.setOrderDetail(listOrder);
			session.setAttribute(String.valueOf(accountId),order);
			return order;
		}else {
			Order order = (Order) session.getAttribute(String.valueOf(accountId));
			List<OrderDetail> listOrder = order.getOrderDetail();
			Product product = productService.getProduct(productId);
			listOrder.add(new OrderDetail(order,product,1,product.getPrice()));
			order.setOrderDetail(listOrder);
			session.setAttribute(String.valueOf(accountId), order);
			return order;
		}
	}
	
//	@RequestMapping("/subtracProduct/{productId}")
//	public void subtracProduct(@PathVariable("productId") long productId) {
//		orderService.subtracProduct(productId);
//	}
//	
//	@RequestMapping("/order")
//	public List<Product> getOrder(){
//		Map<Long, Integer> order = orderService.getCart();
//		List<Product> listOrder = new ArrayList<>();
//		for(Map.Entry<Long, Integer> item : order.entrySet()) {
//			System.out.println(item.getKey());
//			listOrder.add(productService.getProduct(item.getValue()));
//		}
//		System.out.println(order.toString());
//		return listOrder;
//	}
}

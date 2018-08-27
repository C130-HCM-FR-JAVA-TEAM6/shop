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
import org.springframework.http.StreamingHttpOutputMessage.Body;
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
import com.spring.shop.service.OrderDetailService;
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
	
	@Autowired
	private OrderDetailService orderDetailService;
	@RequestMapping("/addOrder")
	public ResponseEntity<?> addOrder(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		long accountId = Long.valueOf(request.getParameter("accountId"));
		
		if(session.getAttribute(String.valueOf(accountId)) == null) {
			Order order = orderService.createOrder(accountId);
			return new ResponseEntity<Order>(order,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			Order order = (Order) session.getAttribute(String.valueOf(accountId));
			List<OrderDetail> list = order.getOrderDetail();
			order = orderService.saveOrder(new Order(order.getAccount(), order.getOrderDate()));
			
			System.out.println(list.size());
			for(int i=0;i<list.size();i++) {
				list.get(i).setOrder(order);
			}
			orderDetailService.saveOrderDetail(list);
			return new ResponseEntity<Order>(order,HttpStatus.OK);
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
			
			OrderDetail orderDetail;
			boolean content = false;
			for(int i=0;i<listOrder.size();i++) {
				if(listOrder.get(i).getProduct().getProductId() == productId) {
					orderDetail = listOrder.get(i);
					orderDetail.setQuantity(orderDetail.getQuantity() + 1);
					listOrder.set(i, orderDetail);
					content = true;
				}
			}
			if(!content) {
				orderDetail = new OrderDetail(order,product,1,product.getPrice());
				listOrder.add(orderDetail);
			}
			
			order.setOrderDetail(listOrder);
			session.setAttribute(String.valueOf(accountId), order);
			return order;
		}
	}
	
	@RequestMapping("/subtracProductToCart")
	public ResponseEntity<?> subtracProduct(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		long accountId = Long.valueOf(request.getParameter("accountId"));
		long productId = Long.valueOf(request.getParameter("productId"));
		if(session.getAttribute(String.valueOf(accountId)) == null) {
			Order order = orderService.createOrder(accountId);
			return new ResponseEntity<Order>(order,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			Order order = (Order) session.getAttribute(String.valueOf(accountId));
			List<OrderDetail> listOrder = order.getOrderDetail();
			Product product = productService.getProduct(productId);
			
			OrderDetail orderDetail;
			boolean content = false;
			for(int i=0;i<listOrder.size();i++) {
				if(listOrder.get(i).getProduct().getProductId() == productId) {
					orderDetail = listOrder.get(i);
					if(orderDetail.getQuantity() > 1) {
						orderDetail.setQuantity(orderDetail.getQuantity() - 1);
						listOrder.set(i, orderDetail);
					}
					else {
						listOrder.remove(i);
					}
					content = true;
				}
			}
			if(!content) {
				orderDetail = new OrderDetail(order,product,1,product.getPrice());
				listOrder.add(orderDetail);
			}
			
			order.setOrderDetail(listOrder);
			session.setAttribute(String.valueOf(accountId), order);
			return new ResponseEntity<Order>(order,HttpStatus.OK);
		}
	}
	
	@RequestMapping("/deleteProductToCart")
	public ResponseEntity<?> deleteProduct(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		long accountId = Long.valueOf(request.getParameter("accountId"));
		long productId = Long.valueOf(request.getParameter("productId"));
		if(session.getAttribute(String.valueOf(accountId)) == null) {
			Order order = orderService.createOrder(accountId);
			return new ResponseEntity<Order>(order,HttpStatus.INTERNAL_SERVER_ERROR);
		}else {
			Order order = (Order) session.getAttribute(String.valueOf(accountId));
			List<OrderDetail> listOrder = order.getOrderDetail();	

			for(int i=0;i<listOrder.size();i++) {
				if(listOrder.get(i).getProduct().getProductId() == productId) {
					listOrder.remove(i);
				}
			}
			
			order.setOrderDetail(listOrder);
			session.setAttribute(String.valueOf(accountId), order);
			return new ResponseEntity<Order>(order,HttpStatus.OK);
		}
	}
	@RequestMapping("/getOrder")
	public List<Order> getOrder(){
		return orderService.findAllOrder();
	}
}

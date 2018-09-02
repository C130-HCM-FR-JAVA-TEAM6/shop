package com.spring.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.shop.model.Producer;
import com.spring.shop.service.ProducerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProducerController {
	@Autowired
	private ProducerService producerService;
	
	//getAllList
	@RequestMapping("/listProducer")
	public List<Producer> getAllProducer(){
		return producerService.getAllProducer();
	}
}

package com.spring.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.shop.model.Producer;
import com.spring.shop.repository.ProducerRepository;

@Service
public class ProducerService {
	@Autowired
	private ProducerRepository producerRepository;
	
	public List<Producer> getAllProducer(){
		return producerRepository.findAll();
	}
}

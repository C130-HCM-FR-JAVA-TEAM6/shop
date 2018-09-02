package com.spring.shop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.shop.model.Color;
import com.spring.shop.service.ColorService;
import com.spring.shop.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ColorController {

	@Autowired
	private ColorService colorService;

	@RequestMapping(value = "/createColor", method = RequestMethod.POST)
	public ResponseEntity<?> createColor(@RequestBody Color color) {
		colorService.createColor(color);
		return new ResponseEntity<Color>(color, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/listColor", method = RequestMethod.GET)
	public ResponseEntity<List<Color>> getAllColor() {
		List<Color> colorList = colorService.getAllColor();
		if (colorList.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Color>>(colorList, HttpStatus.OK);
	}
}

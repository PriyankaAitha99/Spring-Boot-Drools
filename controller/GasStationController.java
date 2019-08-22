package com.egiants.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.egiants.Products;
import com.egiants.service.GasStationService;

@RestController
public class GasStationController {

	private final GasStationService GasStationService;

	@Autowired
	public GasStationController(GasStationService GasStationService) {
		this.GasStationService = GasStationService;
	}

	@RequestMapping(value = "/getTax", method = RequestMethod.GET, produces = "application/json")
	public Products getQuestions(@RequestParam(required = true) String type) {

		Products product = new Products();
		product.setType(type);
		GasStationService.getProductTax(product);
		return product;
	}
}
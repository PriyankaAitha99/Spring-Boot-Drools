package com.egiants.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egiants.Products;

@Service
public class GasStationService {

	private final KieContainer kieContainer;

	@Autowired
	public GasStationService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Products getProductTax(Products product) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}
}
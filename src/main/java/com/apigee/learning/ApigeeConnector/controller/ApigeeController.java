package com.apigee.learning.ApigeeConnector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apigee.learning.ApigeeConnector.model.AppCreationRequest;
import com.apigee.learning.ApigeeConnector.model.DeveloperRequest;
import com.apigee.learning.ApigeeConnector.model.ProductRequest;
import com.apigee.learning.ApigeeConnector.model.ProxyRequest;
import com.apigee.learning.ApigeeConnector.service.ApigeeService;

@RestController
@RequestMapping("/apigee")
public class ApigeeController {
	@Autowired
	private ApigeeService apigeeService;


	@GetMapping("/product")
	public ResponseEntity<String> getProducts() {
		return apigeeService.getProduct();
	}
	
	@PostMapping("/product/create")
	public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
		return apigeeService.createProduct(productRequest);
	}

	@PostMapping("/proxy/create")
	public ResponseEntity<String> createProxy(@RequestBody ProxyRequest proxyRequest) {
		return apigeeService.createProxy(proxyRequest);
	}

	@GetMapping("/proxy")
	public ResponseEntity<String> getProxies() {
		return apigeeService.getProxies();
	}

	@GetMapping("/developers")
	public ResponseEntity<String> getDevelopers() {
		return apigeeService.getDevelopers();
	}
	

	@PostMapping("/developer/create")
	public ResponseEntity<String> createDeveloper(@RequestBody DeveloperRequest developerRequest) {
		return apigeeService.createDeveloper(developerRequest);
	}
	
	@GetMapping("/apps/{developer_email}")
	public ResponseEntity<String> getApp(@PathVariable String developer_email) {
		return apigeeService.getApps(developer_email);
	}

	@PostMapping("/apps/create/{developer_email}")
	public ResponseEntity<String> createApp(@RequestBody AppCreationRequest appCreationRequest,
			@PathVariable String developer_email) {
		return apigeeService.createApp(appCreationRequest, developer_email);
	}
}

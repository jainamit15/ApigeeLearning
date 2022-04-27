package com.apigee.learning.ApigeeConnector.service;

import org.springframework.http.ResponseEntity;

import com.apigee.learning.ApigeeConnector.model.AppCreationRequest;
import com.apigee.learning.ApigeeConnector.model.DeveloperRequest;
import com.apigee.learning.ApigeeConnector.model.ProductRequest;
import com.apigee.learning.ApigeeConnector.model.ProxyRequest;

public interface ApigeeService {

	ResponseEntity<String> createProduct(ProductRequest productRequest);

	ResponseEntity<String> createProxy(ProxyRequest proxyRequest);

	ResponseEntity<String> createDeveloper(DeveloperRequest developerRequest);

	ResponseEntity<String> createApp(AppCreationRequest appCreationRequest, String developer_email);

	ResponseEntity<String> getProxies();

	ResponseEntity<String> getProduct();

	ResponseEntity<String> getDevelopers();

	ResponseEntity<String> getApps(String developer_email);

}

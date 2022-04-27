package com.apigee.learning.ApigeeConnector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apigee.learning.ApigeeConnector.model.AppCreationRequest;
import com.apigee.learning.ApigeeConnector.model.DeveloperRequest;
import com.apigee.learning.ApigeeConnector.model.ProductRequest;
import com.apigee.learning.ApigeeConnector.model.ProxyRequest;

@Service
public class ApigeeServiceImpl implements ApigeeService {

	@Autowired
	RestTemplate restTemplate;
	@Value("${apigee.organization.name}")
	private String organizationName;

	@Override
	public ResponseEntity<String> createProduct(ProductRequest productRequest) {
		ResponseEntity<String> message = restTemplate.exchange(
				"https://api.enterprise.apigee.com/v1/organizations/" + organizationName + "/apiproducts",
				HttpMethod.POST, requestEntity(productRequest), String.class);
		System.out.println(message);
		return new ResponseEntity<>("API Product Created", HttpStatus.CREATED);
	}

	private HttpEntity<?> requestEntity(ProductRequest productRequest) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic cml6dmlrYXZpc2gyMDVAZ21haWwuY29tOkFwcGxlaXBob25lQDEz");
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(productRequest, headers);
	}

	@Override
	public ResponseEntity<String> createProxy(ProxyRequest proxyRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic cml6dmlrYXZpc2gyMDVAZ21haWwuY29tOkFwcGxlaXBob25lQDEz");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity requestEntity = new HttpEntity<>(proxyRequest, headers);
		ResponseEntity<String> message = restTemplate.exchange(
				"https://api.enterprise.apigee.com/v1/organizations/" + organizationName + "/apis", HttpMethod.POST,
				requestEntity, String.class);
		System.out.println(message);
		return new ResponseEntity<>("API Proxy Created", HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<String> createDeveloper(DeveloperRequest developerRequest) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic cml6dmlrYXZpc2gyMDVAZ21haWwuY29tOkFwcGxlaXBob25lQDEz");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity requestEntity = new HttpEntity<>(developerRequest, headers);
		ResponseEntity<String> message = restTemplate.exchange(
				"https://api.enterprise.apigee.com/v1/organizations/" + organizationName + "/developers",
				HttpMethod.POST, requestEntity, String.class);

		return message;
	}

	@Override
	public ResponseEntity<String> createApp(AppCreationRequest appCreationRequest, String developer_email) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic cml6dmlrYXZpc2gyMDVAZ21haWwuY29tOkFwcGxlaXBob25lQDEz");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity requestEntity = new HttpEntity<>(appCreationRequest, headers);
		String url = "https://api.enterprise.apigee.com/v1/organizations/" + organizationName + "/developers/"
				+ developer_email + "/apps";
		ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
		return exchange;
	}

	public ResponseEntity<String> getProxies() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic cml6dmlrYXZpc2gyMDVAZ21haWwuY29tOkFwcGxlaXBob25lQDEz");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity requestEntity = new HttpEntity<>(headers);

		ResponseEntity<String> exchange = restTemplate.exchange(
				"https://api.enterprise.apigee.com/v1/organizations/" + organizationName + "/apis", HttpMethod.GET,
				requestEntity, String.class);
		return exchange;
	}

	@Override
	public ResponseEntity<String> getProduct() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic cml6dmlrYXZpc2gyMDVAZ21haWwuY29tOkFwcGxlaXBob25lQDEz");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity requestEntity = new HttpEntity<>(headers);

		ResponseEntity<String> exchange = restTemplate.exchange(
				"https://api.enterprise.apigee.com/v1/organizations/" + organizationName + "/apiproducts",
				HttpMethod.GET, requestEntity, String.class);
		return exchange;
	}

	@Override
	public ResponseEntity<String> getDevelopers() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic cml6dmlrYXZpc2gyMDVAZ21haWwuY29tOkFwcGxlaXBob25lQDEz");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity requestEntity = new HttpEntity<>(headers);

		ResponseEntity<String> exchange = restTemplate.exchange(
				"https://api.enterprise.apigee.com/v1/organizations/" + organizationName + "/developers",
				HttpMethod.GET, requestEntity, String.class);
		return exchange;
	}

	@Override
	public ResponseEntity<String> getApps(String developer_email) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Basic cml6dmlrYXZpc2gyMDVAZ21haWwuY29tOkFwcGxlaXBob25lQDEz");
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity requestEntity = new HttpEntity<>(headers);

		ResponseEntity<String> exchange = restTemplate.exchange("https://api.enterprise.apigee.com/v1/organizations/"
				+ organizationName + "/developers/" + developer_email + "/apps", HttpMethod.GET, requestEntity,
				String.class);
		return exchange;
	}
}

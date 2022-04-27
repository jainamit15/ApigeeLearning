package com.apigee.learning.ApigeeConnector.model;

import java.util.List;


public class AppCreationRequest {
	private List<String> apiProducts;
	private List<Attributes> attributes;
	private String callbackUrl;
	private String name;
	private List<String> scopes;
	private String status;

	public List<String> getApiProducts() {
		return apiProducts;
	}

	public void setApiProducts(List<String> apiProducts) {
		this.apiProducts = apiProducts;
	}

	public List<Attributes> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<Attributes> attributes) {
		this.attributes = attributes;
	}

	public String getCallbackUrl() {
		return callbackUrl;
	}

	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getScopes() {
		return scopes;
	}

	public void setScopes(List<String> scopes) {
		this.scopes = scopes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

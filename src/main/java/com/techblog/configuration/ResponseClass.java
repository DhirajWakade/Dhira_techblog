package com.techblog.configuration;

import java.util.Map;

public class ResponseClass<T>
 {
	
	T result;
	String message;
	String status;
	Map<String,String>validationMessage;
	
	public ResponseClass(String message, String status, Map<String, String> validationMessage) {
		this.message = message;
		this.status = status;
		this.validationMessage = validationMessage;
	}
	public ResponseClass(T result, String message, String status) {
		
		this.result = result;
		this.message = message;
		this.status = status;
	}
	public T getResult() {
		return result;
	}
	public void setResult(T result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, String> getValidationMessage() {
		return validationMessage;
	}
	public void setValidationMessage(Map<String, String> validationMessage) {
		this.validationMessage = validationMessage;
	}

}

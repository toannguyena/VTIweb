package com.vti.academy.web.exception;

import java.util.Map;

public class ErrorResponse {
	private int code;
	private String message;
	private Map<String, String> errors;

	public ErrorResponse(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public ErrorResponse(int code, String message, Map<String, String> errors) {
		this.code = code;
		this.message = message;
		this.errors = errors;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

}

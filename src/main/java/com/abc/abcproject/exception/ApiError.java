package com.abc.abcproject.exception;

import org.springframework.http.HttpStatus;

public class ApiError {

	   private HttpStatus status;
	   private String message;

	   public ApiError(HttpStatus status) {
	       this.status = status;
	   }

	   public ApiError(HttpStatus status, Throwable ex) {
	       this.status = status;
	       this.message = "Unexpected error";
	   }

	   public ApiError(HttpStatus status, String message, Throwable ex) {
	       this.status = status;
	       this.message = message;
	   }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	   
	   
}

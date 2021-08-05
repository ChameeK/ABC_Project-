package com.abc.abcproject.controller;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.abc.abcproject.exception.ApiError;
import com.abc.abcproject.exception.NoRecordFoundException;
import com.abc.abcproject.exception.ServerErrorException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	  
	   @ExceptionHandler(NoRecordFoundException.class)
	   protected ResponseEntity<Object> handleNoRecordFound(NoRecordFoundException ex) {
	       ApiError apiError = new ApiError(HttpStatus.NO_CONTENT);
	       apiError.setMessage(ex.getMessage());
	       return buildResponseEntity(apiError);
	   }
	   
	   @ExceptionHandler(ServerErrorException.class)
	   protected ResponseEntity<Object> handleServerError(
			   ServerErrorException ex) {
	       ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR);
	       apiError.setMessage(ex.getMessage());
	       return buildResponseEntity(apiError);
	   }
	   
	   private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
	       return new ResponseEntity<>(apiError, apiError.getStatus());
	   }
}

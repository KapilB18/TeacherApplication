package com.teacher.app.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.teacher.app.APIResponse.APIResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

	public ResponseEntity<APIResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		String message = ex.getMessage();
		APIResponse response = APIResponse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
		return new ResponseEntity<APIResponse>(response, HttpStatus.NOT_FOUND);
	}
}

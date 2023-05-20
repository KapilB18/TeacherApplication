package com.teacher.app.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Resource with id not found on server");
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
}

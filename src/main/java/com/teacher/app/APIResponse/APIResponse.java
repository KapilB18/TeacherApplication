package com.teacher.app.APIResponse;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class APIResponse {
	
	private String message;
	private boolean success;
	private HttpStatus status;

}

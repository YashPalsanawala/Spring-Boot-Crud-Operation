package com.example.Student.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFound extends Exception{

	public static final long id = 1L;

	public RecordNotFound(String message) {
		super(message);
	}
	
	
}

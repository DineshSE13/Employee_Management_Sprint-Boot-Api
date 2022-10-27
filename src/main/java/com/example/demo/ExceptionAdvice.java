package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleinvalidargument(MethodArgumentNotValidException me) {
		Map<String, String> errormap = new HashMap<>();
		me.getBindingResult().getFieldErrors().forEach(error->{
			errormap.put(error.getField(), error.getDefaultMessage());
		});
		return errormap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ExceptionHandle.class)
	public Map<String,String> handleId(ExceptionHandle ec){
		Map<String,String> errormap = new HashMap<>();
		errormap.put("ErrorMessage", ec.getMessage());
		return errormap;
	}
	

	
}

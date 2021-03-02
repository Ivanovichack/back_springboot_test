package com.users.microservice.exceptions;

import java.io.IOException;
import java.text.ParseException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import com.users.microservice.dto.responses.ResponseBad;


@ControllerAdvice
public class RestExceptionHandler extends ExceptionHandlerExceptionResolver{
	
	@ExceptionHandler(CustomException.class)
	public ResponseEntity<Object> customExceptionHandler(CustomException ex){
		ResponseBad response = new ResponseBad();
		response.setMessage("Excepcion");
		response.addDetail(ex.getMessage());
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ParseException.class)
	public ResponseEntity<Object> parseExceptionHandler(ParseException ex){
		ResponseBad response = new ResponseBad();
		response.setMessage("Excepcion");
		response.addDetail(ex.getMessage());
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<Object> parseExceptionHandler(IOException ex){
		ResponseBad response = new ResponseBad();
		response.setMessage("Excepcion");
		response.addDetail(ex.getMessage());
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<Object> handleMethodNotSupportedException(HttpRequestMethodNotSupportedException ex){
		ResponseBad response = new ResponseBad();
		response.setMessage("Metodo no soportado");
		response.addDetail(ex.getMessage());
		return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);
	}
	
	
}

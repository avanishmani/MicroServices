package com.mrTripathi.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyError> myException(IllegalArgumentException ex, WebRequest wb) {
		MyError e1 = new MyError(LocalDateTime.now(), ex.getMessage(), wb.getDescription(false));
		return new ResponseEntity<MyError>(e1, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<MyError> UserException(UserException ex, WebRequest wb) {
		MyError e1 = new MyError(LocalDateTime.now(), ex.getMessage(), wb.getDescription(false));
		return new ResponseEntity<MyError>(e1, HttpStatus.BAD_GATEWAY);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> Exception(Exception ex, WebRequest wb) {
		MyError e1 = new MyError(LocalDateTime.now(), ex.getMessage(), wb.getDescription(false));
		return new ResponseEntity<MyError>(e1, HttpStatus.BAD_GATEWAY);
	}
}

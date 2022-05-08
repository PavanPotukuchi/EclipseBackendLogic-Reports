package com.edonation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.edonation.model.exception.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidDataException.class)
	public ResponseEntity<ExceptionResponse> handler(InvalidDataException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value());
		return  new ResponseEntity<>(exception,
				HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DonorNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(DonorNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(exception,
				HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(NgoNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handler(NgoNotFoundException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(exception,
				HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DonationDateIsPastFutureException.class)
	public ResponseEntity<ExceptionResponse> handler(DonationDateIsPastFutureException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value());
		return  new ResponseEntity<>(exception,
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidEstablishedDateException.class)
	public ResponseEntity<ExceptionResponse> handler(InvalidEstablishedDateException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value());
		return  new ResponseEntity<>(exception,
				HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidDonationDateException.class)
	public ResponseEntity<ExceptionResponse> handler(InvalidDonationDateException ex) {
		ExceptionResponse exception = new ExceptionResponse(ex.getMessage(), System.currentTimeMillis(),
				HttpStatus.BAD_REQUEST.value());
		return  new ResponseEntity<>(exception,
				HttpStatus.BAD_REQUEST);
	}

}

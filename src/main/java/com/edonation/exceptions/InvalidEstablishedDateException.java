package com.edonation.exceptions;

public class InvalidEstablishedDateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidEstablishedDateException() {
		super();
	}

	public InvalidEstablishedDateException(String message) {
		super(message);
	}

}

package com.edonation.exceptions;

public class DonorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DonorNotFoundException() {
		super();
	}

	public DonorNotFoundException(String message) {
		super(message);
	}

}

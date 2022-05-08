package com.edonation.exceptions;

public class InvalidDonationDateException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidDonationDateException() {
		super();
	}

	public InvalidDonationDateException(String message) {
		super(message);
	}

}

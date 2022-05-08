package com.edonation.exceptions;

public class InvalidDonationAmountException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidDonationAmountException() {
		super();
	}

	public InvalidDonationAmountException(String message) {
		super(message);
	}

}

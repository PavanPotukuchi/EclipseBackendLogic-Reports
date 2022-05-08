package com.edonation.exceptions;

public class DonationDateIsPastFutureException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DonationDateIsPastFutureException() {
		super();
	}

	public DonationDateIsPastFutureException(String message) {
		super(message);
	}

}

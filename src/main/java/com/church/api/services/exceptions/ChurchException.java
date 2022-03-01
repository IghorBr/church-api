package com.church.api.services.exceptions;

public class ChurchException extends RuntimeException {
	private static final long serialVersionUID = -4687980263030552092L;

	public ChurchException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChurchException(String message) {
		super(message);
	}
}
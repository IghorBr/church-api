package com.church.api.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -8746215233838408717L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundException(String message) {
		super(message);
	}
}
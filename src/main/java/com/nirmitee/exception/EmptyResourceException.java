package com.nirmitee.exception;

public class EmptyResourceException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmptyResourceException() {
		super();
	}

	public EmptyResourceException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmptyResourceException(String message) {
		super(message);
	}

	public EmptyResourceException(Throwable cause) {
		super(cause);
	}
}

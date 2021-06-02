package com.nirmitee.exception;

public class DataNotStoredException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotStoredException() {
		super();
	}

	public DataNotStoredException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataNotStoredException(String message) {
		super(message);
	}

	public DataNotStoredException(Throwable cause) {
		super(cause);
	}
}

/**
 * 
 */
package com.nirmitee.exception;

/**
 * @author SV0205
 *
 */
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidInputException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidInputException(String message) {
		super(message);
	}

	public InvalidInputException(Throwable cause) {
		super(cause);
	}
}

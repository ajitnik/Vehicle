/**
 * 
 */
package com.nirmitee.exception;

/**
 * @author SV0205
 *
 */
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
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

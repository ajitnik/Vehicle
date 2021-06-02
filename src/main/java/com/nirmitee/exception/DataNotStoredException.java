/**
 * 
 */
package com.nirmitee.exception;

/**
 * @author SV0205
 *
 */
//@ResponseStatus(value = HttpStatus.NOT_FOUND)
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

package com.assignment.exceptions;

/**
 * @author Nagaraj
 *
 */
public class PropertyException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5409419100057731406L;

	/**
	 * @param message
	 * @param cause
	 */
	public PropertyException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public PropertyException(String message) {
		super(message);
	}

}

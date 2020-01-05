package com.mimacom.carlos.mimacom.model;

/**
 * The Class ErrorResponse.
 */
public class ErrorResponse {
	
	private String message;

	/**
	 * Instantiates a new error response.
	 */
	public ErrorResponse() {
		super();
	}

	/**
	 * Instantiates a new error response.
	 *
	 * @param message the message
	 */
	public ErrorResponse(String message) {
		super();
		this.message = message;
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}

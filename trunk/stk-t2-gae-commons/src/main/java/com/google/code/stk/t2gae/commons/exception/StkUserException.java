package com.google.code.stk.t2gae.commons.exception;

public class StkUserException extends RuntimeException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	public StkUserException() {
		super();
	}

	public StkUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public StkUserException(String message) {
		super(message);
	}

	public StkUserException(Throwable cause) {
		super(cause);
	}

}

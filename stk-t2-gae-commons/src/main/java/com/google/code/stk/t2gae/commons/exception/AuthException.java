package com.google.code.stk.t2gae.commons.exception;

public class AuthException extends StkUserException {

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	public AuthException() {
		super();
	}

	public AuthException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthException(String message) {
		super(message);
	}

	public AuthException(Throwable cause) {
		super(cause);
	}
}

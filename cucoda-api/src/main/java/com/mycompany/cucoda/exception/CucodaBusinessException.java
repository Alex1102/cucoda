package com.mycompany.cucoda.exception;

public class CucodaBusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	final String cause;

	public CucodaBusinessException(final String cause) {
		this.cause = cause;
	}

	public String getCauseMessage() {
		return this.cause;
	}

}

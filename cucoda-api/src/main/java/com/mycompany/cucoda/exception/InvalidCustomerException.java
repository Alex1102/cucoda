package com.mycompany.cucoda.exception;

public class InvalidCustomerException extends CucodaBusinessException {

	private static final long serialVersionUID = 1L;

	public InvalidCustomerException() {
		super("error: invalid customer");
	}

	public InvalidCustomerException(final String customerId) {
		super("Customer with customerNumber/ext_kdnr = " + customerId + " doesn't exist");
	}

}

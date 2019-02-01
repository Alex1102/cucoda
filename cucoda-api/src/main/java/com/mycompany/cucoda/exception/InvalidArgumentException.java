package com.mycompany.cucoda.exception;


public class InvalidArgumentException extends CucodaBusinessException {

    private static final long serialVersionUID = 1L;

    public InvalidArgumentException() {
        super("error: given argument is invalid");
    }

    public InvalidArgumentException(final String s) {
        super(String.format("Given argument %s is invalid", s));
    }

}

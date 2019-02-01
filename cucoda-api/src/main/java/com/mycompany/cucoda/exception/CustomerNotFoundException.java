package com.mycompany.cucoda.exception;


public class CustomerNotFoundException extends CucodaBusinessException {

    public CustomerNotFoundException(String message) {
        super(message);
    }
}

package com.mycompany.cucoda.exception;


public class CustomerAlreadyExistsException extends CucodaBusinessException {

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
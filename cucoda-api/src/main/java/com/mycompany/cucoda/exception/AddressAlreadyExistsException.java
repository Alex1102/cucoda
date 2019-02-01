package com.mycompany.cucoda.exception;


public class AddressAlreadyExistsException extends CucodaBusinessException {

    public AddressAlreadyExistsException(String message) {
        super(message);
    }
}
package com.mycompany.cucoda.exception;


public class PaymentAlreadyExistsException extends CucodaBusinessException {

    public PaymentAlreadyExistsException(String message) {
        super(message);
    }
}
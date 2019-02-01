package com.mycompany.cucoda.exception;


public class PaymentNotFoundException extends CucodaBusinessException {

    public PaymentNotFoundException(String message) {
        super(message);
    }
}
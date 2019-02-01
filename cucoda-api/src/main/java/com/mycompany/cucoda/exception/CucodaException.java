package com.mycompany.cucoda.exception;


public class CucodaException extends RuntimeException {

    public CucodaException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CucodaException(String message) {
        super(message);
    }
}
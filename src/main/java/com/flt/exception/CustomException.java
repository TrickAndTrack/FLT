package com.flt.exception;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
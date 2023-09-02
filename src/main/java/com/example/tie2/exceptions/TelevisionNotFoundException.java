package com.example.tie2.exceptions;

public class TelevisionNotFoundException extends RuntimeException {

    public TelevisionNotFoundException(String message) {
        super(message);
    }

    public TelevisionNotFoundException() {
        super();
    }
} // this here doesn't return anything //

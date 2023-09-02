package com.example.tie2.exceptions;

import java.io.Serial;

// Runtime Exception
public class TelevisionNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L; // can be thrown out //

    public TelevisionNotFoundException() {
        super();
    }

    public TelevisionNotFoundException(String message) {
        super(message);
    }
}



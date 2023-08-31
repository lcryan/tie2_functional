package com.example.tie2.exceptions;

import java.io.Serial;
// Runtime Exception
public class RecordNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L; // can be thrown out //

    public RecordNotFoundException() {
        super();
    }

    public RecordNotFoundException(String message) {
        super(message);
    }
}



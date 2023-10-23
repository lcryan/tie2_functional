package com.example.tie2.exceptions;

import java.io.Serial;

// this is a standard BAD REQUEST exception //
public class BadRequestException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public BadRequestException() {
        super();
    }

    public BadRequestException(String message) {
        super(message);
    }

}

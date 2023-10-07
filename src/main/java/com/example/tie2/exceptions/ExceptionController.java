package com.example.tie2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController extends RuntimeException {

    @ExceptionHandler
    public ResponseEntity<String> exception(TelevisionNotFoundException exception, UsernameNotFoundException usernameNotFoundException) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
        new ResponseEntity<>(usernameNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }
}

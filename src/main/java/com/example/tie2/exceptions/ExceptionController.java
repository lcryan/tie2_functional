package com.example.tie2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController extends RuntimeException {

}



//TODO: 1. write the according annotations for the ExceptionController. 2. Make an exceptionHandler within the ExceptionController class with annotations and response entity. //
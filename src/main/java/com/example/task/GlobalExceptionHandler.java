package com.example.task;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
    // Exception throwing
    @ExceptionHandler(EmailInvalidException.class)
    public ResponseEntity<String> EmailInvalidExceptionHandler(EmailInvalidException e){
        String message  = e.getMessage();
        return ResponseEntity.status(401).body(message) ;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> ExceptionHandler(Exception e){
        return ResponseEntity.status(501).body("an error occured") ;
    }
}

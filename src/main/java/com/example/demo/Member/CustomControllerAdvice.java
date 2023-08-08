package com.example.demo.Member;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public String runtimeExceptionHandler(RuntimeException e){
        return e.getMessage();
    }
}

package com.dhanu.eldercareai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String,String>> handleNotFound(NotFoundException exception){
       Map<String,String> body = new HashMap<>();
       body.put("error",exception.getMessage());
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);

    }
}

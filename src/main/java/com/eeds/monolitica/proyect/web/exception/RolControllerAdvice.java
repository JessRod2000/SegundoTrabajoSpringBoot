package com.eeds.monolitica.proyect.web.exception;

import com.eeds.monolitica.proyect.web.exception.RolNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RolControllerAdvice {
    @ExceptionHandler(RolNotFoundException.class)
    public ResponseEntity<String> handleRolNotFoundExcepion(RolNotFoundException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}

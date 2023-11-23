package com.eeds.monolitica.proyect.web.exception;

import com.eeds.monolitica.proyect.web.exception.RolNotFoundException;
import com.eeds.monolitica.proyect.web.exception.dto.ErrorMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RolControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RolNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorMessageDTO> handleRolNotFoundExcepion(RolNotFoundException e){
        ErrorMessageDTO error = new ErrorMessageDTO(HttpStatus.NOT_FOUND, e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}

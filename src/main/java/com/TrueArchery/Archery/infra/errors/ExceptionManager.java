package com.TrueArchery.Archery.infra.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity manageError404(EntityNotFoundException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity manageIllegalArgumentException(IllegalArgumentException e){
        return ResponseEntity.badRequest().body(e.getMessage());

    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public  ResponseEntity manageSQLIntegrty(SQLIntegrityConstraintViolationException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity manegeError400(MethodArgumentNotValidException e){

        var errors = e.getFieldErrors().stream().map(ErrorValidationDTO::new).toList();
        return ResponseEntity.badRequest().body(errors);

    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity manageHttpMessageNotReadable(HttpMessageNotReadableException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }


}

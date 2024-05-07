package com.TrueArchery.Archery.infra.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrainingDataNotFoundException extends RuntimeException {

    public TrainingDataNotFoundException(String message) {
        super(message);
    }
    
} 

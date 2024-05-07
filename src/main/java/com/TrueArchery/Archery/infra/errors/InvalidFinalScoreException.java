package com.TrueArchery.Archery.infra.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFinalScoreException extends RuntimeException {
    
    public InvalidFinalScoreException(String message) {
        super(message);
    }

}

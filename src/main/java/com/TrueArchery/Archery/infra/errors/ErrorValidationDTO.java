package com.TrueArchery.Archery.infra.errors;

import org.springframework.validation.FieldError;

public record ErrorValidationDTO(String field, String error) {

    public ErrorValidationDTO(FieldError error){
        this(error.getField(), error.getDefaultMessage());
    }

}

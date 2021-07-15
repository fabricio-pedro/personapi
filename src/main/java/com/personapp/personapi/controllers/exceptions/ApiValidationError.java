package com.personapp.personapi.controllers.exceptions;



import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApiValidationError extends ApiError implements Serializable {

    private List<FieldMessage> errors = new ArrayList<>();

    public ApiValidationError(LocalDateTime timestamp, Integer status, String message, String path) {
        super(timestamp, status, message, path);

    }
    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String message) {
        errors.add(new FieldMessage(fieldName, message));
    }
}

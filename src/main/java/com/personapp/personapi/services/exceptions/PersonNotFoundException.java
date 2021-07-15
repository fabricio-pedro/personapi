package com.personapp.personapi.services.exceptions;

public class PersonNotFoundException extends RuntimeException{

    private String message;


    public PersonNotFoundException(String message) {
        super(message);
        this.message = message;

    }

    public PersonNotFoundException(String message ,Throwable cause) {
        super(message, cause);
        this.message = message;
    }

}

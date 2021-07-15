package com.personapp.personapi.controllers.exceptions;

import com.personapp.personapi.services.exceptions.PersonNotFoundException;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandlers {

@ExceptionHandler(PersonNotFoundException.class)
public ResponseEntity<ApiError> PersonNotFoundException(WebRequest request, PersonNotFoundException ex){
   String personNoFoundUri= request.getDescription(false).replace("uri=","");
   ApiError error=new ApiError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(),ex.getMessage(),personNoFoundUri);
   return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
}

}

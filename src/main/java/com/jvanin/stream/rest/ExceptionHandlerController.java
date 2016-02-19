package com.jvanin.stream.rest;

import com.jvanin.stream.exceptions.ErrorMessage;
import com.jvanin.stream.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> rulesForCustomerNotFound(ResourceNotFoundException exception)
    {
        ErrorMessage errorResponse =  new ErrorMessage(exception.getClass().getSimpleName(), exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}

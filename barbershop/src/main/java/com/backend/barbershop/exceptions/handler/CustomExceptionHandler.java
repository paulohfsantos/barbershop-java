package com.backend.barbershop.exceptions.handler;

import com.backend.barbershop.exceptions.ExceptionResponse;
import com.backend.barbershop.exceptions.ResourceNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest req) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage() != null ? ex.getMessage() : "Unknown error",
            req.getDescription(false)
    );

    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(Exception ex, WebRequest req) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(
            new Date(),
            ex.getMessage() != null ? ex.getMessage() : "Unknown error",
            req.getDescription(false)
    );

    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }
}

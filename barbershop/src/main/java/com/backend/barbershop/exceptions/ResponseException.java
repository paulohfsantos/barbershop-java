package com.backend.barbershop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseException extends RuntimeException {
  private HttpStatus status;
  private String message;

  public ResponseException(String message, HttpStatus status) {
    super(message);
  }

  public ResponseEntity<ErrorResponse> handleException() {
    return ResponseEntity.status(this.status).body(new ErrorResponse(this.message, this.status.value()));
  }
}

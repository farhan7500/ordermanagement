package com.nomani.ordermanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ResourceErrorResponse> handleException(ResourceNotFoundException ex) {
        ResourceErrorResponse error = ResourceErrorResponse.builder()
                .statusCode(HttpStatus.NOT_FOUND.value())
                .timeStamp(System.currentTimeMillis())
                .statusMessage(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ResourceErrorResponse> handleException(BadRequestException ex) {
        ResourceErrorResponse error = ResourceErrorResponse.builder()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timeStamp(System.currentTimeMillis())
                .statusMessage(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ResourceErrorResponse> handleException(InternalServerErrorException ex) {
        ResourceErrorResponse error = ResourceErrorResponse.builder()
                .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .timeStamp(System.currentTimeMillis())
                .statusMessage(ex.getMessage())
                .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

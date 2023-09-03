package com.setlocal.psychologyTests.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class ResponseEntityExceptionHandler {

    @ExceptionHandler({TestNotRunException.class, TestNotFoundException.class})
    public ResponseEntity<?> testException(Exception e, WebRequest request) {
        return new ResponseEntity<>(
                new ErrorDetails(new Date(),
                        e.getMessage(),
                        request.getDescription(false)),
                HttpStatus.BAD_REQUEST);
    }

}
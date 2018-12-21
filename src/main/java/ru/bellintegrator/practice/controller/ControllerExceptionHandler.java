package ru.bellintegrator.practice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.validation.ConstraintViolationException;
import java.util.logging.Logger;

@RestControllerAdvice
public class ControllerExceptionHandler {

    //private static final Logger LOG = Logger.getLogger(ControllerExceptionHandler.class);



    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrorResponse constraintViolationException(ConstraintViolationException ex) {
        return new ApiErrorResponse(400, "Bad Request");
    }

    @ExceptionHandler(value = { NoHandlerFoundException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse noHandlerFoundException(Exception ex) {
        return new ApiErrorResponse(404, "Resource Not Found");
    }

    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiErrorResponse unknownException(Exception ex) {
        return new ApiErrorResponse(500, "Internal Server Error");
    }
}

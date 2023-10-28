package com.narainox.blog.exception;

import com.narainox.blog.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFound(ResourceNotFoundException exception)
    {
        String message=exception.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity(apiResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidUserDetailsException.class)
    public ResponseEntity<ApiResponse> validUserDetailsException(ValidUserDetailsException exception)
    {
        String message=exception.getMessage();
        ApiResponse apiResponse=new ApiResponse(message,false);
        return new ResponseEntity(apiResponse,HttpStatus.BAD_REQUEST);
    }


}

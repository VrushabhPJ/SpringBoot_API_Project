package com.productservice.productservice.controllers;

import com.productservice.productservice.dtos.ExceptionDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // exception handling
public class ProductControllerAdvice {
    @ExceptionHandler  //ResponseEntity set http response status
    //@ResponseStatus(HttpStatus.NOT_FOUND)
    //@ResponseBody()
    private ResponseEntity<ExceptionDto> handleProductNotFoundException(
            ProductNotFoundException productNotFoundException
    ){
        ExceptionDto exceptionDto= new ExceptionDto();
        exceptionDto.setMessage(productNotFoundException.getMessage());
        exceptionDto.setHttpStatus(HttpStatus.NOT_FOUND);

        //return exceptionDto;
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);

    }
}

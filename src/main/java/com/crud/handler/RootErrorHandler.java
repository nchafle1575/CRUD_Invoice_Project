package com.crud.handler;

import com.crud.entity.ErrorType;
import com.crud.exception.InvoiceNotFoundException;
import com.crud.exception.RootUserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

public class RootErrorHandler {

    @ExceptionHandler(RootUserNotFoundException.class)
    public ResponseEntity<ErrorType> handleNotFound(RootUserNotFoundException nfe){

        return new ResponseEntity<ErrorType>(
                new ErrorType(
                        new Date(System.currentTimeMillis()).toString(),
                        "404- NOT FOUND",
                        nfe.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}

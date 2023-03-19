package com.crud.exception;

public class RootUserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public RootUserNotFoundException() {
        super();
    }

    public RootUserNotFoundException(String message) {
        super(message);
    }
}

package com.sapient.oms.Exceptions;

public class StoreNotFoundException extends Exception {

    private String errMessage;

    public StoreNotFoundException(String message) {
        super();
        this.errMessage = message;
    }
    @Override
    public String getMessage() {
        return this.errMessage;
    }   
    
}
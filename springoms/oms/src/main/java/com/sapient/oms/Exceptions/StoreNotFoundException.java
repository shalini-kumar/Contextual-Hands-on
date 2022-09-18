package com.sapient.oms.Exceptions;

public class StoreNotFoundException extends RuntimeException {
    public StoreNotFoundException(String errMessage) {
         super(errMessage);
    }
}

package com.sapient.oms.Exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String errMessage) {
        super(errMessage);
    }
}

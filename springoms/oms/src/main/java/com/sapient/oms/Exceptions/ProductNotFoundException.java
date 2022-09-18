package com.sapient.oms.Exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String errMessage) {
        super(errMessage);
    }
}

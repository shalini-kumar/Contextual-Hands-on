package com.sapient.oms.Exceptions;

public class LocationNotFoundException extends RuntimeException {
    public LocationNotFoundException(String errMessage){
        super(errMessage);
    }
       
}

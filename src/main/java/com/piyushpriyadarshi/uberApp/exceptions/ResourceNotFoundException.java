package com.piyushpriyadarshi.uberApp.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){

    }
    public ResourceNotFoundException(String message){
        super(message);
    }

}

package com.scm.helpers;

public class ResourceNotFoundException extends Exception {

    public ResourceNotFoundException(String msg) {
        super(msg);
    }

    public ResourceNotFoundException() {
        super("Resource Not Found");
    }

}

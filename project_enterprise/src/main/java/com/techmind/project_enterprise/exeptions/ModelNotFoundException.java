package com.techmind.project_enterprise.exeptions;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class ModelNotFoundException extends Exception {

    public ModelNotFoundException(String message) {
        super(message);
    }
}

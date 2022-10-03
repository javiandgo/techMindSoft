package com.techmind.enterprise.Model;

public class UserResponse {
    private String message;
    private Object object;


    public UserResponse(String message, Object object) {
        this.message = message;
        this.object = object;
    }

    public UserResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}

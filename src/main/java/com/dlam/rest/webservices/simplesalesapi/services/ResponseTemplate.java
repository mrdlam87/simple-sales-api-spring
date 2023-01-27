package com.dlam.rest.webservices.simplesalesapi.services;

import org.springframework.http.HttpStatus;

// We wouldn't need this as ResponseEntity already provide these fields 1 way or the other

public class ResponseTemplate {
    private String message;
    private HttpStatus status;
    private Object data;

    public ResponseTemplate(String message, HttpStatus status, Object responseObj) {
        this.message = message;
        this.status = status;
        this.data = responseObj;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

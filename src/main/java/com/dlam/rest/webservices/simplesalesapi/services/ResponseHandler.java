package com.dlam.rest.webservices.simplesalesapi.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status,
                                                          Object responseObj) {
//        Map<String, Object> map = new HashMap<String, Object>();
//
//        map.put("message", message);
//        map.put("status", status.value());
//        map.put("data", responseObj);
        ResponseTemplate response = new ResponseTemplate(message, HttpStatus.OK, responseObj);

        return new ResponseEntity<Object>(response, status);
    }
}

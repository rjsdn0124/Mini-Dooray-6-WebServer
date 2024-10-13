package com.nhnacademy.gateway.exception;

import lombok.Getter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public class RestTemplateException extends RuntimeException{
    private HttpStatusCode statusCode;
    private String path;

    public RestTemplateException(HttpStatusCode statusCode, String path, String message){
        super(message);
        this.statusCode = statusCode;
        this.path = path;
    }
}

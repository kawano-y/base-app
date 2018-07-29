package com.example.base.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ErrorResponse {
    private String KeyName;
    private String KeyValue;
    private String Message;

    public ErrorResponse(String keyName,String  keyValue,String  message){
        this.KeyName = keyName;
        this.KeyValue = keyValue;
        this.Message = message;
    }
    
    public ResponseEntity<ErrorResponse> createResponse(HttpStatus status){
        return new ResponseEntity<ErrorResponse>(this, status);
    }
    
    public static ResponseEntity<ErrorResponse> createResponse(BadRequestException e){
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse(e.getKeyName(),e.getKeyValue(),e.getMessage())
                    ,HttpStatus.BAD_REQUEST);
    }
}
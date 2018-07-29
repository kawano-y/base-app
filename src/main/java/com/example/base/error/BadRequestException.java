package com.example.base.error;

import lombok.Data;

@Data
public class BadRequestException extends Exception {
    private String keyName;
    private String keyValue;
    private String error;

    public BadRequestException(String error, String keyName, String keyValue){
        this.keyName = keyName;
        this.keyValue = keyValue;
        this.error = error;
    }

}

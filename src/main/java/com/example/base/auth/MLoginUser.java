package com.example.base.auth;

import lombok.Data;

@Data
public class MLoginUser implements java.io.Serializable {

    private String loginUserId;
    private String password;

    public MLoginUser() {
    }
}
package com.example.base.auth;

import lombok.Data;

@Data
public class MLoginUser implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -7785917844554820852L;
	private String loginUserId;
    private String password;

    public MLoginUser() {
    }
}
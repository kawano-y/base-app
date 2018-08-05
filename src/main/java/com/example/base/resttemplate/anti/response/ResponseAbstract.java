package com.example.base.resttemplate.anti.response;

import lombok.Data;

@Data
public class ResponseAbstract {

	private Integer statusCode;
	
	private String message;
}

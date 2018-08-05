package com.example.base.resttemplate.anti;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.example.base.resttemplate.anti.response.ResponseAbstract;

public class ResponseErrorHandler {

	public void handle(ResponseAbstract res) {
		HttpStatus httpStatus = HttpStatus.valueOf(res.getStatusCode());
		switch (httpStatus.series()) {
		case CLIENT_ERROR:
			throw new HttpClientErrorException(httpStatus, res.getMessage());
		case SERVER_ERROR:
			throw new HttpServerErrorException(httpStatus, res.getMessage());
		default:
			break;
		}
	}
}

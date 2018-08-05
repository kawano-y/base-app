package com.example.base.resttemplate.anti.template.impl;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.base.resttemplate.anti.AbstractRest;
import com.example.base.resttemplate.anti.response.Json;
import com.example.base.resttemplate.anti.response.Person;
import com.example.base.resttemplate.anti.template.RestDefault;

@Component
public class RestDefaultImpl extends AbstractRest implements RestDefault {

	@Value("${api.url:http://localhost:8080/api/json}")
	URI uri;

//	public RestDefaultImpl(RestTemplate restTemplate) {
//		super(restTemplate);
//	}

	@Override
	public Json frend() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RequestEntity<?> req = new RequestEntity<>(null, headers, HttpMethod.GET, uri);
		ResponseEntity<String> res = restTemplate.exchange(req, String.class);
		ResponseEntity<Json> responseEntity = restTemplate.getForEntity(uri, Json.class);
		HttpStatus statusCode = responseEntity.getStatusCode();
		HttpHeaders header = responseEntity.getHeaders();
		Json json = responseEntity.getBody();
		return json;
	}

	@Override
	public Person listGet() {

		RequestEntity<Person> requestEntity = RequestEntity// (1)
				.post(uri)// (2)
				.body(new Person());// (3)

		ResponseEntity<Person> responseEntity = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<Person>() {
				}); // (2)

		Person person = responseEntity.getBody();// (3)
		return person;
	}

}

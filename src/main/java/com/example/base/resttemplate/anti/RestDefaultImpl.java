package com.example.base.resttemplate.anti;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.base.model.Json;

public class RestDefaultImpl extends AbstractRest implements RestDefault {

	@Value("${api.url:http://localhost:8080/api}")
	URI uri;

	public RestDefaultImpl(RestTemplate restTemplate) {
		super(restTemplate);
	}

	@Override
	public String frend() {
		Json jsonR = new Json();
		RequestEntity<Json> requestEntity = RequestEntity.post(uri).accept(MediaType.APPLICATION_JSON) // (1)
				.body(jsonR);
		ResponseEntity<Json> responseEntity = restTemplate.exchange(requestEntity, Json.class);
		HttpStatus statusCode = responseEntity.getStatusCode();
		HttpHeaders header = responseEntity.getHeaders();
		Json json = responseEntity.getBody();


		
		return null;
	}

	@Override
	public void listGet() {
		Json json = new Json();

		RequestEntity<Json> requestEntity = RequestEntity// (1)
				.post(uri)// (2)
				.body(json);// (3)

		ResponseEntity<List<Json>> responseEntity = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<List<Json>>() {
				}); // (2)

		List<Json> userList = responseEntity.getBody();// (3)

	}

}

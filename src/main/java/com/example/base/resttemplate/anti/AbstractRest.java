package com.example.base.resttemplate.anti;

import org.springframework.web.client.RestTemplate;

/**
 * 基底クラス
 * 
 * @author yoshinari
 *
 */
public class AbstractRest {

	protected RestTemplate restTemplate = new RestTemplate();

//	public AbstractRest(RestTemplate restTemplate) {
//		this.restTemplate = restTemplate;
//	}

}

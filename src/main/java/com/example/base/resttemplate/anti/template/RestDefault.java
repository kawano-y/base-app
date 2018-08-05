package com.example.base.resttemplate.anti.template;

import com.example.base.resttemplate.anti.response.Json;
import com.example.base.resttemplate.anti.response.Person;

public interface RestDefault {

	/**
	 * 
	 * @return
	 */
	public Json frend();
	
	/**
	 * リスト取得
	 */
	public Person listGet();
}

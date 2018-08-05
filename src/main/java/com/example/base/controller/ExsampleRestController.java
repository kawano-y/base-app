package com.example.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.base.resttemplate.anti.response.Json;
import com.example.base.resttemplate.anti.template.RestDefault;

@RestController
public class ExsampleRestController {
	
	@Autowired
	RestDefault restDefault;

	
	@RequestMapping(value = "/api/json", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	@ResponseBody
	public Json  json(){
		Json json = new Json();
		json.setStatusCode(400);
		json.setMessage("messagedayo");
		json.setName("name");
		return json;
	}
	@GetMapping("/main/json")
	@ResponseBody
	public Json mainJson(){
		return restDefault.frend();
	}

}

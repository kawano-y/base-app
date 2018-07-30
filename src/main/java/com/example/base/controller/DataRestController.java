package com.example.base.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataRestController {

	@GetMapping("/data")
	public String data(){
		return "data Rest";
	}
	@GetMapping("/erros")
	public String error(){
		if(true){
			throw new RuntimeException()
			;
			
		}
		return "data";
	}
}

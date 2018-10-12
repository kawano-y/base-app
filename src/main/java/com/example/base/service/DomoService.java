package com.example.base.service;


import static java.util.stream.Collectors.toSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.Data;

public class DomoService {

	public void name(){
		List<Gra> g = new ArrayList<Gra>();
		
		Set<String> set = g.stream().map(gra -> gra.getName()).collect(toSet());
	}
	
	@Data
	static class Gra{
		private String name;
		
		private String id;
	}
	
}

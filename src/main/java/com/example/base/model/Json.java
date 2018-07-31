package com.example.base.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Json extends ResponseAbstract {

	private String name;
	
	private String age;
}

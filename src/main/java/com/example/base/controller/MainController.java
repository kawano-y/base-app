package com.example.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.base.form.IndexForm;

@RequestMapping("/main")
@Controller
public class MainController {

	@GetMapping("/input_form")
	public ModelAndView index(IndexForm idexForm, ModelAndView mv){
		mv.setViewName("input-form");
		return mv;
	}

	
	
	
}

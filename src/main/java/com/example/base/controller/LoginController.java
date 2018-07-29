package com.example.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.base.form.IndexForm;

@Controller
public class LoginController {

	@GetMapping("/index")
	public String index(){
		return "index";
	}
	
	@GetMapping("/top")
	public ModelAndView next(IndexForm idexForm, ModelAndView mv){
		idexForm.setIndex("indesssxx");
		mv.addObject("indexForm", idexForm);
		mv.setViewName("top");
		return mv;
	}
}

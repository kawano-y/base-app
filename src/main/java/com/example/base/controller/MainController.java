package com.example.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.base.form.IndexForm;


@Controller("/")
public class MainController {

	@GetMapping
	public ModelAndView index(IndexForm idexForm, ModelAndView mv){
		idexForm.setIndex("indesss");
		mv.addObject("indexForm", idexForm);
		mv.setViewName("index");
		return mv;
	}
	@GetMapping("/next")
	public ModelAndView next(IndexForm idexForm, ModelAndView mv){
		idexForm.setIndex("indesssxx");
		mv.addObject("indexForm", idexForm);
		mv.setViewName("next");
		return mv;
	}
	
	
	
}

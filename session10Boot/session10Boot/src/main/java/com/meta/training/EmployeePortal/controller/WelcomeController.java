package com.meta.training.EmployeePortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class WelcomeController {

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("hii");
		model.addAttribute("greeting", "Hello World from Spring 4 MVC");
		return "home";
	}

	

}
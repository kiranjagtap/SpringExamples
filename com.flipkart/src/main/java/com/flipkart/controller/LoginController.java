package com.flipkart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.flipkart.service.LoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	LoginService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		System.out.println("----------show login page");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model) {

		model.addAttribute("name", name);
		model.addAttribute("password", password);

		System.out.println("--------------Handle request");
		if (!service.validateUser(name, password)) {
			model.addAttribute("errorMessage", "Invalid Login");
			return "login";
		} else {
			model.put("name", name);
			return "welcome";
		}

	}

}

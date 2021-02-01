package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.service.impl.LoginService;
import com.example.demo.service.interfaces.ILoginService;

@Controller
@SessionAttributes("name")
public class LoginController {

	@Autowired
	ILoginService service;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(@RequestParam String name, @RequestParam String password,  ModelMap modelMap)
	{
		boolean isValidUser = service.validateUser(name, password);
		if(!isValidUser)
		{
			modelMap.put("errorMessage", "invalid id pass");
			return "login";
		}
		
		modelMap.put("name", name);
		modelMap.put("password", password);
		return "welcome";
	}

	@RequestMapping("/")
	@ResponseBody
	public String defaultLandingPage()
	{
		return "this is the default landing page";
	}
}

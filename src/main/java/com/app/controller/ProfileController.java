package com.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProfileController {
	
	@RequestMapping(value= "/profile", method={RequestMethod.GET, RequestMethod.POST })
	public ModelAndView displayProfileGet(HttpServletRequest request) {
		return new ModelAndView("/jsp/user/profile");
	}
	
}

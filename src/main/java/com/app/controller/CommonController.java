package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.constants.ApplicationConstants;
import com.app.util.CommonHelper;

@Controller
public class CommonController {
	@RequestMapping(value="/", method={RequestMethod.POST, RequestMethod.GET}) 
	public String context(HttpServletRequest request) {
		if(CommonHelper.isLoggedIn(request)) {
			return "user/home";
		}
		return "index";
	}
	
	@RequestMapping (value="/logout", method= { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute(ApplicationConstants.LOGGED_IN_KEY);
			session.removeAttribute(ApplicationConstants.USERNAME_KEY);
			session.invalidate();
		}
		return "redirect:/";
	}
	
}

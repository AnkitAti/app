package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.constants.ApplicationConstants;
import com.app.constants.PropertiesConstants;
import com.app.service.LoginService;
import com.app.util.AppConfig;
import com.app.util.CommonHelper;

@Controller
public class LoginController {
	
	@Autowired private LoginService loginService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam String username, @RequestParam String password, @RequestParam(required=false) String redirect, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String message;
		if(CommonHelper.isLoggedIn(request)) {
			return "user/home";
		}
		boolean verifyCredentials = loginService.validateLogin(username, password);
		if(!verifyCredentials) {
			if (loginService.usernameExist()) {
				request.setAttribute(ApplicationConstants.LOGIN_USERNAME, username);
				message = AppConfig.getProperty(PropertiesConstants.LOGIN_ERROR_PWD);
			} else {
				message = AppConfig.getProperty(PropertiesConstants.LOGIN_ERROR_USERNAME);
			}
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY_LOGIN, message);
			return "index";
		}
		username = loginService.getUserName();
		session.setAttribute(ApplicationConstants.LOGGED_IN_KEY, ApplicationConstants.LOGGED_IN_VALUE);
		session.setAttribute(ApplicationConstants.USERNAME_KEY,username);
		if(redirect != null) {
			return "redirect:/"+redirect;
		}
		return "user/home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String loginGet(HttpServletRequest request) {
		if(CommonHelper.isLoggedIn(request)) {
			return "user/home";
		}
		return "index";
	}
}

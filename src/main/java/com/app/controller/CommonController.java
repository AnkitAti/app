package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.constants.ApplicationConstants;
import com.app.constants.PropertiesConstants;
import com.app.factory.beans.User;
import com.app.service.LoginService;
import com.app.service.SignupService;
import com.app.util.AppConfig;

@Controller
public class CommonController {
	
	@Autowired private LoginService loginService;
	@Autowired private SignupService signupService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		String message = null;
		
		if(session != null) {
			if(session.getAttribute(ApplicationConstants.LOGGED_IN_KEY)!=null 
					&& session.getAttribute(ApplicationConstants.LOGGED_IN_KEY).equals(ApplicationConstants.LOGGED_IN_VALUE)) {
				return new ModelAndView("user/home");
			}
		}
		
		boolean verifyCredentials = loginService.validateLogin(username, password);
		if(!verifyCredentials) {
			if (loginService.usernameExist()) {
				message = AppConfig.getProperty(PropertiesConstants.LOGIN_ERROR_PWD);
			} else {
				message = AppConfig.getProperty(PropertiesConstants.LOGIN_ERROR_USERNAME);
			}
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY_LOGIN, message);
			return new ModelAndView("redirect:index.jsp");
		}
		session.setAttribute(ApplicationConstants.LOGGED_IN_KEY, ApplicationConstants.LOGGED_IN_VALUE);
		session.setAttribute(ApplicationConstants.USERNAME_KEY,username);
		return new ModelAndView("user/home");
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String dummyLogin(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			if(session.getAttribute(ApplicationConstants.LOGGED_IN_KEY)!=null 
					&& session.getAttribute(ApplicationConstants.LOGGED_IN_KEY).equals(ApplicationConstants.LOGGED_IN_VALUE)) {
				return "user/home";
			}
		}
		return "redirect:index.jsp";
	}
	
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public ModelAndView signup(@RequestParam String username, @RequestParam String password, @RequestParam String email, HttpServletRequest request) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		if(signupService.usernameExists(user.getUsername())) {
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY_SIGNUP, "Username already exists. Please try signing up with some other username.");
			return new ModelAndView("redirect:index.jsp");
		
		} else if(signupService.emailExists(user.getEmail())) {
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY_SIGNUP,"Email ID already exists. Please try signing up with some other Email ID.");
			return new ModelAndView("redirect:index.jsp");
		}
		
		boolean signupSuccessful = signupService.signup(user);
		
		if(!signupSuccessful) {
			return new ModelAndView("redirect:index.jsp");
		}
		return new ModelAndView("user/home.jsp");
	}
	
	@RequestMapping (value="/logout", method= { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session != null) {
			session.removeAttribute(ApplicationConstants.LOGGED_IN_KEY);
		}
		return "index";
	}
}

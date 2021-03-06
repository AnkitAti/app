package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.constants.ApplicationConstants;
import com.app.factory.beans.User;
import com.app.service.SignupService;

@Controller
public class SignupController {

	@Autowired private SignupService signupService;
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public String signup(@RequestParam String username, @RequestParam String password, @RequestParam String email, HttpServletRequest request) {
		if(username == null || username.trim().equals("")) {
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY_SIGNUP, "Invalid username");
			return "index";
		}
		if(email == null || email.trim().equals("")) {
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY_SIGNUP, "Invalid email");
			return "index";
		}
		if(password == null || password.trim().equals("") || password.trim().length() < 5) {
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY_SIGNUP, "Invalid password");
			return "index";
		}
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setActive("Y");
		if(signupService.usernameExists(user.getUsername())) {
			request.setAttribute(ApplicationConstants.SIGNUP_EMAIL, email);
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY_SIGNUP, "Username already exists. Please try signing up with some other username.");
			return "index";
		} else if(signupService.emailExists(user.getEmail())) {
			request.setAttribute(ApplicationConstants.SIGNUP_USERNAME, username);
			request.setAttribute(ApplicationConstants.ERROR_MESSAGE_KEY_SIGNUP,"Email ID already exists. Please try signing up with some other Email ID.");
			return "index";
		}
		boolean signupSuccessful = signupService.signup(user);
		if(!signupSuccessful) {
			return "index";
		}
		HttpSession session = request.getSession();
		session.setAttribute(ApplicationConstants.LOGGED_IN_KEY, ApplicationConstants.LOGGED_IN_VALUE);
		session.setAttribute(ApplicationConstants.USERNAME_KEY,username);
		return "redirect:/";
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.GET)
	public String signupGet(HttpServletRequest request) {
		return "index";
	}
	
}

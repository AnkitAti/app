package com.app.actions;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.constants.ApplicationConstants;
import com.app.factory.beans.User;
import com.app.service.SignupService;
import com.opensymphony.xwork2.ActionContext;

public class SignupAction {

	private User user;
	
	@Autowired
	private SignupService signupService;
	
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return this.user;
	}
	
	@SuppressWarnings("unchecked")
	public String signup() {
		
		if(signupService.usernameExists(user.getUsername())) {
			
			Map<String,Object> request = (Map<String,Object>)ActionContext.getContext().get("request");
			request.put(ApplicationConstants.ERROR_MESSAGE_KEY, "Username already exists. Please try signing up with some other username.");
			
			return ApplicationConstants.FAILURE_FORWARD;
		
		} else if(signupService.emailExists(user.getEmail())) {
			
			Map<String,Object> request = (Map<String,Object>)ActionContext.getContext().get("request");
			request.put(ApplicationConstants.ERROR_MESSAGE_KEY,"Email ID already exists. Please try signing up with some other Email ID.");
			
			return ApplicationConstants.FAILURE_FORWARD;
		
		}
		
		boolean signupSuccessful = signupService.signup(user);
		
		if(!signupSuccessful) {
			return ApplicationConstants.FAILURE_FORWARD;
		}
		return ApplicationConstants.SUCCESS_FORWARD;
	}
}

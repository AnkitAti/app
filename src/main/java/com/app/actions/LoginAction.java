package com.app.actions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.constants.ApplicationConstants;
import com.app.service.LoginService;
import com.opensymphony.xwork2.ActionContext;

/**
 * Controller for Logging in
 * @author Ankit
 * @version 1.0
 */
public class LoginAction {
	private static final Logger logger = LogManager.getLogger(LoginAction.class);
	
	@Autowired
	private LoginService loginService;
	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * If login is successful, the user will be directed to the home page, 
	 * else he/she will be redirected to the same page with the error message.
	 * @return String Login Successful or unsuccessful
	 */
	
	@SuppressWarnings("unchecked")
	public String login() {
		logger.trace("Entering execute method");
		String message = null;
		Map<String,Object> session = null;
		Map<String,Object> request = null;
		boolean verifyCredentials = false;
		
		try {
			
			session = ActionContext.getContext().getSession();
			if(session.get(ApplicationConstants.LOGGED_IN_KEY)!=null && session.get(ApplicationConstants.LOGGED_IN_KEY).equals("true")) {
				return ApplicationConstants.SUCCESS_FORWARD;
			}
		
			verifyCredentials = loginService.validateLogin(username, password);
		
			if(!verifyCredentials) {
				request = (Map<String,Object>)ActionContext.getContext().get("request");
				if(loginService.usernameExist()) {
					message = "Wrong Password. Please enter the valid password.";
				} else {
					message = "Invalid username. Please enter a valid username.";
				}
				request.put(ApplicationConstants.ERROR_MESSAGE_KEY, message);
				return ApplicationConstants.FAILURE_FORWARD;
			}		
		
			session.put(ApplicationConstants.LOGGED_IN_KEY, ApplicationConstants.LOGGED_IN_VALUE);
			session.put(ApplicationConstants.USERNAME_KEY,username);
		
			return ApplicationConstants.SUCCESS_FORWARD;
		} catch(HibernateException ex) {
			request = (Map<String,Object>)ActionContext.getContext().get("request");
			request.put(ApplicationConstants.ERROR_MESSAGE_KEY,"Shame on us!! Something went wrong. Please try after some time.");
			return ApplicationConstants.EXCEPTION_FORWARD;
		} catch(Exception ex) {
			request = (Map<String,Object>)ActionContext.getContext().get("request");
			request.put(ApplicationConstants.ERROR_MESSAGE_KEY,"Shame on us!! Something went wrong. Please try after some time.");
			return ApplicationConstants.EXCEPTION_FORWARD;
		}
	}
}
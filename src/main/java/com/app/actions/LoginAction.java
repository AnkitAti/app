package com.app.actions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.constants.ApplicationConstants;
import com.app.service.LoginService;
import com.opensymphony.xwork2.ActionContext;

/**
 * Controller for Logging in
 * @author Ankit
 * @version 1.0
 */

public class LoginAction {
	Logger logger = LogManager.getLogger(LoginAction.class);
	
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
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		if(session.get(ApplicationConstants.LOGGED_IN_KEY)!=null && session.get(ApplicationConstants.LOGGED_IN_KEY).equals("true")) {
			return ApplicationConstants.SUCCESS_FORWARD;
		}
		
		LoginService service = new LoginService();
		boolean verifyCredentials = service.validateLogin(username, password);
		
		if(!verifyCredentials) {
			Map<String,Object> request = (Map<String,Object>)ActionContext.getContext().get("request");
			request.put("error", "Username or Password doesn't match. Please try again.");
			return ApplicationConstants.FAILURE_FORWARD;
		}		
		
		session.put(ApplicationConstants.LOGGED_IN_KEY, "true");
		
		return ApplicationConstants.SUCCESS_FORWARD;
	}
}

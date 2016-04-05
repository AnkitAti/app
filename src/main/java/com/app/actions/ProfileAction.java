package com.app.actions;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.constants.ApplicationConstants;
import com.app.error.ApplicationException;
import com.app.factory.beans.UserDescription;
import com.app.service.ProfileService;
import com.opensymphony.xwork2.ActionContext;

/**
 * This class serves as the action class for displaying the profile information of an User.
 * @author Ankit
 * @version 1.0
 */
public class ProfileAction {

	private static final Logger logger = LogManager.getLogger(ProfileAction.class);
	
	private UserDescription profile;
	
	public void setProfile(UserDescription profile) {
		this.profile = profile;
	}
	
	public UserDescription getProfile() {
		return this.profile;
	}
	
	@SuppressWarnings("unchecked")
	public String viewProfile() {
		logger.trace("Entering ProfileAction.viewProfile method");
		
		Map<String,Object> session = ActionContext.getContext().getSession();
		
		if(session.get(ApplicationConstants.LOGGED_IN_KEY)==null || (!session.get(ApplicationConstants.LOGGED_IN_KEY).equals(ApplicationConstants.LOGGED_IN_VALUE))) {
			
			Map<String,Object> request = (Map<String,Object>)ActionContext.getContext().get("request");
			request.put(ApplicationConstants.ERROR_MESSAGE_KEY, "You need to login first");
			logger.info("User not logged in. Redirecting to login page.");
			return ApplicationConstants.LOGIN_FORWARD;
		}
		try {
			ProfileService service = new ProfileService((String)session.get(ApplicationConstants.USERNAME_KEY));
			this.profile = service.fetchProfileDetails();
		} catch(ApplicationException ex) {
			return ApplicationConstants.EXCEPTION_FORWARD;
		}
		
		return ApplicationConstants.SUCCESS_FORWARD;
	}
}

package com.app.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.app.constants.ApplicationConstants;

public class CommonHelper {
	
	public static boolean isLoggedIn(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if(session == null) 
			return false;
		if(session.getAttribute(ApplicationConstants.LOGGED_IN_KEY) != null) {
			String loggedInKey = (String) session.getAttribute(ApplicationConstants.LOGGED_IN_KEY);
			if(loggedInKey.equals(ApplicationConstants.LOGGED_IN_VALUE))
				return true;
		}
		return false;
	}
	
}

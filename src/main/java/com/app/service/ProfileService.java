package com.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.error.ApplicationException;
import com.app.factory.beans.UserDescription;
import com.app.factory.interfaces.ProfileInterface;

/**
 * This class provides the services related to the Profile of an User. Editing the profile, viewing the profile and others are managed by this class.
 * @author Ankit
 * @version 1.0
 */
@Service
public class ProfileService {
	
	public static final Logger logger = LogManager.getLogger(ProfileService.class);
	
	private String username;
	@Autowired
	private ProfileInterface db;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * This method provides the implementation of getting the user details of the user with the specific username.
	 * @return UserDescription of the user with the giver username
	 * @throws ApplicationException
	 */
	@Transactional
	public UserDescription fetchProfileDetails() throws ApplicationException {
		logger.trace("Entering "+ProfileService.class + ".fetchProfileDetails method");
		db.setUsername(username);
		UserDescription user = db.getUserDetails();
		//System.out.println(user);
		if(user!=null)
			user.setId(-1); //This user will be set in session or request. To remove the unnecessary information from the object.
		return user;
	}
}

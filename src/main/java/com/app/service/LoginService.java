package com.app.service;

import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.factory.LoginDAO;
import com.app.factory.beans.UserDescription;
import com.app.security.HashService;

/**
 * This class provides the login service for various parts of the application.
 * @author Ankit
 * @version 1.0
 */
@Service
public class LoginService {
	
	private static final Logger logger = LogManager.getLogger(LoginService.class);
	
	@Autowired
	private LoginDAO loginDB;
	/**
	 * This method validates the login for the entered username and password
	 * @param username
	 * @param password
	 * @return Returns whether login is successful or not
	 */
	@Transactional
	public boolean validateLogin(String username, String password) {
		logger.trace("Entring LoginService.validateLogin");
		try {
			loginDB.getDetails(username);
			String salt = loginDB.getSalt();
			if(salt==null) {
				logger.info("Username " + username + " does not exists.");
				return false;
			}
			
			String hashPassword = HashService.sha256Hash(password + salt);
			boolean success = loginDB.login(hashPassword);
			return success;
		} catch(HibernateException | NullPointerException | NoSuchAlgorithmException ex) {
			logger.debug("Exception caught in LoginService.validateLogin.\n" + ex);
		}
		return false;
	}
	
	
	public UserDescription getUserDetails(String username) {
		return null;
	}
	
}

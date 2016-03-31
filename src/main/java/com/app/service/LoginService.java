package com.app.service;

import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;

import com.app.factory.LoginDAO;
import com.app.factory.beans.UserDescription;
import com.app.security.HashService;

/**
 * This class provides the login service for various parts of the application.
 * @author Ankit
 * @version 1.0
 */
public class LoginService {
	
	private static final Logger logger = LogManager.getLogger(LoginService.class);
	/**
	 * This method validates the login for the entered username and password
	 * @param username
	 * @param password
	 * @return Returns whether login is successful or not
	 */
	public boolean validateLogin(String username, String password) {
		logger.trace("Entring LoginService.validateLogin");
		try {
			LoginDAO dbUserLogin = new LoginDAO(username);
			
			String salt = dbUserLogin.getSalt();
			if(salt==null) {
				logger.info("Username " + username + " does not exists.");
				return false;
			}
			
			String hashPassword = HashService.sha256Hash(password + salt);
			/*System.out.println(hashPassword.length());
			System.out.println(salt.length());*/
			
			return dbUserLogin.login(hashPassword);
		} catch(HibernateException | NullPointerException | NoSuchAlgorithmException ex) {
			logger.debug("Exception caught in LoginService.validateLogin.\n" + ex);
		}
		return false;
	}
	
	public UserDescription getUserDetails(String username) {
		return null;
	}
	
}

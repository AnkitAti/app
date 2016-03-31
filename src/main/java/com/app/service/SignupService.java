package com.app.service;

import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.app.factory.SignupDAO;
import com.app.factory.beans.User;
import com.app.security.HashService;

public class SignupService {

	public static final Logger logger = LogManager.getLogger(SignupService.class);
	
	public boolean signup(User user) {
		logger.trace("Entering SignupService.signup");
		try {
			String salt = HashService.getSalt();
			String password = user.getPassword();
			password = HashService.sha256Hash(password+salt);
			user.setPassword(password);
			user.setSalt(salt);
			logger.trace("Exiting SignupService.signup");
			return SignupDAO.signupQuery(user);
		} catch (NoSuchAlgorithmException e) {
			logger.debug("Exception Caught : " + e);
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean usernameExists(String username) {
		return SignupDAO.usernameExist(username);
	}
	
	public static boolean emailExists(String email) {
		return SignupDAO.emailExists(email);
	}
}

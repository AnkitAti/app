package com.app.service.impl;

import java.security.NoSuchAlgorithmException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.factory.SignupDao;
import com.app.factory.beans.User;
import com.app.factory.impl.CommonServicesDao;
import com.app.security.HashService;

@Service
public class SignupServiceImpl {

	public static final Logger logger = LogManager.getLogger(SignupServiceImpl.class);
	
	@Autowired
	private CommonServicesDao commonServices;
	
	@Autowired
	private SignupDao signupDB;
	
	@Transactional
	public boolean signup(User user) {
		logger.trace("Entering SignupService.signup");
		try {
			String salt = HashService.getSalt();
			String password = user.getPassword();
			password = HashService.sha256Hash(password+salt);
			user.setPassword(password);
			user.setSalt(salt);
			boolean signupSuccessful = signupDB.signupQuery(user);
			logger.trace("Exiting SignupService.signup");
			return signupSuccessful;
		} catch (NoSuchAlgorithmException e) {
			logger.debug("Exception Caught : " + e);
			return false;
		}
	}
	
	@Transactional
	public boolean usernameExists(String username) {
		return commonServices.usernameExist(username);
	}
	
	@Transactional
	public boolean emailExists(String email) {
		return commonServices.emailExists(email);
	}
}

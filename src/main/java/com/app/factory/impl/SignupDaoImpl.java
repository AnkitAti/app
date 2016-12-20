package com.app.factory.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.factory.SignupDao;
import com.app.factory.beans.User;

@Repository
public class SignupDaoImpl implements SignupDao {

	public static final Logger logger = LogManager.getLogger(SignupDaoImpl.class);
	
	@Autowired private SessionFactory sessionFactory;
	
	public boolean signupQuery(User user) {
		logger.trace("Entering SignupDaoImpl.signupQuery");
		Session session = sessionFactory.getCurrentSession();
		try { 
			session.save(user); 
		} 
		catch (Exception ex) {
			logger.debug("Exception Caught in SignupDaoImpl.signupQuery while saving the object in db." + ex);
			return false;
		} 
		logger.trace("Exiting SignupDaoImpl.signupQuery");
		return true;  //Return true if everything goes right
	}
}

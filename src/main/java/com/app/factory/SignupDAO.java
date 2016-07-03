package com.app.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.factory.beans.User;
import com.app.factory.interfaces.SignupInterface;

@Service
<<<<<<< HEAD
@Repository

=======
public class SignupDAO implements SignupInterface{
>>>>>>> 1d352d4... Changes made for Integrating spring with struts

	public static final Logger logger = LogManager.getLogger(SignupDAO.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean signupQuery(User user) {
		logger.trace("Entering SignupDAO.signupQuery");
		
		Session session = sessionFactory.getCurrentSession();

		try { 
			session.save(user); 
		} 
		
		catch (Exception ex) {
			logger.debug("Exception Caught in SignupDAO.signupQuery while saving the object in db." + ex);
			return false;
		} 
		
		logger.trace("Exiting SignupDAO.signupQuery");
		return true;  //Return true if everything goes right
	}
}

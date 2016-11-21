package com.app.factory.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.error.ApplicationException;
import com.app.factory.ProfileInterface;
import com.app.factory.beans.UserDescription;

/**
 * This class provides the database related functionalities for profile viewing and editing.
 * @author Ankit
 * @version 1.0
 */
@Repository
@Service
public class ProfileDAO implements ProfileInterface {

	private static final Logger logger = LogManager.getLogger(ProfileDAO.class);
	private String username;
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * This method returns the user description of the user with a particular username.
	 * In case the username does not exists, it returns null indicating that something is not right.
	 * @return user description
	 * @throws ApplicationException
	 */
	@SuppressWarnings("unchecked")
	public UserDescription getUserDetails() throws ApplicationException {
		Session session = sessionFactory.getCurrentSession();
		if(session == null) {
			throw new ApplicationException("Connection not initiated.");
		}
		String hql =  "Select profile FROM UserDescription as profile join profile.user as user "
				+ "Where user.username = :username";
		
		try {
			List<UserDescription> list = session.createQuery(hql).setParameter("username", this.username).list();
		
			if(list.size()>1) {
				throw new ApplicationException();
			} else if(list.size()<=0) {
				throw new ApplicationException("No users found with the provided details");
			}

			return list.get(0);
		} catch(HibernateException ex) {
			System.out.println(ex);
			logger.debug("Exception caught in Constructor of ProfileDAO. " + ex);
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			logger.debug("Exception Caught in constructor of ProfileDAO. " + ex);
			return null;
		} finally {
			
		}
	}
	
}

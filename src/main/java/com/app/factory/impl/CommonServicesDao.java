package com.app.factory.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This class provides the common services related to database queries and results.
 * @author Ankit
 * @version 1.0
 */
@Repository
public class CommonServicesDao {

	private static final Logger logger = LogManager.getLogger(CommonServicesDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Checks whether the username exists in the database or not.
	 * @param username
	 * @return false if the username exists, true otherwise
	 */
	public boolean usernameExist(String username){
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User as user WHERE user.username = :username";
		try {
			Query query = session.createQuery(hql);
			List<?> list = query.setParameter("username", username).list();
			if(list!=null && list.size()==0)
				return false;
			return true;
		} catch(HibernateException ex) {
			logger.debug("Exception Caught in SignupDAO.usernameExists.\n" + ex);
			return true;
		} catch(Exception ex) {
			logger.debug("Exception Caught in SignupDAO.usernameExists.\n" + ex);
			return true;
		}
	}
	
	
	/**
	 * This method checks if the email provided exists in the USERS table or not.
	 * @param email
	 * @return false if the email does not exist, true otherwise.
	 */
	public boolean emailExists(String email) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User as user WHERE user.email = :email";
		try {
			Query query = session.createQuery(hql);
			List<?> list = query.setParameter("email", email).list();
			if(list!=null && list.size()==0) 
				return false;
			return true;
		} catch(HibernateException ex) {
			logger.debug("Exception caught in SignupDAO.emailExists.\n" + ex);
			return true;
		} catch(Exception ex) {
			logger.debug("Exception caught in SignupDAO.emailExists.\n" + ex);
			return true;
		}
	}
}

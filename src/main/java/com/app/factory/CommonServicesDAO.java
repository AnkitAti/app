package com.app.factory;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.factory.beans.User;

/**
 * This class provides the common services related to database queries and results.
 * @author Ankit
 * @version 1.0
 */
public class CommonServicesDAO {

	private static final Logger logger = LogManager.getLogger(CommonServicesDAO.class);
	
	/**
	 * Checks whether the username exists in the database or not.
	 * @param username
	 * @return false if the username exists, true otherwise
	 */
	@SuppressWarnings("unchecked")
	public static boolean usernameExist(String username){
		
		Session session = Connection.getInstance().openSession();
		String hql = "FROM User as user WHERE user.username = :username";
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			List<User> list = query.setParameter("username", username).list();
			
			if(list!=null && list.size()==0)
				return false;
			
			return true;
		} catch(HibernateException ex) {
			
			if(transaction!=null) 
				transaction.rollback();
			
			logger.debug("Exception Caught in SignupDAO.usernameExists.\n" + ex);
			return true;
		} catch(Exception ex) {
			if(transaction!=null) 
				transaction.rollback();
			
			logger.debug("Exception Caught in SignupDAO.usernameExists.\n" + ex);
			return true;
		}
		
		finally {
			if(session!=null)
				session.close();
		}
	}
	
	
	/**
	 * This method checks if the email provided exists in the USERS table or not.
	 * @param email
	 * @return false if the email does not exist, true otherwise.
	 */
	@SuppressWarnings("unchecked")
	public static boolean emailExists(String email) {
		
		Session session = Connection.getInstance().openSession();
		String hql = "FROM User as user WHERE user.email = :email";
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			Query query = session.createQuery(hql);
			List<User> list = query.setParameter("email", email).list();
			
			transaction.commit();
			if(list!=null && list.size()==0) 
				return false;
			return true;
		} catch(HibernateException ex) {
			if(transaction!=null) {
				transaction.rollback();
			}
			logger.debug("Exception caught in SignupDAO.emailExists.\n" + ex);
			return true;
		} catch(Exception ex) {
			if(transaction!=null) {
				transaction.rollback();
			}
			logger.debug("Exception caught in SignupDAO.emailExists.\n" + ex);
			return true;
		}
		finally {
			if(session!=null)
				session.close();
		}
	}
}

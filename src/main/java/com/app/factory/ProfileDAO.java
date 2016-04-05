package com.app.factory;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.error.ApplicationError;
import com.app.error.ApplicationException;
import com.app.factory.beans.UserDescription;

/**
 * This class provides the database related functionalities for profile viewing and editing.
 * @author Ankit
 * @version 1.0
 */

public class ProfileDAO {

	private static final Logger logger = LogManager.getLogger(ProfileDAO.class);
	private String username;
	private ApplicationError[] error = ApplicationError.values();
	
	public ProfileDAO(String username) {
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
		Session session = Connection.getInstance().openSession();
		if(session == null) {
			throw new ApplicationException("Connection not initiated.");
		}
		Transaction transaction = null;
		String hql =  "Select profile FROM UserDescription as profile join profile.user as user "
				+ "Where user.username = :username";
		
		try {
			transaction = session.beginTransaction();
			List<UserDescription> list = session.createQuery(hql).setParameter("username", this.username).list();
			transaction.commit();
			
			//System.out.println(list.size());
			if(list.size()>1) {
				throw new ApplicationException();
			} else if(list.size()<=0) {
				throw new ApplicationException("No users found with the provided details");
			}
			System.out.println(list.get(0) instanceof UserDescription);
			return (UserDescription)list.get(0);
		} catch(HibernateException ex) {
			System.out.println(ex);
			logger.debug("Exception caught in Constructor of ProfileDAO. " + ex);
			if(transaction!=null) {
				transaction.rollback();
			}
			return null;
		} catch(Exception ex) {
			ex.printStackTrace();
			logger.debug("Exception Caught in constructor of ProfileDAO. " + ex);
			if(transaction!=null) {
				transaction.rollback();
			}
			return null;
		} finally {
			session.close();
		}
	}
	
}

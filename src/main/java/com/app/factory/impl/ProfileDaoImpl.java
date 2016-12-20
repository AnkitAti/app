package com.app.factory.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.error.ApplicationException;
import com.app.factory.ProfileDao;
import com.app.factory.beans.UserDescription;

/**
 * This class provides the database related functionalities for profile viewing and editing.
 * @author Ankit
 * @version 1.0
 */
@Repository
public class ProfileDaoImpl implements ProfileDao {

	private static final Logger logger = LogManager.getLogger(ProfileDaoImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * This method returns the user description of the user with a particular username.
	 * In case the username does not exists, it returns null
	 * @return user description
	 * @throws ApplicationException
	 */
	public UserDescription getProfileDetails(String username) throws ApplicationException {
		Session session = sessionFactory.getCurrentSession();
		if(session == null) {
			throw new ApplicationException("Connection not initiated");
		}
		String hql =  "Select profile FROM UserDescription as profile join profile.user as user "
				+ "Where user.username = :username OR user.email = :email";
		try {
			List<?> list = session.createQuery(hql).setParameter("username", username).setParameter("email", username).list();
			if(list.size()>1) 
				throw new ApplicationException();
			return list.size() == 1? (UserDescription)list.get(0): null;
		} catch(HibernateException ex) {
			logger.debug("Exception caught in ProfileDAO >> " + ex);
			return null;
		} 
	}
}

package com.app.factory;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.app.factory.beans.User;

public class SignupDAO {

	public static final Logger logger = LogManager.getLogger(SignupDAO.class);
	
	public static boolean signupQuery(User user) {
		logger.trace("Entering SignupDAO.signupQuery");
		Session session = Connection.getInstance().openSession();
		session.save(user);
		session.close();
		logger.trace("Exiting SignupDAO.signupQuery");
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean usernameExist(String username){
		Session session = Connection.getInstance().openSession();
		String hql = "FROM User as user WHERE user.username = :username";
		try {
			Query query = session.createQuery(hql);
			List<User> list = query.setParameter("username", username).list();
			if(list!=null && list.size()==0)
				return false;
			return true;
		} catch(HibernateException ex) {
			logger.debug("Exception Caught in SignupDAO.usernameExists.\n" + ex);
			return true;
		} finally {
			if(session!=null)
				session.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static boolean emailExists(String email) {
		Session session = Connection.getInstance().openSession();
		String hql = "FROM User as user WHERE user.email = :email";
		try {
			Query query = session.createQuery(hql);
			List<User> list = query.setParameter("email", email).list();
			
			if(list!=null && list.size()==0) 
				return false;
			return true;
		} catch(HibernateException ex) {
			logger.debug("Exception caught in SignupDAO.emailExists.\n" + ex);
			return true;
		} finally {
			if(session!=null)
				session.close();
		}
	}
}

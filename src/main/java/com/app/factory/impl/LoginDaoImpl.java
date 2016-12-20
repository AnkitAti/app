package com.app.factory.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.error.ApplicationError;
import com.app.error.ApplicationException;
import com.app.factory.LoginDao;
import com.app.factory.beans.User;

@Repository
public class LoginDaoImpl implements LoginDao {

	private static final Logger logger = LogManager.getLogger(LoginDaoImpl.class);
	private User user;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean extractDetails(String input) {
		logger.trace("Entering constructor of LoginDAO");
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User user WHERE user.username = :username OR user.email = :email" ;
		
		try {
			Query query = session.createQuery(hql).setString("username", input).setString("email", input);
			List<?> list = query.list();
			if(list.size() > 1) {
				throw new ApplicationException(ApplicationError.Error201);
			} 
			if(list.size()==0) {
				user = null;
			}
			else {
				user = (User)list.get(0);
			}
			return true;
		} catch(HibernateException | ApplicationException ex) {
			logger.debug("Exception in LoginDAO.getDetails." , ex);
		} catch(Exception ex) {
			logger.debug("Exception in LoginDAO.getDetails." , ex);
		}
		return false;
	}
	
	
	public boolean login(String password) {
		logger.trace("Entering LoginDAO.login");
		boolean isLoginSuccessful = false;
		//User does not exists with the username
		if(this.user==null) 
			return isLoginSuccessful;
		//password matches 
		if(password!=null && StringUtils.isNotBlank(password) && password.equals(this.user.getPassword()))
			isLoginSuccessful = true;
		logger.trace("Exiting LoginDAO.login");
		return isLoginSuccessful;
	}
	
	
	public String getSalt(){
		logger.trace("Entering LoginDAO.getSalt");
		//If username does not exists
		if(this.user==null) 
			return null;
		return this.user.getSalt();
	}
	
	public String getUserName() {
		logger.trace("Entering LoginDAO.getUserName");
		//If the username-password didn't match
		if(this.user==null)
			return null;
		return this.user.getUsername();
	}
	
	public boolean getUsernameExist() {
		return !(this.user == null);
	}
}

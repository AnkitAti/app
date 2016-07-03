package com.app.factory;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.app.error.ApplicationException;
import com.app.factory.beans.User;
import com.app.factory.interfaces.LoginInterface;

@Service
@Repository
public class LoginDAO implements LoginInterface {

	private static final Logger logger = LogManager.getLogger(LoginDAO.class);
	private User user;
	private boolean usernameExist;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public boolean extractDetails(String input) {
		logger.trace("Entering constructor of LoginDAO");
		Session session = sessionFactory.getCurrentSession();
		String hql = "FROM User user WHERE user.username = :username OR user.email = :email" ;
		
		try {
			Query query = session.createQuery(hql).setString("username", input).setString("email", input);
			ArrayList<User> list = (ArrayList<User>) query.list();
			
			if(list.size() > 1) {
				usernameExist = false;
				throw new ApplicationException();
			} 
			
			if(list.size()==0) {
				user = null;
				usernameExist = false;
			}
			else
				user = list.get(0);
			usernameExist = true;
			return true;
		} catch(HibernateException | ApplicationException ex) {
			logger.debug("Exception in LoginDAO.getDetails." , ex);
		} catch(Exception ex) {
			logger.debug("Exception in LoginDAO.getDetails." , ex);
		}
		finally {
			
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
		if(password.equals(this.user.getPassword()))
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
		return this.usernameExist;
	}
}

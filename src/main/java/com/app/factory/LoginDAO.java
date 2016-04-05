package com.app.factory;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.error.ApplicationException;
import com.app.factory.beans.User;

public class LoginDAO {

	private static final Logger logger = LogManager.getLogger(LoginDAO.class);
	private User user;
	
	@SuppressWarnings("unchecked")
	public LoginDAO(String input) {
		logger.trace("Entering constructor of LoginDAO");
		Session session = Connection.getInstance().openSession();
		String hql = "FROM User user WHERE user.username = :username OR user.email = :email" ;
		Transaction transaction = null;
		try {
			
			transaction = session.beginTransaction();
			Query query = session.createQuery(hql).setString("username", input).setString("email", input);
			ArrayList<User> list = (ArrayList<User>) query.list();
			
			if(list.size() > 1) {
				throw new ApplicationException();
			} 
			
			if(list.size()==0) 
				user = null;
			else
				user = list.get(0);
			transaction.commit();
			
		} catch(HibernateException | ApplicationException ex) {
			if(transaction!=null) 
				transaction.rollback();
			logger.debug("Exception in the constructor of LoginDAO. \n" + ex);
		} catch(Exception ex) {
			if(transaction!=null) 
				transaction.rollback();
			logger.debug("Exception in the constructor of LoginDAO. \n" + ex);
		}
		finally {
			if(session!=null) 
				session.close();
		}
	}
	
	
	/**
	 * This method checks the presence of given username and password combination. 
	 * If it exists then it return true else false.
	 * @param password
	 * @return If the username password combination exists in the database then true else false
	 */
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
	
	
	/**
	 * This metod returns the salt for the username given to it. If the username is not present then it returns null.
	 * @return salt for the given username
	 */
	public String getSalt(){
		logger.trace("Entering LoginDAO.getSalt");
		
		//If username does not exists
		if(this.user==null) 
			return null;
		
		return this.user.getSalt();
	}
}

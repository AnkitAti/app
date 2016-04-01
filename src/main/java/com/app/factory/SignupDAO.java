package com.app.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.factory.beans.User;

public class SignupDAO {

	public static final Logger logger = LogManager.getLogger(SignupDAO.class);
	
	/**
	 * Insert the USER data into the USERS database.
	 * @param user
	 * @return true if insert was successfull else false.
	 */
	public static boolean signupQuery(User user) {
		logger.trace("Entering SignupDAO.signupQuery");
		
		Session session = Connection.getInstance().openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction(); //Start a transaction 
			session.save(user);
			transaction.commit(); //Commit the transaction 
		} 
		
		catch (Exception ex) {
			
			if(transaction!=null) 
				transaction.rollback(); //If anything goes wrong, rollback the transaction 
			
			logger.debug("Exception Caught in SignupDAO.signupQuery whie saving the object in db." + ex);
			return false;
		} 
		
		finally {
			
			if(session!=null)
				session.close(); //Close the session
		}
		
		logger.trace("Exiting SignupDAO.signupQuery");
		return true;  //Return true if everything goes right
	}
}
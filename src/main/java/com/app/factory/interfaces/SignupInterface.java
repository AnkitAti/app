package com.app.factory.interfaces;

import com.app.factory.beans.User;

/**
 * Class for providing the signup facilities in the database.
 * @author Ankit
 * @version 1.0
 */
public interface SignupInterface {
	
	/**
	 * Insert the USER data into the USERS database.
	 * <code>*</code>Service Class is responsible for implementing transactions.
	 * @param user
	 * @return true if insert was successfull else false.
	 */
	public boolean signupQuery(User user);
	
}

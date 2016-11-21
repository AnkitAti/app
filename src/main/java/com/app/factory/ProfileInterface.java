package com.app.factory;

import com.app.error.ApplicationException;
import com.app.factory.beans.UserDescription;

/**
 * Interface for profile related database actions
 * @author Atikant
 *
 */

public interface ProfileInterface {
	
	/**
	 * Set the username of the user to be extracted
	 * @param username
	 */
	public void setUsername(String username);
	
	/**
	 * Extract the user details from UserDescription table
	 * @return
	 * @throws ApplicationException
	 */
	public UserDescription getUserDetails() throws ApplicationException;
}

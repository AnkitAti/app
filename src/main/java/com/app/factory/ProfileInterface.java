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
	 * Extract the user details from UserDescription table
	 * @return
	 * @throws ApplicationException
	 */
	public UserDescription getUserDetails(String username) throws ApplicationException;
}

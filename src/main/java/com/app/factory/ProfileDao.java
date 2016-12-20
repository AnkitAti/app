package com.app.factory;

import com.app.error.ApplicationException;
import com.app.factory.beans.UserDescription;

/**
 * Interface for profile related database actions
 * @author Atikant
 *
 */

public interface ProfileDao {
	public UserDescription getProfileDetails(String username) throws ApplicationException;
}

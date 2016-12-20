package com.app.service;

import com.app.error.ApplicationException;
import com.app.factory.beans.UserDescription;

public interface ProfileService {
	public UserDescription fetchProfileDetails(String username) throws ApplicationException;
}

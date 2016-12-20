package com.app.service;

import com.app.factory.beans.User;

public interface SignupService {
	public boolean signup(User user);
	public boolean usernameExists(String username);
	public boolean emailExists(String email);
}

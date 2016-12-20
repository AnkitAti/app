package com.app.service;

public interface LoginService {
	public boolean validateLogin(String username, String password);
	public boolean usernameExist();
	public String getUserName();
}

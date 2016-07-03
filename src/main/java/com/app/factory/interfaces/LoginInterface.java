package com.app.factory.interfaces;

/**
 * This interface defines the methods of LoginDAO class.
 * @author Ankit
 * @version 1.0
 */

public interface LoginInterface {
	
	/**
	 * Initializes the object to be used for further queries related to login.
	 * @param username
	 * @return true if details are successfully fetched from database, false otherwise.
	 */
	public boolean extractDetails(String username);
	
	/**
	 * Checks and compares the password with the one fetched from database.
	 * @return true if password matches, false otherwise
	 */
	public boolean login(String password);
	
	/**
	 * Retrieves the salt for a user
	 * @return the salt fetched from the database
	 */
	public String getSalt();
	
	/**
	 * Retrieves the Username to be displayed at various places in the page
	 * @return Username
	 */
	public String getUserName();
	
	/**
	 * Checks whether the username exist in the database or not after unsuccessful attempt.
	 * @return boolean true/false username exist or not
	 */
	public boolean getUsernameExist();
}

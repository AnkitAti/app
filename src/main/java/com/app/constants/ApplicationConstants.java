package com.app.constants;

/**
 * Different String constants used throught out the application
 * @author Ankit
 *
 */
public class ApplicationConstants {
	
	//****************List of forward strings to be used in action classes***********************//
	public static final String SUCCESS_FORWARD   =    "success";     //Success forward
	public static final String FAILURE_FORWARD   =    "failure";     //Failure Forward
	public static final String LOGIN_FORWARD     =    "login";       //Requires Login
	public static final String EXCEPTION_FORWARD =    "exception";   //Indicates exception
	//****************List of forward strings to be used in action classes***********************//
	
	
	
	//****************List of keys for messages to be displayed in page**************************//
	public static final String ERROR_MESSAGE_KEY_LOGIN     =      "errorLogin";       //Key for setting Error Messages during login
	public static final String ERROR_MESSAGE_KEY_SIGNUP    =      "errorSignup";      //Key for setting Error Messages during signup
	public static final String ERROR_MESSAGE_KEY           =      "error";            //Key for setting general error messages
	public static final String LOGGED_IN_KEY               =      "loggedIn";         //Key for setting logged in conformation
	public static final String LOGGED_IN_VALUE             =      "true";             //Value for logged in key
	public static final String LOGOUT_VALUE                =      "false";            //Value for Logout
	public static final String USERNAME_KEY                =      "username";         //Key for storing username in session
	//****************List of keys for messages to be displayed in page**************************//
	
	//****************List of Keys for sending parameters or information to page****************//
	public static final String USER_DESC 		=	"userDesc";
	public static final String LOGIN_USERNAME	= 	"usernameLogin";
	public static final String SIGNUP_USERNAME	=	"usernameSignup";
	public static final String SIGNUP_EMAIL		=	"usernameEmail";
	//****************List of Keys for sending parameters or information to page****************//
}

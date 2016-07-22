package com.app.error;

/**
 * This exception is thrown in case of any error in application
 * @author Ankit
 * @version 1.0
 */

public class ApplicationException extends Exception{
	private static final long serialVersionUID = -3053768953513315269L;
	
	//Basic Constructor
	public ApplicationException() {
		super();
	}
	
	//Constructor with a specified message
	public ApplicationException(String msg) {
		super(msg);
	}
	
	//Constructor with a pre-defined message
	public ApplicationException(ApplicationError e) {
		super(e.getErrorMessage());
	}
	
	public ApplicationException(Exception ex) {
		super(ex.getMessage());
	}
}

package com.app.error;

/**
 * This exception is thrown in case of any error in application
 * @author Ankit
 * @version 1.0
 */

public class ApplicationException extends Exception{
	private static final long serialVersionUID = -3053768953513315269L;

	public ApplicationException() {
		super();
	}
	
	public ApplicationException(String msg) {
		super(msg);
	}
}


package com.app.error;

/**
 * This ENUM conatains various error messages.
 * @author Ankit
 * @version 1.0
 */
public enum ApplicationError {
	
	Error201("More than one instance found with the given credentials. Please verify it in database.");
	
	private String errorMessage;
	
	ApplicationError(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	String getErrorMessage() {
		return this.errorMessage;
	}
}

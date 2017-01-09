package com.app.util;

public class FormValidation {
	
	public static boolean validateField(String field) {
		return true;
	}
	
	public static boolean validateEmail(String email) {
		return true;
	}
	
	public static boolean validateUsername(String email) {
		
		return true;
	}
	
	public static boolean validatePassword(String password) {
		if(password.length() < 5 || password.length() > 20) {
			return false;
		}
		for(int i=0; i<password.length(); i++) {
			
		}
		return true;
	}
}

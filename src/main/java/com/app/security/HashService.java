package com.app.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This class provides the hashing service for various parts of application.
 * Different methods are provided to hash the text using different algorithms.
 * @author Ankit
 * @version 1.0
 */
public class HashService {

	private static final Logger logger = LogManager.getLogger(HashService.class);
	private static final Random RANDOM = new SecureRandom();
	/**
	 * SHA256 implementation 
	 * @param message
	 * @return String of SHA256 hash of the message
	 */
	public static String sha256Hash(String message) throws NoSuchAlgorithmException {
		logger.trace("Entering HashService.sha256Hash");
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(message.getBytes(StandardCharsets.UTF_8));
			
			return convert(hash);
		} catch(NoSuchAlgorithmException ex) {
			logger.debug("Exception thrown. " + ex);
			throw ex;
		}	
	}
	
	public static String getSalt() {
		byte[] salt = new byte[16];
		RANDOM.nextBytes(salt);
		return convert(salt);
	}
	
	public static String convert(byte[] arr) {
		 //convert the byte to hex format
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<arr.length;i++) {
    		String hex=Integer.toHexString(0xff & arr[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	
    	return hexString.toString();
	}
}

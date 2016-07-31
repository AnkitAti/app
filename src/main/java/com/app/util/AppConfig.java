package com.app.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

import com.app.constants.PropertiesConstants;

/**
 * Reads the configuration from properties file
 * @author Ankit
 *
 */

public class AppConfig implements ServletContextListener {

	private static PropertiesConfiguration config;

	public static void loadConfig() {
		try {
			config = new PropertiesConfiguration(PropertiesConstants.FILE_NAME);
			config.setReloadingStrategy(new FileChangedReloadingStrategy());
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		
	}
	
	public static String getProperty(String key) {
		return (String) config.getProperty(key);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
			
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		loadConfig();
		
	}
}

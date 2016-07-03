package com.app.factory;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Create instances of Session Factory to be used for executing query,
 * <b>This class is not used anywhere. This class is replaced by Spring datasource and DI.</b>
 * @author Ankit
 * @version 1.0
 */
public class Connection {

	private static SessionFactory sessionFactory;
	private static final Logger logger = LogManager.getLogger(Connection.class);
	
	
	public static SessionFactory getInstance() {
		try {
			if(sessionFactory==null) {
				sessionFactory = new Configuration().configure().buildSessionFactory();
			}
			return sessionFactory;
		}
		
		catch(Throwable ex) {
			ex.printStackTrace();
			logger.debug("Exception while creating Session Factory", ex);
			return null;
		}
		
	}
}

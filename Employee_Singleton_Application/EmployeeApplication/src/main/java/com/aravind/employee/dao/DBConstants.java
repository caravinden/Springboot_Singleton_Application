package com.aravind.employee.dao;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class that helps to read database properties 
 * 
 * @author aravind
 * @date 30-09-2014
 *
 */

public class DBConstants {

	public DBConstants() {
	}
	
	public static final String PROPERTY_FILE = "db";
	private static ResourceBundle bundle;
	public static String DB_CONNECTION = "db.connection"; 

	public static String DB_USER = "db.user";

	public static String DB_PASSWORD = "db.password";

	public static String DB_DRIVER = "db.driver";

	public static String DB_AUTO_COMMIT = "db.auto.commit";
	static {
		try {
			bundle = ResourceBundle.getBundle(PROPERTY_FILE);
			DB_CONNECTION = bundle.getString(DB_CONNECTION);
			DB_USER = bundle.getString(DB_USER);
			DB_PASSWORD = bundle.getString(DB_PASSWORD);
			DB_DRIVER = bundle.getString(DB_DRIVER); 
			DB_AUTO_COMMIT = bundle.getString(DB_AUTO_COMMIT);
		} catch (MissingResourceException e) {
			e.printStackTrace();
			//log here
		}
	}
}

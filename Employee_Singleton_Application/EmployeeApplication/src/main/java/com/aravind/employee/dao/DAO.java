package com.aravind.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Data access layer class that helps to make initial database connection
 * @author aravind
 * @date 30-09-2014
 *
 */

public class DAO {

	protected Connection connection = null;
	private static final DAO dao = new DAO();
	private static final String connectionUrl = DBConstants.DB_CONNECTION;
	private static final String userName = DBConstants.DB_USER;
	private static final String password = DBConstants.DB_PASSWORD;

	private static final Logger logger = Logger.getLogger(DAO.class.getName());

	protected DAO() {
		try {
			Class.forName(DBConstants.DB_DRIVER);
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * 
	 * Making it private as will be called from subclass
	 * @return
	 */
	public static DAO getInstance() {
		return dao;
	}

	protected void connect() {
		try {
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(connectionUrl,
						userName, password);
				connection.setAutoCommit(DBConstants.DB_AUTO_COMMIT.equals("true"));
			}
		} catch (SQLException e) {
			logger.log(Level.SEVERE, null, e);
		}
	}

	protected void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			logger.log(Level.SEVERE, null, e);
		}
	}
}

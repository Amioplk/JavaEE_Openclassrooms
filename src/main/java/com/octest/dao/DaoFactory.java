package com.octest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DaoFactory {

	private String url;
	private String username;
	private String password;
	
	
	public DaoFactory(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public static DaoFactory getInstance() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		DaoFactory instance = new DaoFactory(
				"jdbc:mysql://localhost:3306/javaee", "root", "root"
		);
		return instance;
	}
	
	public Connection getConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url, username, password);
		connection.setAutoCommit(false);
		return connection;
	}
	
	public UtilisateurDao getUtilisateurDao() {
		return new UtilisateurDaoImpl(this);
	}
	
}

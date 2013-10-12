package com.pb.project.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SybaseConnection {
	
	private static final String JDBC_DRIVER = "com.sybase.jdbc3.jdbc.SybDriver";
	private static final String DB_URL = "jdbc:sybase:Tds:ira:5000/study";
	private static final String USER_NAME = "sa";
	private static final String USER_PASSWORD = "";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName(JDBC_DRIVER);
		return DriverManager.getConnection(DB_URL, USER_NAME, USER_PASSWORD);
	}
}
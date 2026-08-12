package com.mfwp.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnectionUtil {

public static Connection getDatabaseConnection(){
		
		Connection connection = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dermarx", "root", "root");
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
		
	}
}

package com.mfwp.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnectionUtil {


		
	public static Connection getDataBaseConnection() {
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		
			connection = DriverManager.getConnection(
	                ""
	            );
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
		
	
}

package com.mfwp.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnectionUtil {


		
	public static Connection getDataBaseConnection() {
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		
			connection = DriverManager.getConnection(
	                "jdbc:mysql://gateway01.ap-southeast-1.prod.aws.tidbcloud.com:4000/DermaRX",
	                "2w4dYu6TWWXpbbH.root",
	                "7Xd0OanmiGnWdFYv"
	            );
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
		
	
}

package com.mfwp.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mfwp.entity.User;
import com.mfwp.util.DbConnectionUtil;


public class UserRepository {

public int saveUser(User user) {
		
		int rowsUpdated =0;
		Connection connection = null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet =null;
		try {
			connection  = DbConnectionUtil.getDataBaseConnection();
			
			
			
			
			String roleQuery ="SELECT role_id from UserRole where role_name = 'user'";
			preparedStatement = connection.prepareStatement(roleQuery);
			resultSet = preparedStatement.executeQuery();
			
			Long roleId  = null;
			while(resultSet.next()) {
				roleId = resultSet.getLong("role_id");

				break;
			}
			System.out.println(resultSet.getLong("role_id"));
			
			String query = "";
//			query = "INSERT INTO User (email,password,mobile_number,role_id) VALUES (?,?,?,?)";
			
			if(user.getEmail() == null) {
				query = "INSERT INTO user (password, mobile_number, role_id) VALUES (?,?,?)";
				
				preparedStatement = null;
				
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, user.getPassword());
				preparedStatement.setString(2, user.getMobileNumber());
				preparedStatement.setLong(3, roleId);
			
			}else {
				query = "INSERT INTO user (Password, Email, Role_id) VALUES (?,?,?)";
				
				preparedStatement = null;
				
				preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, user.getPassword());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setLong(3, roleId);
				
			}
			

			rowsUpdated = preparedStatement.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace(); 
		}
		finally {
			
			try {
			connection.close();
			
			preparedStatement.close();
			
			resultSet.close();
			}
			catch (SQLException e) {
				e.printStackTrace(); 
			}
		}
		
		return rowsUpdated;
	}
	
	
	public boolean checkifEmailExists(User user) {
		
		try {
		Connection connection  = DbConnectionUtil.getDataBaseConnection();
		
//		String query ="SELECT 1 FROM user WHERE email = ? LIMIT 1";
		String query ="SELECT 1 FROM user WHERE Email = ? LIMIT 1";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1,user.getEmail());
		ResultSet resultSet=preparedStatement.executeQuery();
		
		return resultSet.next();
		
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
		
		return false;
	}
	
	public boolean checkifMobileNumberExists(User user) {
		
		try {
		Connection connection  = DbConnectionUtil.getDataBaseConnection();
		
//		String query ="SELECT 1 FROM user WHERE mobile_number = ? LIMIT 1";
		String query ="SELECT 1 FROM user WHERE mobile_number = ? LIMIT 1";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1,user.getMobileNumber());
		ResultSet resultSet=preparedStatement.executeQuery();
		
		return resultSet.next();
		
		}
		catch (Exception e) {
			e.printStackTrace(); 
		}
		return false;
	}
	
	public boolean isValidUser(User user) {
		
		try {
			Connection connection  = DbConnectionUtil.getDataBaseConnection();
			
			
			
			String query = "";
			PreparedStatement preparedStatement = null;
		//	String query = "SELECT 1 FROM user WHERE (mobile_number = ? AND password=?) OR (email = ? AND password=?) LIMIT 1";
			
			
			if(user.getEmail() == null) {
				query = "SELECT user_id FROM user WHERE (mobile_number = ? AND Password = ?) LIMIT 1";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,user.getMobileNumber());
				preparedStatement.setString(2,user.getPassword());
				
			
			}else {
				query = "SELECT user_id FROM user WHERE (Email = ? AND Password = ?) LIMIT 1";
				preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1,user.getEmail());
				preparedStatement.setString(2,user.getPassword());
				
			}
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				user.setUserId(resultSet.getLong("user_id"));
				return true;
			}
			
			}catch (Exception e) {
				e.printStackTrace(); 
			
			}
			
		return false;
	}
	
	
	
	public List<User> getAllUsers() {
		
		List<User> userList = new ArrayList<>();
	try {
		Connection connection = DbConnectionUtil.getDataBaseConnection();
		
		
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from user");
		
		ResultSet resultSet=preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			Long id=resultSet.getLong("user_id");
			String email=resultSet.getString("email").trim();
			String password=resultSet.getString("password").trim();
			String mobileNumber=resultSet.getString("mobile_number").trim();
			
			User user = new User();
			user.setUserId(id);
			user.setEmail(email);
			user.setMobileNumber(mobileNumber);
			user.setPassword(password);
			
			userList.add(user);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	 return userList;
	}

}
